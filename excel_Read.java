package com.lex.assiment;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.WorksheetDocument;

public class excel_Read {
	utilites_File utilObj;
	Library_file libObj;
	WebDriver driver;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "G:\\selenium_Automation_learn\\selenium jar file and driver_jdk\\driver\\chromedriver_win32\\chromedriver.exe");
		utilObj= new utilites_File();
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(utilObj.getURL());
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
	}

	@After
	public void tearDown() throws Exception {
	}

	@SuppressWarnings("deprecation")
	@Test
	public void test() throws IOException {
		String excelPath="C:\\Users\\hp\\Desktop\\New_Microsoft_Excel_Worksheet.xlsx";
		Cell item;
		String str;
		System.out.println(driver.getTitle());
		
		driver.findElement(By.name("userName")).sendKeys("tutorial");
		driver.findElement(By.name("password")).sendKeys("tutorial");
		driver.findElement(By.name("login")).click();
		
		String[] xpath= new String[] {"//select[@name='passCount']","//select[@name='fromPort']","//select[@name='fromMonth']",};
		
		//XSSFSheet workSheet=libObj.excelAutomation(excelPath);
		
		FileInputStream fileStream=new FileInputStream(excelPath);
		XSSFWorkbook workBook=new XSSFWorkbook(fileStream);
		XSSFSheet workSheet=workBook.getSheet("Sheet1");
		
		int rowCount = workSheet.getLastRowNum()-workSheet.getFirstRowNum()+1;
		System.out.println("Printing the number of rows to be worked on "+ rowCount );
		
		//int rowCount=workSheet.getLastRowNum()-workSheet.getFirstRowNum();
		//int rowCount=2;
		for (int i = 1; i <= rowCount-1; i++) {
			
			List<WebElement> radiobuttons= driver.findElements(By.xpath("//input[@name='tripType']"));
			for (WebElement radiobutton : radiobuttons) {
				if (workSheet.getRow(i).getCell(0).getStringCellValue().toLowerCase().equals(radiobutton.getAttribute("value"))){
					radiobutton.click();
				}
			}
			
				item=workSheet.getRow(i).getCell(1);				
				item.setCellType(CellType.STRING);
				str=item.getStringCellValue();				
				//System.out.println("String value  "+ str);
				
				WebElement ddPassCount=driver.findElement(By.xpath("//select[@name='passCount']"));
				Select selectPassCount=new Select(ddPassCount);
				selectPassCount.selectByValue(str);
				
				item=workSheet.getRow(i).getCell(2);
				item.setCellType(CellType.STRING);
				str=item.getStringCellValue();				
				//System.out.println("String value  "+ str);
				
				WebElement ddDepFrom=driver.findElement(By.xpath("//select[@name='fromPort']"));
				Select selectDepFrom=new Select(ddDepFrom);
				selectDepFrom.selectByValue(str);
				
				
				item=workSheet.getRow(i).getCell(3);
				item.setCellType(CellType.STRING);
				str=item.getStringCellValue();				
				//System.out.println("String value  "+ str.split("th ")[1]);
				WebElement selectmonth=driver.findElement(By.xpath("//select[@name='fromMonth']"));
				Select selectDepmonth=new Select(selectmonth);
				selectDepmonth.selectByVisibleText(str.split("th ")[1]);
				
				
				item=workSheet.getRow(i).getCell(3);
				item.setCellType(CellType.STRING);
				str=item.getStringCellValue();				
				//System.out.println("String value  "+ str.split("th ")[0]);
				WebElement selectday=driver.findElement(By.xpath("//select[@name='fromDay']"));
				Select selectDepDayh=new Select(selectday);
				//selectDepDayh.deselectByVisibleText("13");
				selectDepDayh.selectByVisibleText( str.split("th ")[0]);
				
				item=workSheet.getRow(i).getCell(4);
				item.setCellType(CellType.STRING);
				str=item.getStringCellValue();				
				//System.out.println("String value  "+ str);
				WebElement selectarrto=driver.findElement(By.xpath("//select[@name='toPort']"));
				Select selectto=new Select(selectarrto);
				selectto.selectByValue(str);

				item=workSheet.getRow(i).getCell(5);
				item.setCellType(CellType.STRING);
				str=item.getStringCellValue();				
				//System.out.println("String value  "+ str.split("th ")[1]);
				WebElement selecttoMonth=driver.findElement(By.xpath("//select[@name='toMonth']"));
				Select selecttoMon=new Select(selecttoMonth);
				selecttoMon.selectByVisibleText(str.split("th ")[1]);
				

				item=workSheet.getRow(i).getCell(5);
				item.setCellType(CellType.STRING);
				str=item.getStringCellValue();				
				//System.out.println("String value  "+ str);
				WebElement selecttoDay=driver.findElement(By.xpath("//select[@name='toDay']"));
				Select selecttoday=new Select(selecttoDay);
				selecttoday.selectByVisibleText(str.split("th ")[0]);
				
			
				List<WebElement> radiobuttonClass= driver.findElements(By.xpath("//input[@name='servClass']"));
				
				for (WebElement rdbuttonClass : radiobuttonClass) {
					//System.out.println(rdbuttonClass.getAttribute("value"));
					if (workSheet.getRow(i).getCell(6).getStringCellValue().equals(rdbuttonClass.getAttribute("value"))){
						rdbuttonClass.click();
					}
				}
				
				
				item=workSheet.getRow(i).getCell(7);
				item.setCellType(CellType.STRING);
				str=item.getStringCellValue();				
				//System.out.println("String value  "+ str);
				WebElement selectpref=driver.findElement(By.xpath("//select[@name='airline']"));
				Select selectPref=new Select(selectpref);
				selectPref.selectByVisibleText(str);
								
				driver.findElement(By.xpath("//input[@name='findFlights']")).click();
				List<WebElement>tableElement=driver.findElements(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[1]"));
				
				for (WebElement tabEle : tableElement) {
					//System.out.println(tabEle.getSize());
					List<WebElement> tabledata=tabEle.findElements(By.tagName("tr"));
					for (WebElement tabData : tabledata) {
						System.out.println(tabData.getSize());
						List<WebElement> tablerow=tabData.findElements(By.tagName("td"));
						for (WebElement data : tablerow) {
							System.out.print(data.getText());	
							item=workSheet.getRow(i).getCell(7);
							item.setCellType(CellType.STRING);
							str=item.getStringCellValue();
							if(str.equals(data.getText()))
								{
									
								}
							}
					System.out.println(" ");
					}
					
				}
							
				//System.out.println("String value  "+ str);
				
				
			}
		}
		
	}


