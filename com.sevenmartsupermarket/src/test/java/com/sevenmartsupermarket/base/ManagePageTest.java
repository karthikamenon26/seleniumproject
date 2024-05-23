package com.sevenmartsupermarket.base;

import org.testng.annotations.Test;

import com.sevenmartsupermarket.pages.AdminPage;
import com.sevenmartsupermarket.pages.HomePage;
import com.sevenmartsupermarket.pages.LoginPage;
import com.sevenmartsupermarket.pages.ManagePagePage;
import com.sevenmartsupermarket.pages.PushNotificationPage;
import com.sevenmartsupermarket.utilities.DataProviders;
import com.sevenmartsupermarket.utilities.ExcelReader;
import com.sevenmartsupermarket.utilities.GeneralUtility;
import com.sevenmartsupermarket.utilities.ScreenshotCapture;

public class ManagePageTest extends Base{

	DataProviders dataproviders;
	ManagePageTest managepagetest;
	ManagePagePage managepagepage;
	AdminPage adminpage;
	PushNotificationPage pushnotificationpage;
	LoginPage loginPage;
	HomePage homepage;
	ExcelReader excelreader = new ExcelReader();
	GeneralUtility generalutility;
	
	@Test
	public void addListPages()
	{
		//ScreenshotCapture screenshotcapture = new ScreenshotCapture();
		loginPage=new LoginPage(driver);
		loginPage.login();
		//screenshotcapture.takesscreenshot(driver, "screenshot1"); //for capturing screenshot
		managepagepage=new ManagePagePage(driver);
		managepagepage.listPage("managepayment");
		managepagepage.pageName("abcd");
	}
	
	@Test(dataProvider = "Username",dataProviderClass = ManagePagePage.class)
	public void searchListPages()
	{
		loginPage=new LoginPage(driver);
		loginPage.login();
		managepagepage=new ManagePagePage(driver);
		managepagepage.listPageSearch("managepayment");
	}
	
	@Test
	public void updateListPages()
	{
		loginPage=new LoginPage(driver);
		loginPage.login();
		managepagepage=new ManagePagePage(driver);
		managepagepage.updateList("updated");
	}
}
