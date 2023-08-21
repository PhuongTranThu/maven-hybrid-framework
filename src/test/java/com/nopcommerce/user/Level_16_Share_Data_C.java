package com.nopcommerce.user;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.commons.Common_01_Register_End_User;
import com.nopcommerce.commons.Common_01_Register_Cookie;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.portal.UserCustomerInforPageObject;
import pageObjects.nopCommerce.portal.UserHomePageObject;
import pageObjects.nopCommerce.portal.UserLoginPageObject;
import pageObjects.nopCommerce.portal.UserRegisterPageObject;

public class Level_16_Share_Data_C extends BaseTest {

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);

		homePage = PageGeneratorManager.getUserHomePage(driver);
		log.info("Pre-Condition - Step 01: Navigate to login page");
		loginPage = homePage.clickToLoginLink();

		log.info("Pre-Condition - Step 02: Set Cookie and reload page");
		loginPage.setCookies(driver, Common_01_Register_Cookie.LoggedCokies);
		for (Cookie cookie : Common_01_Register_Cookie.LoggedCokies) {
			System.out.println("Cookie at C Class: " + cookie);
			
		}
		loginPage.refreshCurrentPage(driver);

		log.info("Pre-Condition - Step 03: Verify 'My Account' link is displayed");
		verifyTrue(homePage.isMyAccountLinkDisplayed());

	}

	@Test
	public void Search_01_Empty_Data() {

	}
	
	@Test
	public void Search_02_Empty_Data() {

	}
	
	@Test
	public void Search_03_Empty_Data() {

	}
	
	@Test
	public void Search_04_Empty_Data() {

	}

	@AfterClass
	public void afterClass() {
		//driver.quit();
	}

	private WebDriver driver;
	private String firstName, lastName, emailAddress, validPassword;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInforPageObject customerInforPage;

}
