package com.bankguru;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.bankGuru.EditAccountPageObject;
import pageObject.bankGuru.HomePageObject;
import pageObject.bankGuru.LoginPageObject;
import pageObject.bankGuru.ManagerPageObject;
import pageObject.bankGuru.NewCustomerPage;
import pageObject.bankGuru.PageGeneratorManager;

public class N2_Edit_Customer_Account extends BaseTest{
	public static String customerID1; 

	
	@Parameters ({"browser" , "url"})
	@BeforeClass
	public void beforeClass (String browserName, String appUrl) {		
		driver = getBrowserDriver(browserName, appUrl);
		loginPage = PageGeneratorManager.getLoginPage(driver);
		
		userIdLogin = N1_Create_New_Customer.userId;
		passwordLogin = N1_Create_New_Customer.passwordLogin;
		customerID = N1_Create_New_Customer.customerID;
		
		addressEdit = "15 Ngo quyen";
		cityEdit = "Hai phong";
		stateEdit = "married";
		pinEdit = "000111";
;		
	}	
	
	@Test
	public void TC_01_Login() {
		loginPage.inputToUserId(userIdLogin);
		loginPage.inputToPassword(passwordLogin);
		homePage = loginPage.clickToLoginButton();
		
		homePage.clickToCloseAlert(driver);
		
		assertEquals(homePage.getLoginSuccessMessage(), "Welcome To Manager's Page of Guru99 Bank");
				
	}
	
	@Test
	public void TC_02_Edit_Customer() {

		homePage.openPagesAtHomePageBankGuruByName(driver, "Edit Account");
		editAccountPage = PageGeneratorManager.getEditAccountPage(driver);
		
		editAccountPage.closeAlert();
		
		System.out.println("input to customerID");
		
		editAccountPage.inputToTextboxBankGuruByName(driver, "accountno", customerID);
		
		editAccountPage.clickToButtonBankGuruByValue(driver, "Submit");
		
		editAccountPage.inputToEditTextboxbankGuruByText(driver, "Address" , addressEdit);
		editAccountPage.inputToEditTextboxbankGuruByText(driver, "City" , cityEdit);
		editAccountPage.inputToEditTextboxbankGuruByText(driver, "State" , stateEdit);
		editAccountPage.inputToEditTextboxbankGuruByText(driver, "Pin" , pinEdit);
		editAccountPage.clickToButtonBankGuruByValue(driver, "Submit");
		
	}
	
	
		private WebDriver driver;
		private LoginPageObject loginPage;
		private EditAccountPageObject editAccountPage;
		private HomePageObject homePage;
		private NewCustomerPage newCustomerPage;
		private ManagerPageObject managerPage;
		private String userIdLogin, passwordLogin, customerID, addressEdit, cityEdit, stateEdit, pinEdit;
		
}

