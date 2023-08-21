package com.jquery;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import pageObjects.liveTechpanda.admin.AdminLoginPageObject;
import pageObjects.liveTechpanda.admin.PageGeneratorManager;
import pageObjects.nopCommerce.portal.UserHomePageObject;
import pageObjects.nopCommerce.portal.UserRegisterPageObject;

public class Level_10_DataTable_DataDrid_Ex extends BaseTest {

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		userHomePage = commons.PageGeneratorManager.getUserHomePage(driver);

		firstName = "Automation";
		lastName = "FC";
		emailAddress = "afc" + generateFakeNumber() + "@mail.vn";
		validPassword = "123456";

	}

	@Test
	public void TC_01_Register_User() {
		userRegisterPage = userHomePage.clickToRegisterLink();

		userRegisterPage.inputToFirstnameTextbox(firstName);
		userRegisterPage.inputToLastnameTextbox(lastName);
		userRegisterPage.inputToEmailTextbox(emailAddress);
		userRegisterPage.inputToPasswordTextbox(validPassword);
		userRegisterPage.inputToConfirmPasswordTextbox(validPassword);

		userRegisterPage.clickToRegisterButton();

		Assert.assertEquals(userRegisterPage.getRegisterSuccessMessage(), "Your registration completed");

	}

	@Test
	public void TC_02_Switch_Role() {
		userHomePage.openPageUrl(driver, GlobalConstants.ADMIN_DEV_URL);
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);

		adminLoginPage.inputToUserName("user01");
		adminLoginPage.inputToPassword("guru99com");
		adminLoginPage.clickToLoginButton();

	}

	public void TC_03_Input_To_Email() {
		WebElement popupMessage = driver.findElement(By.id("message-popup-window"));
		if (popupMessage.isDisplayed()) {
			adminLoginPage.closePopup();
		}

	}

	private WebDriver driver;
	private String firstName, lastName, emailAddress, validPassword;
	private UserHomePageObject userHomePage;
	private UserRegisterPageObject userRegisterPage;
	private AdminLoginPageObject adminLoginPage;

}
