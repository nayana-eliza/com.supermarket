package com.supermarket.utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GeneralUtilities {
	WebDriver driver;
	public WebDriver browserLaunch(String url,String browser)
	{
	if(browser.equalsIgnoreCase("edge"))
	{
	WebDriverManager.edgedriver().setup();
    driver= new EdgeDriver();
	}
	else if(browser.equalsIgnoreCase("chrome"))
	{
	WebDriverManager.chromedriver().setup();
	driver= new ChromeDriver();
	}
	else
	{
	System.out.println("Please check the browser you have entered");
	}
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.get(url);
	return driver;
	}
	
	public void takeScreenshotCommand(WebDriver driver,String testcaseName) throws IOException
	
	{
	Date d = new Date();
	String date=d.toString().replace(":", "_").replace(",", "_");	
	TakesScreenshot ts = (TakesScreenshot)driver;
	File sourcefile = ts.getScreenshotAs(OutputType.FILE);
	FileHandler.copy(sourcefile,new File("./ScreenShots/"+ testcaseName +"_"+date+".jpg"));  //("./FOLDERNAME/"+"FILENAME")
	}
	
	public void clickCommand(WebElement element)
	{
		element.click();
	}
	
	public void clearCommand(WebElement element)
	{
		element.clear();
	}
	
	
	public void sendkeysCommand(WebElement element,String text)
	{
		element.sendKeys(text);;
	}
	
	public boolean isDisplayedCommand(WebElement element)
	{
		boolean value =element.isDisplayed();
		return value;
		
	}
	
	public void isSelectedCommand(WebElement element)
	{
		element.isSelected();
	}
	
	public void isEnabledCommand(WebElement element)
	{
		element.isEnabled();
	}
	
	public void moveToCommand(WebElement element)
	{
		Actions obj = new Actions(driver);
		obj.moveToElement(element).build().perform();
	}
	
	public void doubleclickCommand(WebElement element)
	{
		Actions obj = new Actions(driver);
		obj.doubleClick().perform();
	}
	
	public void AlertAcceptCommand(WebDriver driver)
	{
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	
	public void AlertDismissCommand(WebDriver driver)
	{
		Alert alert = driver.switchTo().alert();
		alert.dismiss();	
	}
	
	public void promptAlertCommand(WebDriver driver,String text)
	{
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(text);
		alert.accept();
	}
	
	public void enterKey() throws AWTException
	{
		Robot robot = new Robot();
		robot.delay(250);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.delay(250);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
	

    public void dropdownSelectbyVisibleText(WebElement element,String text)
    {
    	Select obj= new Select(element);
    	obj.selectByVisibleText(text);
    }
    
//    public void checkDynamicTablecell(WebElement row,WebElement cell)
//    {
//    	List<WebElement> rows1 = driver.findElements(By.xpath("//table[@class='ws-table-all']/tbody/tr"));
//  	  int rowcount= rows1.size();                       //to find size
//  	  System.out.println(rowcount);
//  	  List<WebElement> column1 = driver.findElements(By.xpath("//table[@class='ws-table-all']/tbody/tr[2]/td"));
//  	  int columnsize = column1.size();
//  	  System.out.println(columnsize);
//  	  for(int i=2;i<=6;i++)
//  	  {
//  		  for(int j=1;j<=3;j++)
//  		  {
//  			  String Webdata= driver.findElement(By.xpath("//table[@class='ws-table-all']/tbody/tr["+i+"]/td["+j+"]")).getText();
//  			  System.out.println(Webdata);
//  		  }
//  	  }
//    }
//    
    
    }