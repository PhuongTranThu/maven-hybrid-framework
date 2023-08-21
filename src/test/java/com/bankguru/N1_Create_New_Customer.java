package com.bankguru;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.bankGuru.HomePageObject;
import pageObject.bankGuru.LoginPageObject;
import pageObject.bankGuru.ManagerPageObject;
import pageObject.bankGuru.NewCustomerPage;
import pageObject.bankGuru.PageGeneratorManager;

public class N1_Create_New_Customer extends BaseTest{

	@Parameters ({"browser" , "url"})
	@BeforeTest
	public void beforeClass (String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		loginPage = PageGeneratorManager.getLoginPage(driver);
	
		name = "AutoTest";
		address = "Viet Nam";
		city = "Ha Noi";
		state = "Single";
		pin = "123456";
		tel = "0123456789";
		email = "afc" + generateFakeNumber() + "@gmail.com";
		password = "123456";
	}
	
	@Test
	public void TC_01_Login() {
		loginPage.inputToUserId(userId);
		loginPage.inputToPassword(passwordLogin);
		homePage = loginPage.clickToLoginButton();
				
		assertEquals(homePage.getLoginSuccessMessage(), "Welcome To Manager's Page of Guru99 Bank");
		
		
	}
	
	@Test
	public void TC_02_Create_New_Account() {
		homePage.openPagesAtHomePageBankGuruByName(driver, "New Customer");
		newCustomerPage = PageGeneratorManager.getNewCustomer(driver);
		
		newCustomerPage.inputToTextboxBankGuruByName(driver, "name", name);
		newCustomerPage.clickToRadioButtonBankGuruByValue(driver, "f");

		homePage.sleepInSecond(8);
		
		newCustomerPage.inputToAdressTextbox(driver, address);
		newCustomerPage.inputToTextboxBankGuruByName(driver, "city", city);
		newCustomerPage.inputToTextboxBankGuruByName(driver, "state", state);
		newCustomerPage.inputToTextboxBankGuruByName(driver, "pinno", pin);
		newCustomerPage.inputToTextboxBankGuruByName(driver, "telephoneno", tel);
		newCustomerPage.inputToTextboxBankGuruByName(driver, "emailid", email);
		newCustomerPage.inputToTextboxBankGuruByName(driver, "password", password);
		
		managerPage = newCustomerPage.clickToButtonBankGuruByValue(driver, "Submit");
		customerID = managerPage.getCustomerId();
		System.out.println("Customer ID = " + customerID);
		
		assertEquals(managerPage.getRegisterSuccess(), "Customer Registered Successfully!!!");
		
		assertEquals(managerPage.getTextboxValueBankGuruByText(driver, "Customer Name"), name);
		assertEquals(managerPage.getTextboxValueBankGuruByText(driver, "Address"), address);
		assertEquals(managerPage.getTextboxValueBankGuruByText(driver, "City"), city);
		assertEquals(managerPage.getTextboxValueBankGuruByText(driver, "State"), state);
		assertEquals(managerPage.getTextboxValueBankGuruByText(driver, "Pin"), pin);
		assertEquals(managerPage.getTextboxValueBankGuruByText(driver, "Mobile No."), tel);
		assertEquals(managerPage.getTextboxValueBankGuruByText(driver, "Email"), email);
		
		
	}
	
	@AfterClass
	public void afterClass() {
		//driver.quit();
		
	}
	
	private WebDriver driver;
	private LoginPageObject loginPage;
	private HomePageObject homePage;
	private NewCustomerPage newCustomerPage;
	private ManagerPageObject managerPage;
	public static String userId = "mngr485806";
	public static String passwordLogin = "rYbAjYm";
	public static String customerID;
	private String name, address, city, state, pin, tel, email, password;
	
	
}
