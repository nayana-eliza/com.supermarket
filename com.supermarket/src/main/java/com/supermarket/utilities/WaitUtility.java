package com.supermarket.utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
	public void implicitWaitCommand(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	public void eWPresenceOfElement(WebDriver driver,WebElement element,int d)
	{ 
		WebDriverWait explicitwait = new WebDriverWait(driver,Duration.of(d, null));
		explicitwait.until(ExpectedConditions.visibilityOf(element));
	}

	public void eWToBeClickableCommand(WebDriver driver,WebElement element)
	{ 
		WebDriverWait explicitwait = new WebDriverWait(driver,Duration.ofSeconds(5));
		explicitwait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void explicitWaitSelectedCommand(WebDriver driver,WebElement element,int d)
	{ 
		WebDriverWait explicitwait = new WebDriverWait(driver,Duration.of(d, null));
		explicitwait.until(ExpectedConditions.elementToBeSelected(element));
	}
		
	
	public void fluentWaitCommand(WebDriver driver,WebElement element,int d,int p) {
		  Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)    //wait interface
				  .withTimeout(Duration.ofSeconds(d))     //actual waiting time  10/2, so it loads for 5 seconds then waits for 2
				  .pollingEvery(Duration.ofSeconds(p))
				  .ignoring(Exception.class);
		  wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy((By)element));
	}
}
