package com.sevenmartsupermarket.base;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenmartsupermarket.pages.HomePage;
import com.sevenmartsupermarket.pages.LoginPage;
import com.sevenmartsupermarket.base.Base;

public class HomeTest extends Base{




		LoginPage loginpage;

		HomePage homepage;

		

		@Test

	public void verify_GraphicElements() {

		loginpage=new LoginPage(driver);

		homepage=new HomePage(driver);

		loginpage.login();

		int actualsize=homepage.graphicElementsSize();

		int expectedsize=8;

		Assert.assertEquals(actualsize,expectedsize);

	}

	}

