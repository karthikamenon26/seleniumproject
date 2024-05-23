package com.sevenmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenmartsupermarket.utilities.GeneralUtility;
import com.sevenmartsupermarket.utilities.PageUtility;

public class CategoryPage {

	@FindBy(xpath = "(//a[@class='small-box-footer'])[4]")
	private WebElement categoryLink;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement categoryNew;
	@FindBy(xpath = "//input[@name='category']")
	private WebElement enterCategory;
	@FindBy(xpath = "//button[@name='create']")
	private WebElement saveCategory;
	@FindBy(xpath = "(//a[@onclick='click_button(2)']")
	private WebElement categorySearch;
	@FindBy(xpath = "//input[@type='text']")
	private WebElement updateCategory;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement searchCategory;
	
	PageUtility pageutility;
	GeneralUtility generalutility;
	WebDriver driver;

		public CategoryPage(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		
		public void saveCategory(String category)
		{
		    categoryLink.click();
			categoryNew.click();
			enterCategory.click();
			enterCategory.sendKeys(category);
			saveCategory.click();
		}
		
		public void searchCategory(String category)
		{
			categoryLink.click();
			searchCategory.click();
			updateCategory.click();
			updateCategory.sendKeys(category);
			searchCategory.click();
		}
}
