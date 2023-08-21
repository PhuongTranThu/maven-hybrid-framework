package com.nopcommerce.user;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.commons.Common_01_Register_End_User;
import com.nopcommerce.data.UserDataMapper;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.portal.UserCustomerInforPageObject;
import pageObjects.nopCommerce.portal.UserHomePageObject;
import pageObjects.nopCommerce.portal.UserLoginPageObject;
import pageObjects.nopCommerce.portal.UserRegisterPageObject;
import utilities.DataHelper;

public class Level_20_1_Manager_Data_Json extends BaseTest {

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGeneratorManager.getUserHomePage(driver);

		userData = UserDataMapper.getUserData();
		emailAddress = userData.getEmailAddress() + generateFakeNumber() + "@gmail.com";

	}

	@Test
	public void User_01_Register() {
		log.info("Register - Step 01: Navigate to 'Register' page");
		registerPage = homePage.clickToRegisterLink();

		registerPage.clickToRadioButtonByLabel(driver, "Male");

		log.info("Register - Step 02: Enter to Firstname textbox with value is '" + userData.getFirstName() + "'");
		registerPage.inputToTextboxByID(driver, "FirstName", userData.getFirstName());

		log.info("Register - Step 03: Enter to Lastname textbox with value is '" + userData.getLastName() + "'");
		registerPage.inputToTextboxByID(driver, "LastName", userData.getLastName());

		registerPage.selectToDropdownByName(driver, "DateOfBirthDay", userData.getDate());
		registerPage.selectToDropdownByName(driver, "DateOfBirthMonth", userData.getMonth());
		registerPage.selectToDropdownByName(driver, "DateOfBirthYear", userData.getYear());

		log.info("Register - Step 04: Enter to Email textbox with value is '" + emailAddress + "'");
		registerPage.inputToTextboxByID(driver, "Email", emailAddress);

		registerPage.clickToCheckboxByLabel(driver, "Newsletter");

		log.info("Register - Step 05: Enter to Password textbox with value is '" + userData.getValidPassword() + "'");
		registerPage.inputToTextboxByID(driver, "Password", userData.getValidPassword());

		log.info("Register - Step 06: Enter to Confirm Password textbox with value is '" + userData.getValidPassword()
				+ "'");
		registerPage.inputToTextboxByID(driver, "ConfirmPassword", userData.getValidPassword());

		log.info("Register - Step 07: Click to 'Register' button");
		registerPage.clickToButtonByText(driver, "Register");

		log.info("Register - Step 08: Verify register success message is displayed");
		assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		// homePage = registerPage.clickToLogoutLink();
	}

	@Test
	public void User_02_Login() {
		log.info("Login - Step 01: Navigate to login page");
		loginPage = homePage.clickToLoginLink();

		log.info("Login - Step 02: Enter to Email textbox with value is '" + emailAddress + "'");
		loginPage.inputToTextboxByID(driver, "Email", emailAddress);

		log.info("Login - Step 03: Enter to Password textbox with value is '" + userData.getValidPassword() + "'");
		loginPage.inputToTextboxByID(driver, "Password", userData.getValidPassword());

		log.info("Login - Step 04: Click to Login button");
		loginPage.clickToButtonByText(driver, "Log in");
		homePage = PageGeneratorManager.getUserHomePage(driver);

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}

	private WebDriver driver;
	private String emailAddress;
	private DataHelper dataFaker;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInforPageObject customerInforPage;
	private String date, month, year;
	UserDataMapper userData;

}
