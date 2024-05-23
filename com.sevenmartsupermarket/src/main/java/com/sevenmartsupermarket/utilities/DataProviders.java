package com.sevenmartsupermarket.utilities;

import org.testng.annotations.DataProvider;

public class DataProviders {

	ExcelReader excelreader = new ExcelReader();
	@DataProvider(name="Username")
	public Object[][] searchAdminUsername()
	{
		return new Object [][] {{"Marry Renner"},{"Allen Kuhlman"},{"Nitheesha34911.46849379448"}};
	}
	
	@DataProvider(name="NewLogin")
	public Object[][] NewLogin()
	{
		excelreader.setExcelFile("Login", "Sheet2");
		return excelreader.getMultiDimensionalData(0, 0);
		
	}
}
