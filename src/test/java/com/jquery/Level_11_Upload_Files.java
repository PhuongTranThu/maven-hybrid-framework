package com.jquery;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.jQuery.uploadFile.HomePageObject;
import pageObjects.jQuery.uploadFile.PageGeneratorManager;

public class Level_11_Upload_Files extends BaseTest {
	String csharpFileName = "CSharp.jpeg";
	String javaFileName = "Java.jpeg";
	String pythonFileName = "Python.jpeg";
	String rubyFileName = "Ruby.jpeg";
	String[] multipleFileNames = { csharpFileName, javaFileName, pythonFileName, rubyFileName };

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGeneratorManager.getHomePageObject(driver);

	}

	@Test
	public void TC_01_Table_Paging() {
		// Step 1: Load image file
		homePage.uploadMultipleFiles(driver, csharpFileName);

		// Step 2: Verify file image loaded success
		Assert.assertTrue(homePage.isFileLoadedByName(csharpFileName));

		// Step 3: Click start button
		homePage.clickToStartButton();

		// Step 4: Verify link upload success
		Assert.assertTrue(homePage.isFileLinkUploadedByName(csharpFileName));

		// Step 5: Verify file image upload success
		Assert.assertTrue(homePage.isFileImageUploadedByName(csharpFileName));

	}

	@Test
	public void TC_02_Enter_To_Header() {
		homePage.refreshCurrentPage(driver);
		homePage.uploadMultipleFiles(driver, multipleFileNames);

		Assert.assertTrue(homePage.isFileLoadedByName(csharpFileName));
		Assert.assertTrue(homePage.isFileLoadedByName(javaFileName));
		Assert.assertTrue(homePage.isFileLoadedByName(pythonFileName));
		Assert.assertTrue(homePage.isFileLoadedByName(rubyFileName));

		homePage.clickToStartButton();

		Assert.assertTrue(homePage.isFileLinkUploadedByName(csharpFileName));
		Assert.assertTrue(homePage.isFileLinkUploadedByName(javaFileName));
		Assert.assertTrue(homePage.isFileLinkUploadedByName(pythonFileName));
		Assert.assertTrue(homePage.isFileLinkUploadedByName(rubyFileName));

		Assert.assertTrue(homePage.isFileImageUploadedByName(csharpFileName));
		Assert.assertTrue(homePage.isFileImageUploadedByName(javaFileName));
		Assert.assertTrue(homePage.isFileImageUploadedByName(pythonFileName));
		Assert.assertTrue(homePage.isFileImageUploadedByName(rubyFileName));

	}

	@AfterClass
	public void afterClass() {
		// driver.quit();
	}

	private WebDriver driver;
	private HomePageObject homePage;

}
