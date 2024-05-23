package com.sevenmartsupermarket.base;

import org.testng.annotations.Test;

import com.sevenmartsupermarket.pages.AdminPage;
import com.sevenmartsupermarket.pages.HomePage;
import com.sevenmartsupermarket.pages.LoginPage;
import com.sevenmartsupermarket.pages.ProductManagePage;
import com.sevenmartsupermarket.pages.PushNotificationPage;
import com.sevenmartsupermarket.utilities.ExcelReader;
import com.sevenmartsupermarket.utilities.GeneralUtility;

public class ProductManageTest extends Base {
	
	ProductManagePage productmanagepage;

	AdminPage adminpage;
	PushNotificationPage pushnotificationpage;
	LoginPage loginPage;
	HomePage homepage;
	ExcelReader excelreader = new ExcelReader();
	GeneralUtility generalutility;
	
	@Test
	public void enterProductDetails()
	{
		loginPage=new LoginPage(driver);
		loginPage.login();
		productmanagepage=new ProductManagePage(driver);
		productmanagepage.saveProductInformation();
	}
}
