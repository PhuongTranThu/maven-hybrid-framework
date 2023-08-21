package pageObjects.nopCommerce.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.admin.AdminLoginPageUI;

public class AdminLoginPageObject extends BasePage {

	public AdminLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	private WebDriver driver;

	public void inputToEmail(String adminEmail) {
		waitForElementVisible(driver, AdminLoginPageUI.EMAIL_TEXTBOX);
		senkeyToElement(driver, AdminLoginPageUI.EMAIL_TEXTBOX, adminEmail);
	}

	public void inputToPassword(String adminPassword) {
		waitForElementVisible(driver, AdminLoginPageUI.PASSWORD_TEXTBOX);
		senkeyToElement(driver, AdminLoginPageUI.PASSWORD_TEXTBOX, adminPassword);
	}

	public AdminDashboardPageObject clickToLoginButton() {
		waitForElementClickable(driver, AdminLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, AdminLoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getAdminDashboardPage(driver);
	}

	public AdminDashboardPageObject loginAsAdmin(String adminEmail, String adminPassword) {
		inputToEmail(adminEmail);
		inputToPassword(adminPassword);
		return clickToLoginButton();
	}

}
