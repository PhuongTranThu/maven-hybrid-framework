package com.bankguru;

import static org.testng.Assert.assertEquals;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.bankGuru.HomePageObject;
import pageObject.bankGuru.LoginPageObject;
import pageObject.bankGuru.PageGeneratorManager;

public class N1_Login_Cookie extends BaseTest{


	@Parameters ({"browser" , "url"})
	@BeforeTest
	public void beforeClass (String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		loginPage = PageGeneratorManager.getLoginPage(driver);
		userId = "mngr485806 ";
		passwordLogin = "rYbAjYm";
		
	}
	
	@Test
	public void TC_01_Login() {
		loginPage.inputToUserId(userId);
		loginPage.inputToPassword(passwordLogin);
		homePage = loginPage.clickToLoginButton();
		
		homePage.clickToCloseAlert(driver);
		
		assertEquals(homePage.getLoginSuccessMessage(), "Welcome To Manager's Page of Guru99 Bank");
		
		LoggedCokies = homePage.getAllCookies(driver);
		for (Cookie cookie : LoggedCokies) {
			System.out.println("Cookie: " + cookie);
		}
		driver.quit();
	}
		
	
	private WebDriver driver;
	private LoginPageObject loginPage;
	private HomePageObject homePage;
	public static String userId, passwordLogin, customerID;
	public static Set<Cookie> LoggedCokies;
}
