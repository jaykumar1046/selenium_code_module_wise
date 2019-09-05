package com.lex.assiment;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Library_file {
	
public void selectFromDropDown(WebDriver driver,String xPath,String value) {
		WebElement dropDownElement=driver.findElement(By.xpath(xPath));
		Select select_element=new Select(dropDownElement);
		select_element.selectByVisibleText(value);
	}
public void selectRadioButton(WebDriver driver,String Value) {
	driver.findElement(By.xpath(Value)).click();
	}



public XSSFSheet excelAutomation(String path) {
	FileInputStream fileStream;
	XSSFWorkbook workBook;
	XSSFSheet workSheet=null;
	try {
		fileStream=new FileInputStream(path);
		workBook=new XSSFWorkbook(fileStream);
		workSheet=workBook.getSheet("Sheet1");
		int rowCount = workSheet.getLastRowNum()-workSheet.getFirstRowNum();
		System.out.println("Printing the number of rows to be worked on "+ rowCount );
		
		
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println(e.getMessage());
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println(e.getMessage());
	}
	
	return workSheet;
	
	
	
	
	}

public Select DropDownSelect(WebDriver driver, String Element)
{
	WebElement ddDepFrom=driver.findElement(By.xpath(Element));
	Select selectDepFrom=new Select(ddDepFrom);
	return selectDepFrom;
	
}


}


