package com.lex.assiment;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Lex_assisment_1 {
	WebDriver driver;
	utilites_File file_obj;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "G:\\selenium_Automation_learn\\selenium jar file and driver_jdk\\driver\\chromedriver_win32\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		file_obj=new utilites_File();	
		driver.get(file_obj.getURL());
		
	}

	@After
	public void tearDown() throws Exception {
		driver.findElement(By.xpath("//td[@class='mouseOut']")).click();
		driver.close();
	}
//assert function usage.
	@Test
	public void test() {
		try {
			file_obj=new utilites_File();
			driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(file_obj.getLoginId());
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys(file_obj.getPassword());
			driver.findElement(By.xpath("//input[@type='image']")).click();
			String pageTitle=driver.getTitle();
			System.out.println("Actual Title"+pageTitle);
			Assert.assertEquals(pageTitle, "Find a Flight: Mercury Tours:");
			System.out.println("changing assert method");
			Assert.assertEquals(pageTitle, "Find a Flight: Mercury Tours");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
