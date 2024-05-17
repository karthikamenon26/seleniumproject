package com.sevenmartsupermarket.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenmartsupermarket.utilities.PageUtility;

public class PushNotificationPage {

	WebDriver driver;
	
	PageUtility pageutility;
	@FindBy(xpath = "//input[@class='form-control'][1]")
	private WebElement titlelement;
	@FindBy(xpath = "//input[@class='form-control'][2]")
	private WebElement descriptionelement;
	@FindBy(xpath = "//button[@class='btn btn-block-sm btn-info']")
	private WebElement sendButtonelement;
	@FindBy(xpath = "//button[@class='close']")
	private WebElement closeButtonAlertPushNotification;
	@FindBy(xpath = "//a[@class='btn btn-default btn-fix']")
	private WebElement resetButtonElement;
	@FindBy(xpath = "//button[@class='close']")
	private WebElement alertCloseButton;

	
	public PushNotificationPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterTitle(String title) {
		titlelement.sendKeys(title);
	}
public void enterDescription(String description) {
	descriptionelement.sendKeys(description);
	}
public void clickOnSendButton() {
	sendButtonelement.click();
}

public void sendNotification(String title,String description) {
	enterTitle(title);
	enterDescription(description);
	clickOnSendButton();
}
	
public boolean alert_PushCloseButtonDisplayed() {
	pageutility=new PageUtility(driver); 
	boolean displayed=pageutility.is_Displayed(closeButtonAlertPushNotification);
	return displayed;

	}


}

