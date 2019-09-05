package com.lex.assiment;

import static org.junit.Assert.*;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class capture_screeshot {
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
		driver.close();
	}

	@Test
	public void test() throws AWTException {
		//Screenshot command for application
		File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, new File("G:\\selenium_Automation_learn\\ScreenShot_Demo\\Image.png"));
			String fileName=getClass().getSimpleName();
			Toolkit toolKit= Toolkit.getDefaultToolkit();
			Rectangle screenSize=new Rectangle(0, 0, toolKit.getScreenSize().width, toolKit.getScreenSize().height);
			Robot robot= new Robot();
			BufferedImage buffImage=robot.createScreenCapture(screenSize);
			ImageIO.write(buffImage, "png", new File("G:\\selenium_Automation_learn\\ScreenShot_Demo\\Image1.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("exception "+e.getMessage());
		}
		//ScreenShot command for desktop
		
		
		
	}

}
