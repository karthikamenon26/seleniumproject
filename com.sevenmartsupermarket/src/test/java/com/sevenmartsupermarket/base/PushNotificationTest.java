package com.sevenmartsupermarket.base;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenmartsupermarket.pages.AdminPage;
import com.sevenmartsupermarket.pages.HomePage;
import com.sevenmartsupermarket.pages.LoginPage;
import com.sevenmartsupermarket.pages.PushNotificationPage;
import com.sevenmartsupermarket.utilities.ExcelReader;
import com.sevenmartsupermarket.utilities.GeneralUtility;

public class PushNotificationTest extends Base{

	PushNotificationPage pushnotificationpage;
	LoginPage loginPage;
	HomePage homepage;
	ExcelReader excelreader = new ExcelReader();
	GeneralUtility generalutility;
	
	@Test
	public void checkProfileName() 
	{
		loginPage=new LoginPage(driver);
		loginPage.login();
		homepage=new HomePage(driver);
		System.out.println(homepage.getProfilename());
		
	}
	
	@Test
	public void verifySendNotification() {
		loginPage=new LoginPage(driver);
		loginPage.login();
		homepage=new HomePage(driver);
		homepage.clickOnPushNotification();
		pushnotificationpage=new PushNotificationPage(driver);
//		excelreader.setExcelFile("PushNotificationData", "Notifications"); //using workbook(excel)
//		String title = excelreader.getCellData(1, 0);
//		String description = excelreader.getCellData(1, 1);
		pushnotificationpage.sendNotification("its a title", "its a description"); // data driven framework i.e taking data which is in different file
		boolean displayed=pushnotificationpage.alert_PushCloseButtonDisplayed();
		Assert.assertTrue(displayed);
		pushnotificationpage.sendNotification("title", "description");
		System.out.println(GeneralUtility.getRandomFullName()); //to get random name
	}
	
	@Test
	public void checkingExcel() 
	{
		loginPage=new LoginPage(driver);
		loginPage.login();
		homepage=new HomePage(driver);
		homepage.clickOnPushNotification();
		pushnotificationpage=new PushNotificationPage(driver);
		excelreader.setExcelFile("PushNotificationData", "Notifications"); //using workbook(excel)
		String title = excelreader.getCellData(1, 0);
		title = title + GeneralUtility.getRandomFullName(); //avoid duplication
		String description = excelreader.getCellData(1, 1);
	}
	
	@Test
	public void enterProductDetails()
	{
		loginPage=new LoginPage(driver);
		loginPage.login();
		homepage=new HomePage(driver);
		homepage.saveProductInformation();
	}
	
//	@Test
//	public void duplicationDetails()
//	{
//		loginPage=new LoginPage(driver);
//		loginPage.login();
//		homepage=new HomePage(driver);
//		homepage.listAllUsers();
//	}
	
	public void verifyDeactivationFunctionality()
	{
		loginPage=new LoginPage(driver);
		loginPage.login();
		homepage=new HomePage(driver);
		homepage.deactivateUser(null);
	}
}
