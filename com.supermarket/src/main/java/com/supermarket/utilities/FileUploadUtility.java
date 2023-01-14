package com.supermarket.utilities;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FileUploadUtility {
	
	public void fileUploadCommand(WebElement element,String filepath) {
		 element.sendKeys(filepath);   
	  }
	
	public void robotClassFileUpload(WebElement element, String fileupload)throws Exception {
		  StringSelection s= new StringSelection(fileupload);
		  Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s, null);
		  element.click();
		 Robot robot=new Robot();
		  robot.delay(250);
		  robot.keyPress(KeyEvent.VK_ENTER);
		  robot.delay(250);
		  robot.keyRelease(KeyEvent.VK_ENTER);
		  robot.delay(250);
		  robot.keyPress(KeyEvent.VK_CONTROL);
		  robot.keyPress(KeyEvent.VK_V);
		  robot.delay(250);
		  robot.keyRelease(KeyEvent.VK_CONTROL);
		  robot.keyRelease(KeyEvent.VK_V);
		  robot.delay(250);
		  robot.keyPress(KeyEvent.VK_ENTER);
		  robot.delay(250);
		  robot.keyRelease(KeyEvent.VK_ENTER);
		  robot.delay(250);
	}
		  

}
