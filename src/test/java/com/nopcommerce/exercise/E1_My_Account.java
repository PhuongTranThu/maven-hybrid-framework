package com.nopcommerce.exercise;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
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

public class E1_My_Account extends BaseTest{
	
	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		emailAddress = Common_01_Register_End_User.emailAddress;
		validPassword = Common_01_Register_End_User.password;
		
		firstNameEdit = "Automation";
		lastNameEdit = "FC";
		emailAddressEdit = "autotest" + generateFakeNumber() + "@gmail.edu";
		company = "Automation FC";
		date = "5";
		month = "November";
		year = "1998";
		addressFirstName = "Automation";
		addressLastName = "FC";
		addressEmail = "autotest123@gmail.vn";
		addressCompany = "Automation FC";
		addressCity = "VietNam";
		addressAddress1 = "123/04 Le Lai";
		addressAddress2 = "234/05 Hai Phong";
		addressZip = "550000";
		addressPhoneNumber = "0123456789";
		addressFaxNumber = "987654321";
		country = "Viet Nam";
		state = "Other";

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
	public void TC_01_Customer_Info() {
		customerInforPage = homePage.openMyAccountPage();
		customerInforPage = (UserCustomerInforPageObject) homePage.openPagesAtMyAccountByName(driver, "Customer info");
		customerInforPage.clickToRadioButtonGender(driver, "Female");
		customerInforPage.inputToTextboxByID(driver, "FirstName", firstNameEdit);
		customerInforPage.inputToTextboxByID(driver, "LastName", lastNameEdit);
		
		customerInforPage.selectToDropdownByName(driver, "DateOfBirthDay", date);
		customerInforPage.selectToDropdownByName(driver, "DateOfBirthMonth", month);
		customerInforPage.selectToDropdownByName(driver, "DateOfBirthYear", year);
		
		customerInforPage.inputToTextboxByID(driver, "Email", emailAddressEdit);
		customerInforPage.inputToTextboxByID(driver, "Company", company);
		customerInforPage.clickToButtonByText(driver, "Save");
		assertEquals(customerInforPage.getTextEditSuccess(driver), "The customer info has been updated successfully.");
	}
	
	@Test
	public void TC_02_Add_Address() {
		customerInforPage.openPagesAtMyAccountByPageName(driver, "Addresses");
		addressPage = PageGeneratorManager.getUserAddressPage(driver);
		
		addressPage.clickToButtonByText(driver, "Add new");
		
		addressPage.inputToTextboxByID(driver, "Address_FirstName", addressFirstName);
		addressPage.inputToTextboxByID(driver, "Address_LastName", addressLastName);
		addressPage.inputToTextboxByID(driver, "Address_Email", addressEmail);
		addressPage.inputToTextboxByID(driver, "Address_Company", addressCompany);
		
		addressPage.selectToDropdownByName(driver, "Address.CountryId", country);
		addressPage.selectToDropdownByName(driver, "Address.StateProvinceId", state);
		
		addressPage.inputToTextboxByID(driver, "Address_City", addressCity);
		addressPage.inputToTextboxByID(driver, "Address_Address1", addressAddress1);
		addressPage.inputToTextboxByID(driver, "Address_Address2", addressAddress2);
		addressPage.inputToTextboxByID(driver, "Address_ZipPostalCode", addressZip);
		addressPage.inputToTextboxByID(driver, "Address_PhoneNumber", addressPhoneNumber);
		addressPage.inputToTextboxByID(driver, "Address_FaxNumber", addressFaxNumber);
		
		addressPage.clickToButtonByText(driver, "Save");
		
		assertEquals(addressPage.getTextNewAddressSuccess(driver), "The new address has been added successfully.");
		
//		assertEquals(addressPage.getAttributeValueText(driver, "Email:"), addressEmail);
//		assertEquals(addressPage.getAttributeValueText(driver, "Phone number:"), addressPhoneNumber);

		
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	private WebDriver driver;
	private String firstName, lastName, emailAddress, validPassword;
	private String firstNameEdit, lastNameEdit, emailAddressEdit, company, date, month, year;
	private String addressFirstName, addressLastName, addressEmail, addressCompany, country, state, addressCity, addressAddress1, addressAddress2, addressZip, addressPhoneNumber, addressFaxNumber;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInforPageObject customerInforPage;
	private UserAddressPageObject addressPage;


}
