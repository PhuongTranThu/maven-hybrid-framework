package com.nopcommerce.user;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.commons.Common_01_Register_End_User;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.portal.UserCustomerInforPageObject;
import pageObjects.nopCommerce.portal.UserHomePageObject;
import pageObjects.nopCommerce.portal.UserLoginPageObject;
import pageObjects.nopCommerce.portal.UserRegisterPageObject;
import utilities.DataHelper;

public class Level_20_Data_Helper extends BaseTest {

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGeneratorManager.getUserHomePage(driver);
		dataFaker = DataHelper.getDataHelper();
		
		firstName = dataFaker.getFirstName();
		lastName = dataFaker.getLastName();
		emailAddress = dataFaker.getEmail();
		validPassword = dataFaker.getPassword();
		date = "10";
		month = "June";
		year = "1998";
		

	}

	@Test
	public void User_01_Register() {
		log.info("Register - Step 01: Navigate to 'Register' page");
		registerPage = homePage.clickToRegisterLink();
		
		registerPage.clickToRadioButtonByLabel(driver, "Male");

		log.info("Register - Step 02: Enter to Firstname textbox with value is '" + firstName + "'");
		registerPage.inputToTextboxByID(driver, "FirstName" ,firstName);

		log.info("Register - Step 03: Enter to Lastname textbox with value is '" + lastName + "'");
		registerPage.inputToTextboxByID(driver, "LastName" ,lastName);
		
		registerPage.selectToDropdownByName(driver, "DateOfBirthDay", date);
		registerPage.selectToDropdownByName(driver, "DateOfBirthMonth", month);
		registerPage.selectToDropdownByName(driver, "DateOfBirthYear", year);
		
		log.info("Register - Step 04: Enter to Email textbox with value is '" + emailAddress + "'");
		registerPage.inputToTextboxByID(driver, "Email" ,emailAddress);
		
		registerPage.clickToCheckboxByLabel(driver, "Newsletter");

		log.info("Register - Step 05: Enter to Password textbox with value is '" + validPassword + "'");
		registerPage.inputToTextboxByID(driver, "Password" ,validPassword);

		log.info("Register - Step 06: Enter to Confirm Password textbox with value is '" + validPassword + "'");
		registerPage.inputToTextboxByID(driver, "ConfirmPassword" ,validPassword);
		

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
		loginPage.inputToTextboxByID(driver, "Email" ,emailAddress);

		log.info("Login - Step 03: Enter to Password textbox with value is '" + validPassword + "'");
		loginPage.inputToTextboxByID(driver, "Password" ,validPassword);

		log.info("Login - Step 04: Click to Login button");
		loginPage.clickToButtonByText(driver, "Log in");
		homePage = PageGeneratorManager.getUserHomePage(driver);
		
	}
	
	@Test
	public void User_03_My_Account() {
		log.info("My Account - Step 01: Verify 'My Account' link is displayed");
		verifyFalse(homePage.isMyAccountLinkDisplayed());

		log.info("My Account - Step 02: Navigate to 'My Account' page");
		customerInforPage = homePage.openMyAccountPage();

		log.info("My Account - Step 03: Verify 'Customer Infor' page is displayed");
		verifyTrue(customerInforPage.isCustomerInforPageDisplayed());
		
		log.info("My Account - Step 04: Verify 'First Name' is correctly");
		Assert.assertEquals(customerInforPage.getTextboxValueByID(driver, "FirstName"), firstName);
		
		log.info("My Account - Step 05: Verify 'Last Name' is correctly");
		Assert.assertEquals(customerInforPage.getTextboxValueByID(driver, "LastName"), lastName);
		
		log.info("My Account - Step 06: Verify 'Email' is correctly");
		Assert.assertEquals(customerInforPage.getTextboxValueByID(driver, "Email"), emailAddress);
		
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}

	private WebDriver driver;
	private String firstName, lastName, emailAddress, validPassword;
	private DataHelper dataFaker;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInforPageObject customerInforPage;
	private String date, month, year;

}
