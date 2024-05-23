package com.sevenmartsupermarket.base;

import org.testng.annotations.Test;

import com.sevenmartsupermarket.pages.AdminPage;
import com.sevenmartsupermarket.pages.HomePage;
import com.sevenmartsupermarket.pages.LoginPage;
import com.sevenmartsupermarket.pages.PushNotificationPage;
import com.sevenmartsupermarket.utilities.ExcelReader;
import com.sevenmartsupermarket.utilities.GeneralUtility;

public class AdminTest extends Base{
	
	AdminPage adminpage;
	PushNotificationPage pushnotificationpage;
	LoginPage loginPage;
	HomePage homepage;
	ExcelReader excelreader = new ExcelReader();
	GeneralUtility generalutility;
	
	public void addUserAdminInformations() 
	{
		loginPage=new LoginPage(driver);
		loginPage.login();
		adminpage=new AdminPage(driver);
		adminpage.saveAdminUserInformation();//parameterised
	}
	
	public void verifyDuplicationusernameExist()
	{
		loginPage=new LoginPage(driver);
		loginPage.login();
		adminpage=new AdminPage(driver);
		adminpage.saveAdminUserInformation(); //parameterised
		//homepage.getAlertMsg();
	}
	
	@Test
	public void duplicationDetails()
	{
		loginPage=new LoginPage(driver);
		loginPage.login();
		adminpage=new AdminPage(driver);
		adminpage.listAllUsers();
	}
}
