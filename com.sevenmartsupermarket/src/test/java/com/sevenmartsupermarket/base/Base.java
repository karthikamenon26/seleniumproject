package com.sevenmartsupermarket.base;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.time.Duration;

import com.sevenmartsupermarket.constants.Constants;
import com.sevenmartsupermarket.utilities.ScreenshotCapture;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
	
	public WebDriver driver;
	Properties properties = new Properties(); //used to call properties from notepad
	ScreenshotCapture screenshotcapture=new ScreenshotCapture();
	
	/** Base Constructor **/
	public Base() {
		try {
			FileInputStream fs = new FileInputStream(Constants.CONFIG_FILE_PATH); //used to call properties from notepad
			properties.load(fs);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	/** initializing browser **/
	public void initialize(String browser, String url) {
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		driver.get(url);
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICIT_WAIT));

	}
	
	@BeforeMethod(enabled=true)
	public void launchBrowser() 
	{
		String browser=properties.getProperty("browser");
		String url=properties.getProperty("url");
		initialize(browser,url);
	}
	
	@Parameters("browser")
	@BeforeMethod(enabled=false)
	public void launchBrowser(String browser) 
	{
		String url=properties.getProperty("url");
		initialize(browser,url);
	}
	
	@AfterMethod
	public void terminateBrowser(ITestResult itestresult) //for listener to check whether testcase is pass or fail
	{
		if(itestresult.getStatus()==ITestResult.FAILURE) //it takes screenshot for a fail testcase
		{
			screenshotcapture.takesscreenshot(driver, itestresult.getName()); //getname takes name of particular testcase name
		}
		
	}

}


