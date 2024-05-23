package com.sevenmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;

import com.sevenmartsupermarket.utilities.DataProviders;
import com.sevenmartsupermarket.utilities.GeneralUtility;
import com.sevenmartsupermarket.utilities.PageUtility;

public class ManagePagePage {

	@FindBy(xpath = "(//a[@class='small-box-footer'])[1]")
	private WebElement managePage;
	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	private WebElement managePageNew;
	@FindBy(xpath = "//input[@name='title']")
	private WebElement managePageTitle;
	@FindBy(xpath = "//input[@id='page']")
	private WebElement managePagePageName;
	@FindBy(xpath = "//button[@name='create']")
	private WebElement managePageSave;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	private WebElement managePageSearch;
	@FindBy(xpath = "//input[@name='un']")
	private WebElement managePageTitleSearch;
	@FindBy(xpath = "(//i[@class='fas fa-edit'])[2]")
	private WebElement managePageUpdate;
	@FindBy(xpath = "//button[@name='update']")
	private WebElement managePageUpdateSave;
	//input[@name='un']
	
	PageUtility pageutility;
	GeneralUtility generalutility;
	DataProviders dataproviders;
	WebDriver driver;

		public ManagePagePage(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
	
	public void listPage(String title)
	{
		managePage.click();
		managePageNew.click();
		managePageTitle.sendKeys(title);
	}
	
	public void pageName(String pagename)
	{
		managePagePageName.sendKeys(pagename);
		managePageSave.click();
	}
	
	public void listPageSearch(String pagetitle)
	{
		managePage.click();
		managePageSearch.click();
		managePageTitleSearch.click();
		managePageTitleSearch.sendKeys(pagetitle);
	}
	
//	public class DataProviders {
//
//		@DataProvider(name="Username")
//		public Object[][] searchAdminUsername()
//		{
//			return new Object [][] {{"Mobile Phones"},{"Watch"},{"Shoes"}};
//		}
//	}
	
	public void updateList(String title)
	{
		managePage.click();
		managePageUpdate.click();
		managePageTitle.sendKeys(title);
		managePageUpdateSave.click();
	}
}
