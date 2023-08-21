package com.nopcommerce.user;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

//import com.relevantcodes.extentreports.LogStatus;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.portal.UserCustomerInforPageObject;
import pageObjects.nopCommerce.portal.UserHomePageObject;
import pageObjects.nopCommerce.portal.UserLoginPageObject;
import pageObjects.nopCommerce.portal.UserRegisterPageObject;
//import reportConfig.ExtentManager;

public class Level_15_ExtentV2_Screenshot extends BaseTest {

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);

		homePage = PageGeneratorManager.getUserHomePage(driver);

		firstName = "Automation";
		lastName = "FC";
		emailAddress = "afc" + generateFakeNumber() + "@mail.vn";
		validPassword = "123456";

	}

	@Test
	public void User_01_Register(Method method) {
//		ExtentManager.startTest(method.getName(), "User_01_Register");
//		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 01: Navigate to 'Register' page");
//		registerPage = homePage.clickToRegisterLink();
//
//		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 02: Enter to Firstname textbox with value is '" + firstName + "'");
//		registerPage.inputToFirstnameTextbox(firstName);
//
//		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 03: Enter to Lastname textbox with value is '" + lastName + "'");
//		registerPage.inputToLastnameTextbox(lastName);
//
//		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 04: Enter to Email textbox with value is '" + emailAddress + "'");
//		registerPage.inputToEmailTextbox(emailAddress);
//
//		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 05: Enter to Password textbox with value is '" + validPassword + "'");
//		registerPage.inputToPasswordTextbox(validPassword);
//
//		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 06: Enter to Confirm Password textbox with value is '" + validPassword + "'");
//		registerPage.inputToConfirmPasswordTextbox(validPassword);
//
//		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 07: Click to 'Register' button");
//		registerPage.clickToRegisterButton();
//
//		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 08: Verify register success message is displayed");
//		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed...");
//
//		ExtentManager.endTest();

	}

	@Test
	public void User_02_Login(Method method) {
//		ExtentManager.startTest(method.getName(), "User_02_Login");
//		ExtentManager.getTest().log(LogStatus.INFO, "Login - Step 01: Click To Logout link");
//		homePage = registerPage.clickToLogoutLink();
////		loginPage = homePage.openLoginPage();
//
//		ExtentManager.getTest().log(LogStatus.INFO, "Login - Step 02: Navigate to login page");
//		loginPage = homePage.clickToLoginLink();
//
//		ExtentManager.getTest().log(LogStatus.INFO, "Login - Step 03: Enter to Email textbox with value is '" + emailAddress + "'");
//		loginPage.inputToEmailTextbox(emailAddress);
//
//		ExtentManager.getTest().log(LogStatus.INFO, "Login - Step 04: Enter to Password textbox with value is '" + validPassword + "'");
//		loginPage.inputToPasswordTextbox(validPassword);
//
//		ExtentManager.getTest().log(LogStatus.INFO, "Login - Step 05: Click to Login button");
//		homePage = loginPage.clickToLoginButton();
//
//		ExtentManager.getTest().log(LogStatus.INFO, "Login - Step 06: Verify 'My Account' link is displayed");
//		Assert.assertFalse(homePage.isMyAccountLinkDisplayed());
//
//		ExtentManager.getTest().log(LogStatus.INFO, "Login - Step 07: Navigate to 'My Account' page");
//		customerInforPage = homePage.openMyAccountPage();
//
//		ExtentManager.getTest().log(LogStatus.INFO, "Login - Step 08: Verify 'Customer Infor' page is displayed");
//		Assert.assertFalse(customerInforPage.isCustomerInforPageDisplayed());
//
//		ExtentManager.endTest();

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	private WebDriver driver;
	private String firstName, lastName, emailAddress, validPassword;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInforPageObject customerInforPage;

}
