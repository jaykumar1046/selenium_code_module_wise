package com.lex.assiment;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class frameHandeling {
	WebDriver driver;
	Library_file LfileObj;
	utilites_File ufileObj;

	@Before
	public void setUp() throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "G:\\selenium_Automation_learn\\selenium jar file and driver_jdk\\driver\\chromedriver_win32\\chromedriver.exe");
		ufileObj=new utilites_File();
		driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get(ufileObj.getUrl_Frame());
		
	}

	@After
	public void tearDown() throws Exception {
		//driver.close();
	}

	@Test
	public void test() {
		System.out.println("page Title : "+ driver.getTitle());
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//i[@class='icon-align-justify']")).click();
		WebElement dropDowm= driver.findElement(By.xpath("//ul[@id='menu-page-menu-1']"));
		List<WebElement> dropDwonElement= dropDowm.findElements(By.xpath("//a[@herf='#' or 'http://5elementslearning.com/index.php']"));
		for (WebElement dd: dropDwonElement) {
			System.out.println(dd.getText());
		}
		
		System.out.println("Print text from footer without switching between frames");
		WebElement pageFooterText=driver.findElement(By.xpath("//div[@id='stay-connected']"));
		System.out.println(pageFooterText.findElement(By.tagName("p")).getText());
	}

}
