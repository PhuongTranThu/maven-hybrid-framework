package com.nopcommerce.exercise;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.commons.Common_01_Register_End_User;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.portal.UserAddressPageObject;
import pageObjects.nopCommerce.portal.UserCustomerInforPageObject;
import pageObjects.nopCommerce.portal.UserHomePageObject;
import pageObjects.nopCommerce.portal.UserLoginPageObject;
import pageObjects.nopCommerce.portal.UserRegisterPageObject;
import pageObjects.nopCommerce.portal.UserSearchPageObject;

public class E2_Search extends BaseTest{


	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		emailAddress = Common_01_Register_End_User.emailAddress;
		validPassword = Common_01_Register_End_User.password;


		homePage = PageGeneratorManager.getUserHomePage(driver);
		log.info("Login - Step 01: Navigate to login page");
		loginPage = homePage.clickToLoginLink();

		log.info("Login - Step 02: Enter to Email textbox with value is '" + emailAddress + "'");
		loginPage.inputToEmailTextbox(emailAddress);

		log.info("Login - Step 03: Enter to Password textbox with value is '" + validPassword + "'");
		loginPage.inputToPasswordTextbox(validPassword);

		log.info("Login - Step 04: Click to Login button");
		homePage = loginPage.clickToLoginButton();
		

	}
	
	@Test
	public void TC_01_Search_Empty_Data() {
		searchPage = homePage.clickToSearchLink();
		searchPage.clickToButtonByText(driver, "Search");
		assertEquals(searchPage.getMessageSearchPage(driver, "length is 3 characters"), "Search term minimum length is 3 characters");
		
	}
	
	@Test
	public void TC_02_Search_Date_Not_Exit() {
		searchPage.inputToTextboxByID(driver, "q", "Macbook Pro 2050");
		searchPage.clickToButtonByText(driver, "Search");
		assertEquals(searchPage.getMessageSearchPage(driver, "No products were found"), "No products were found that matched your criteria.");
		
	}
	
	@Test
	public void TC_03_Search_With_Relative_Key() {
		searchPage.inputToTextboxByID(driver, "q", "Lenovo");
	}

	
	private WebDriver driver;
	private String firstName, lastName, emailAddress, validPassword;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInforPageObject customerInforPage;
	private UserAddressPageObject addressPage;
	private UserSearchPageObject searchPage;
	
}
