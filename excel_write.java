package com.lex.assiment;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class excel_write {
	WebDriver driver;
	utilites_File util_Obj;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "G:\\selenium_Automation_learn\\selenium jar file and driver_jdk\\driver\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://phptravels.com");
		driver.manage().timeouts().implicitlyWait(50000, TimeUnit.MILLISECONDS);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws IOException, InterruptedException {
		System.out.println(driver.getTitle());
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"normal-popover\"]/div[1]/div[2]"))));
		//System.out.println(driver.findElement(By.xpath("//*[@id=\"normal-popover\"]/div[1]/div[2]")).getText());
		driver.findElement(By.id("onesignal-popover-cancel-button")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"PopupSignupForm_0\"]/div[2]/div[1]")).click();
		//System.out.println(driver.findElement(By.xpath("/html/body/main/section[2]/div/div/div/a")).getText());
		WebElement fElem=driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[4]/span/span"));
		WebElement tElem=driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[4]/div/ul/li[2]/a"));
		Actions act=new Actions(driver);
		act.moveToElement(fElem).moveToElement(tElem).click().build().perform();
		
		String filepath="C:\\Users\\hp\\Desktop\\New_Microsoft_Excel_Worksheet.xlsx";
		FileInputStream fileStream = new FileInputStream(filepath);
		XSSFWorkbook workBook = new XSSFWorkbook(fileStream);
		XSSFSheet workSheet= workBook.getSheet("Sheet2");
		
		//Row newRow = workSheet.getRow(2);
		
			
		
		driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div[1]/div[7]/a/div")).click();
		//driver.findElement(By.id("docsQuery")).sendKeys("ABCD");
		WebElement table=driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div[2]/div/p/table"));
		List<WebElement> rows=table.findElements(By.tagName("tr"));
		
		for (int j = 0; j < rows.size(); j++) {
			Row newrow= workSheet.createRow(j);
			List<WebElement> cols= rows.get(j).findElements(By.tagName("td"));
			for (int k = 0; k < cols.size(); k++) {
				Cell cell=newrow.createCell(k);
				cell.setCellValue(cols.get(k).getText());	
				System.out.print(cols.get(k).getText()+"    ");
			}
			System.out.println("    ");
		}
//		for (WebElement row : rows) {
//			List<WebElement> cols = row.findElements(By.tagName("td"));
//			for (WebElement col : cols) {
//				System.out.print(col.getText()+"    ");
//				
//			}
//			
//			
//		}
		fileStream.close();
		FileOutputStream outputStream= new FileOutputStream(filepath);
		workBook.write(outputStream);
		outputStream.close();
		
		driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[8]/a/span")).click();
		ArrayList<String> tabs= new ArrayList<String>(driver.getWindowHandles());
		for (int i = 0; i < tabs.size(); i++) {
			System.out.println(tabs.get(i));
			
		}
		
		for (String tab : tabs) {
			//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"login\"]"))));
			driver.switchTo().window(tab);
			System.out.println(driver.getTitle());
			
		}
		driver.findElement(By.xpath("//*[@id=\"recaptcha-anchor\"]/div[1]")).click();
		
		
		
		
	}

}
