package pageObjects.liveTechpanda.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveTechPanda.admin.AdminLoginPageUI;

public class AdminLoginPageObject extends BasePage {

	public AdminLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	private WebDriver driver;

	public void inputToUserName(String userName) {
		waitForAllElementVisible(driver, AdminLoginPageUI.USERNAME_TEXTBOX);
		senkeyToElement(driver, AdminLoginPageUI.USERNAME_TEXTBOX, userName);

	}

	public void inputToPassword(String password) {
		waitForAllElementVisible(driver, AdminLoginPageUI.PASSWORD_TEXTBOX);
		senkeyToElement(driver, AdminLoginPageUI.PASSWORD_TEXTBOX, password);

	}

	public AdminLoginPageObject clickToLoginButton() {
		waitForElementClickable(driver, AdminLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, AdminLoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getAdminLoginPage(driver);

	}

	public void closePopup() {
		waitForElementClickable(driver, AdminLoginPageUI.CLOSE_POPUP_BUTTON);
		clickToElementByJS(driver, AdminLoginPageUI.CLOSE_POPUP_BUTTON);

	}

}
