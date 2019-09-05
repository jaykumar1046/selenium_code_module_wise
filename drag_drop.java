package com.lex.assiment;

import static org.junit.Assert.*;

import java.awt.Desktop.Action;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class drag_drop {
	WebDriver driver;
	Library_file LfileObj;
	utilites_File ufileObj;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "G:\\selenium_Automation_learn\\selenium jar file and driver_jdk\\driver\\chromedriver_win32\\chromedriver.exe");
		ufileObj=new utilites_File();
		driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get(ufileObj.getUrl_dragndrop());
		driver.manage().timeouts().implicitlyWait(50000, TimeUnit.MILLISECONDS);

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		WebElement fromElement = null;
		WebElement toElement = null;
		int count=0;
		final List<WebElement> frame_dragdrop= driver.findElements(By.tagName("iframe"));
		System.out.println(frame_dragdrop.size());
		for (WebElement fmdd: frame_dragdrop) {
			System.out.println(++count);
			//System.out.println(fmdd.getAttribute("class"));
			//System.out.println(fmdd.getAttribute("src"));
			System.out.println(fmdd.getLocation());
			
			if (fmdd.getAttribute("src").contains("photo-manager")) {
				System.err.println(fmdd.getAttribute("src"));
				System.out.println("m in index of "+ frame_dragdrop.indexOf(fmdd));
				driver.switchTo().frame(frame_dragdrop.indexOf(fmdd));
				List<WebElement> classElements=driver.findElements(By.tagName("li"));
				for (WebElement classElement : classElements) {
					System.out.println(classElement.getAttribute("class")+ " Printing Class name");
					
				}
				fromElement=driver.findElement(By.xpath("//*[@id=\"gallery\"]/li[3]"));
				
				toElement= driver.findElement(By.xpath("//*[@id=\"trash\"]"));
			}
		}
		driver.switchTo().parentFrame();	
		System.out.println(fromElement.getAttribute("class"));
		System.out.println(toElement.getAttribute("class"));
		
		Actions action =new Actions(driver);
		
		action.dragAndDrop(fromElement, toElement).perform();
		
		
	}

}
