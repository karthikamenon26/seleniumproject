package com.sevenmartsupermarket.base;

import org.testng.annotations.Test;

import com.sevenmartsupermarket.pages.AdminPage;
import com.sevenmartsupermarket.pages.CategoryPage;
import com.sevenmartsupermarket.pages.HomePage;
import com.sevenmartsupermarket.pages.LoginPage;
import com.sevenmartsupermarket.pages.ManagePagePage;
import com.sevenmartsupermarket.pages.PushNotificationPage;
import com.sevenmartsupermarket.utilities.ExcelReader;
import com.sevenmartsupermarket.utilities.GeneralUtility;

public class CategoryTest extends Base{

	CategoryPage categorypage;
	ManagePageTest managepagetest;
	ManagePagePage managepagepage;
	AdminPage adminpage;
	PushNotificationPage pushnotificationpage;
	LoginPage loginPage;
	HomePage homepage;
	ExcelReader excelreader = new ExcelReader();
	GeneralUtility generalutility;
	
	@Test
	public void addCategory()
	{
		loginPage=new LoginPage(driver);
		loginPage.login();
		categorypage=new CategoryPage(driver);
		categorypage.saveCategory("Chocolates");
		
	}
	
	@Test
	public void searchListCategory()
	{
		loginPage=new LoginPage(driver);
		loginPage.login();
		categorypage=new CategoryPage(driver);
		categorypage.searchCategory("Chocolates");
	}
}
