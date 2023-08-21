package com.jquery;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.jQuery.dataTable.HomePageObject;
import pageObjects.jQuery.dataTable.PageGeneratorManager;

public class Level_10_DataTable_DataGrid extends BaseTest {
	List<String> actualAllCountryValues;
	List<String> expectedAllCountryValues;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGeneratorManager.getHomePageObject(driver);

	}

	public void TC_01_Table_Paging() {
		homePage.openPagingByPageNumber("10");
		Assert.assertTrue(homePage.isPageNumberActived("10"));
		homePage.sleepInSecond(1);

		homePage.openPagingByPageNumber("20");
		homePage.sleepInSecond(1);
		Assert.assertTrue(homePage.isPageNumberActived("20"));

		homePage.openPagingByPageNumber("15");
		homePage.sleepInSecond(1);
		Assert.assertTrue(homePage.isPageNumberActived("15"));

		homePage.openPagingByPageNumber("5");
		homePage.sleepInSecond(1);
		Assert.assertTrue(homePage.isPageNumberActived("5"));

	}

	public void TC_02_Enter_To_Header() {
		homePage.refreshCurrentPage(driver);
		homePage.enterToHeaderTextboxByLabel("Females", "750");
		homePage.enterToHeaderTextboxByLabel("Country", "Aruba");
		homePage.enterToHeaderTextboxByLabel("Males", "756");
		homePage.enterToHeaderTextboxByLabel("Total", "1504");
		homePage.sleepInSecond(3);

	}

	public void TC_03_Enter_To_Header() {
		actualAllCountryValues = homePage.getValueEachRowAtAllPage();
		Assert.assertEquals(actualAllCountryValues, expectedAllCountryValues);

	}

	@Test
	public void TC_04_Action_To_Textbox_At_Any_Row() {
		homePage.clickToLoadButton();

		homePage.enterToTextboxByColumnNameAtRowNumber("Company", "4", "Elistech");
		homePage.enterToTextboxByColumnNameAtRowNumber("Contact Person", "1", "Phuong");
		homePage.selectDropdownByColumnNameAtRowNumber("Country", "3", "Japan");

		homePage.checkToCheckboxByColumnNameAtRowNumber("NPO?", "1");
		homePage.uncheckToCheckboxByColumnNameAtRowNumber("NPO?", "1");

		homePage.clickToIconByRowNumber("1", "Insert Row Above");
		homePage.sleepInSecond(2);

		homePage.clickToIconByRowNumber("2", "Remove Current Row");
		homePage.sleepInSecond(2);

		homePage.clickToIconByRowNumber("4", "Move Up");
		homePage.sleepInSecond(2);

		homePage.clickToIconByRowNumber("3", "Move Down");
		homePage.sleepInSecond(2);

	}

	@AfterClass
	public void afterClass() {
		// driver.quit();
	}

	private WebDriver driver;
	HomePageObject homePage;

}
