package com.sevenmartsupermarket.base;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenmartsupermarket.pages.HomePage;
import com.sevenmartsupermarket.pages.LoginPage;

public class LoginTest extends Base{

	LoginPage loginPage;
	HomePage homepage;
	
	//(groups="sanity")
	@Test
	public void verify_Login()
	{
		loginPage=new LoginPage(driver);
		loginPage.login();
	}
	//(groups="smoke", retryAnalyzer = com.sevenmartsupermarket.listeners.RetryAnalyzer.class)
	@Test
	public void verifyValidUserLogin() {
		
		loginPage = new LoginPage(driver);		
		homepage = new HomePage(driver);
		loginPage.login();
		String expectedProfileName = "Admin";
		String actualProfileName = homepage.getProfilename();
		Assert.assertEquals(actualProfileName, expectedProfileName);	
		
	}
	//(groups={"sanity","smoke"})
	@Test
	public void verifyInvalidUserLogin() {
		loginPage=new LoginPage(driver);
			loginPage.login("hhh","kkkk");
			boolean expected=loginPage.getErrorMessageAlert();
			Assert.assertTrue(expected);
			
		}
}
