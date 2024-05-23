package com.sevenmartsupermarket.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.sevenmartsupermarket.utilities.GeneralUtility;
import com.sevenmartsupermarket.utilities.PageUtility;

public class AdminPage {
	
	PageUtility pageutility;
	GeneralUtility generalutility;
    WebDriver driver;
	
	public AdminPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@class='d-block']")
	private WebElement profileName;
	@FindBy(xpath = "(//a[@class='small-box-footer'])[2]")
	private WebElement adminUsers;
	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	private WebElement newOptionAdminUsers;
	@FindBy(xpath = "//input[@id='username']")
	private WebElement adminUsersUsername;
	@FindBy(xpath = "//input[@id='password']")
	private WebElement adminUsersPassword;
	@FindBy(xpath = "//select[@id='user_type']")
	private WebElement allDropDown;
	@FindBy(xpath = "(//option[@value='admin'])[2]")
	private WebElement selectAdminDropDown;
	@FindBy(xpath = "(//button[@class='btn btn-block-sm btn-danger'])[2]")
	private WebElement adminSave;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement alertMessage;
	@FindBy(xpath = "//tbody//tr//td[1]")
	List<WebElement> userNameColumnElements;
//	@FindBy(xpath = "(//a[@class='small-box-footer'])[2]")
//	private WebElement adminUsers;

	
	public void saveAdminUserInformation()
	{
		adminUsers.click();
		newOptionAdminUsers.click();
		adminUsersUsername.sendKeys("admin");
		adminUsersPassword.sendKeys("admin");
		Select select=new Select(allDropDown);
		allDropDown.click();
		selectAdminDropDown.click();
		adminSave.click();
	}
	
	public boolean getUsernameAlreadyExistAlert()
	{
		boolean usernameExist = alertMessage.isDisplayed(); 
		return usernameExist;	
	}
	
	public void listAllUsers()
	{
		adminUsers.click();
		for(WebElement username: userNameColumnElements)
		{
			System.out.println(username.getText());
		}
	}
	
}
