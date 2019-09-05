package com.lex.assiment;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
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
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Ajax_handeling {
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
		// driver.close();
	}

	@Test
	public void test() throws InterruptedException, IOException {
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
		
		
		 

	}

}
