package com.lex.assiment;

import static org.junit.Assert.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class webTable_other_element {
	WebDriver driver;
	utilites_File file_obj;
	Library_file lFile_obj;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "G:\\selenium_Automation_learn\\selenium jar file and driver_jdk\\driver\\chromedriver_win32\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		file_obj=new utilites_File();
		lFile_obj=new Library_file();
		driver.get(file_obj.getURL());
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		wait(200);
		Thread.sleep(2000);
	}

	@After
	public void tearDown() throws Exception {
		//driver.findElement(By.xpath("//td[@class='mouseOut']")).click();
		//driver.close();
	}

	@Test
	public void test() {
		try {
			file_obj=new utilites_File();
			driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(file_obj.getLoginId());
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys(file_obj.getPassword());
			driver.findElement(By.xpath("//input[@type='image']")).click();
			driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
			String pageTitle=driver.getTitle();
			System.out.println("Actual Title"+pageTitle);
			
			WebElement dropDownElement_passengerCount=driver.findElement(By.name("passCount"));
			Select dropDownSelect=new Select(dropDownElement_passengerCount);
			dropDownSelect.selectByIndex(2);
			
			lFile_obj.selectFromDropDown(driver, "//select[@name='fromPort']", "Paris");
			
			lFile_obj.selectFromDropDown(driver, "//select[@name='fromMonth']", "October");

			lFile_obj.selectFromDropDown(driver, "//select[@name='fromDay']", "31");
			
			lFile_obj.selectFromDropDown(driver, "//select[@name='toPort']", "Frankfurt");
			
			lFile_obj.selectFromDropDown(driver, "//select[@name='toMonth']", "February");
			
			lFile_obj.selectFromDropDown(driver, "//select[@name='toDay']", "28");
			
			lFile_obj.selectRadioButton(driver, "//input[@value='Business']" );
			
			driver.findElement(By.name("findFlights")).click();
			
			WebElement formElemnt=driver.findElement(By.xpath("//form[@name='results']"));
			
			WebElement tblDepartDetails=formElemnt.findElement(By.tagName("table"));
			List<WebElement> rows =tblDepartDetails.findElements(By.xpath("//td[@class='data_left']"));
				
			System.out.println(rows.size());
			for (WebElement clas: rows) {
				System.out.println("Flight Name:-" + clas.getText());
			}
			/*for (WebElement rw: rows) {
				List<WebElement> cols= rw.findElements(By.tagName("td"));
				List<WebElement> timeForFlight= rw.findElements(By.xpath("//td[@class='data_left']"));
				for (WebElement clas: timeForFlight) {
					System.out.println("Flight Name:-" + clas.getText());
				}
				//for (WebElement cls: cols) {
					//System.out.println("Column value: "+ cls.getText());
					
				//}
			}*/
			
			
			
						
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
