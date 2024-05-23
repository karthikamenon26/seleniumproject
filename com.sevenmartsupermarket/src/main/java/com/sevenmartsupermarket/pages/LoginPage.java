package com.sevenmartsupermarket.pages;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenmartsupermarket.constants.Constants;
import com.sevenmartsupermarket.utilities.WaitUtility;

public class LoginPage {

	WebDriver driver;
	Properties properties = new Properties();
	
	@FindBy(xpath = "(//input[@class='form-control'])[1]")
	WebElement userNameField;
	@FindBy(xpath = "(//input[@class='form-control'])[2]")
	WebElement passwordField;
	@FindBy(xpath = "//button[@class='btn btn-dark btn-block']")
	WebElement signinButton;
	@FindBy(xpath = "//button[@class='close']")
	WebElement alertCloseButton;
	@FindBy(xpath = "//div[@class='login-logo']//a//b")
	WebElement loginHeaderlogo;
	@FindBy(xpath = "//label[@for='remember']")
	WebElement rememberme;
	By homePageWaitElement=By.xpath("//a[@class='d-block']");
	//WebElement rememberme;
	//a[@class='d-block']
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		try {
			FileInputStream fs = new FileInputStream(Constants.CONFIG_FILE_PATH); //used to call properties from notepad
			properties.load(fs);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void enterUserName(String username) {
		userNameField.sendKeys(username);
	}

	public void enterPassword(String password) {
		passwordField.sendKeys(password);
	}

	public void clickonSigninButton() {
		signinButton.click();
	}
	
	public void login() {
		//WaitUtility waitutility = new WaitUtility();
		String username = properties.getProperty("userName");
		String password = properties.getProperty("password");
		enterUserName(username);
		enterPassword(password);
		clickonSigninButton();
		//waitutility.
	}
		
	public void login(String userName, String password) {
		enterUserName(userName);
		enterPassword(password);
		clickonSigninButton();
		}
	
	public boolean getErrorMessageAlert() {
		 boolean closebuttondisplayed=alertCloseButton.isDisplayed();
		 return  closebuttondisplayed;

		}
	
	
	}

