package com.sevenmartsupermarket.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage {

WebDriver driver;

@FindBy(xpath = "//ul//li[6]")
private WebElement pushnotificationelement;
@FindBy(xpath = "//div[@class='col-lg-3 col-6']")
private List <WebElement> dashboardelements;
@FindBy(xpath = "//a[@class='d-block']")
private WebElement profileName;
@FindBy(xpath = "(//a[@class='small-box-footer'])[2]")
private WebElement adminUsers;
@FindBy(xpath = "//a[@onclick='click_button(1)']")
private WebElement newOptionAdminUsers;
@FindBy(xpath = "//input[@id='username']")
private WebElement adminUsersUsername;
@FindBy(xpath = "//input[@id='password']")
private WebElement adminUsersPassword;
@FindBy(xpath = "//select[@id='user_type']")
private WebElement allDropDown;
@FindBy(xpath = "(//option[@value='admin'])[2]")
private WebElement selectAdminDropDown;
@FindBy(xpath = "(//button[@class='btn btn-block-sm btn-danger'])[2]")
private WebElement adminSave;
@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
private WebElement alertMessage;
@FindBy(xpath = "(//a[@class='small-box-footer'])[5]")
private WebElement manageProduct;
@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
private WebElement newManageProduct;
@FindBy(xpath = "(//input[@class='form-control'])[1]")
private WebElement titleManageProduct;
@FindBy(xpath = "//input[@value='Veg']")
private WebElement productTypeManageProduct;
@FindBy(xpath = "//input[@id='tag']")
private WebElement tagManageProduct;
@FindBy(xpath = "//select[@id='cat_id']")
private WebElement categoryManageProduct;
@FindBy(xpath = "(//option[@selected='selected'])[1]")
private WebElement selectCategory;
@FindBy(xpath = "//select[@id='sub_id']")
private WebElement subCategoryTypeManageProduct;
@FindBy(xpath = "(//option[@selected='selected'])[2]")
private WebElement selectSubCategory;
@FindBy(xpath = "//select[@id='grp_id']")
private WebElement groupManageProduct;
@FindBy(xpath = "(//option[@selected='selected'])[3]")
private WebElement selectGroup;
@FindBy(xpath = "//input[@id='purpose']")
private WebElement priceTypeManageProduct;
@FindBy(xpath = "//input[@id='m_weight']")
private WebElement weightValueManageProduct;
@FindBy(xpath = "//select[@id='w_unit']")
private WebElement weightUnitManageProduct;
@FindBy(xpath = "//option[@value='kg']")
private WebElement selectWeightUnit;
@FindBy(xpath = "//input[@id='max_weight']")
private WebElement maxQuantityManageProduct;
@FindBy(xpath = "//input[@id='w_price']")
private WebElement PriceManageProduct;
//@FindBy(xpath = "//input[@name='unlimitw[]']")
//private WebElement unlimitedStockManageProduct;
@FindBy(xpath = "//input[@name='w_stock']")
private WebElement stockAvailableManageProduct;
@FindBy(xpath = "(//input[@value='yes'])[5]")
private WebElement stockManageProduct;
@FindBy(xpath = "(//input[@value='no'])[2]")
private WebElement featuredManageProduct;
@FindBy(xpath = "(//input[@value='no'])[3]")
private WebElement comboPackManageProduct;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getProfilename() {
		return profileName.getText();	
		}
	
	public void clickOnPushNotification() {
		pushnotificationelement.click();
	}
	
	public void saveAdminUserInformation()
	{
		adminUsers.click();
		newOptionAdminUsers.click();
		adminUsersUsername.sendKeys("admin");
		adminUsersPassword.sendKeys("admin");
		Select select=new Select(allDropDown);
		allDropDown.click();
		selectAdminDropDown.click();
		adminSave.click();
	}
	
	public boolean getUsernameAlreadyExistAlert()
	{
		boolean usernameExist = alertMessage.isDisplayed(); 
		return usernameExist;	
	}
	
	public void saveProductInformation()
	{
		manageProduct.click();
		newManageProduct.click();
		titleManageProduct.click();
		titleManageProduct.sendKeys("Apple");
		tagManageProduct.click();
		tagManageProduct.sendKeys("a");
		Select select=new Select(categoryManageProduct);
		categoryManageProduct.click();
		selectCategory.click();
		Select select1=new Select(subCategoryTypeManageProduct);
		subCategoryTypeManageProduct.click();
		selectSubCategory.click();
		Select select2=new Select(groupManageProduct);
		groupManageProduct.click();
		selectGroup.click();
		priceTypeManageProduct.click();
		weightValueManageProduct.click();
		weightValueManageProduct.sendKeys("3");
		Select select3=new Select(weightUnitManageProduct);
		weightUnitManageProduct.click();
		selectWeightUnit.click();
		maxQuantityManageProduct.click();
		maxQuantityManageProduct.sendKeys("10 kg");
		PriceManageProduct.click();
		PriceManageProduct.sendKeys("250");
		//unlimitedStockManageProduct.click();
		stockAvailableManageProduct.click();
		stockAvailableManageProduct.sendKeys("50");
		stockManageProduct.click();
		featuredManageProduct.click();
		comboPackManageProduct.click();
	}
	
	
}
