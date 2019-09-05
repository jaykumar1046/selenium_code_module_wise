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

public class Alert_Prompts_Confirmation_popUp {
	WebDriver driver;
	Library_file LfileObj;
	utilites_File ufileObj;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "G:\\selenium_Automation_learn\\selenium jar file and driver_jdk\\driver\\chromedriver_win32\\chromedriver.exe");
		ufileObj=new utilites_File();
		driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get(ufileObj.getUrl_popup());
		driver.manage().timeouts().implicitlyWait(50000, TimeUnit.MILLISECONDS);

	}

	@After
	public void tearDown() throws Exception {
		//driver.close();
	}

	@Test
	public void test() {
		driver.findElement(By.xpath("//button[@id='onesignal-popover-cancel-button']")).click();
		
		final List<WebElement> framename = driver.findElements(By.tagName("iframe"));
		System.out.println(framename.size());
		for (WebElement frm:framename) {
			System.out.println(frm.findElement(By.xpath("//input[@class='button']")).getAttribute("type"));
		}
		
	}

}
