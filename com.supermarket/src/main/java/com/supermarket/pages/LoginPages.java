package com.supermarket.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPages {
	WebDriver driver;
	//input[@name='username']
    //input[@name='password']
	//button=[text()='Sign In']
	//div[@class='alert alert-danger alert-dismissible']
	
	public LoginPages(WebDriver driver) {                 //constructor
		this.driver=driver;
		PageFactory.initElements(driver, this);          //initialising WebElement element
	}
	
//	By username=By.xpath("//input[@name='username']");
//	By password=By.xpath("//input[@name='password']");
//	By signIn=By.xpath("//button[text()='Sign In']");
//	By dashboard=By.xpath("//li[text()='Dashboard']");
//	By error=By.xpath("//div[@class='alert alert-danger alert-dismissible']");
	
	@FindBy(xpath="//input[@name='username']")
	WebElement username;
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	@FindBy(xpath="//button[text()='Sign In']")
	WebElement signIn;
	@FindBy(xpath="//li[text()='Dashboard']")
	WebElement dashboard;
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	WebElement error;
	
	public void login(String username1,String password1) {
		username.sendKeys(username1);
		password.sendKeys(password1);
		signIn.click();
	}
	
	public boolean isDisplayedValue() {
		boolean dashboardDisplay =dashboard.isDisplayed();
		return dashboardDisplay;
	}
	
	public String getErrorMsg()
	{
		String errorMsg=error.getText();
		return errorMsg;
	}
	
	public void clearDetails()
	{
		username.clear();
		password.clear();
	}
	

}

