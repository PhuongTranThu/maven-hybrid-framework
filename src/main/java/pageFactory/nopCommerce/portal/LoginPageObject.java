package pageFactory.nopCommerce.portal;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.portal.UserLoginPageUI;

public class LoginPageObject extends BasePage {

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	private WebDriver driver;

	public void clickToLoginButton() {
		waitForElementClickable(driver, UserLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, UserLoginPageUI.LOGIN_BUTTON);
	}

	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver, UserLoginPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(driver, UserLoginPageUI.EMAIL_ERROR_MESSAGE);
	}

	public void inputToEmailTextbox(String invalidEmail) {
		waitForElementVisible(driver, UserLoginPageUI.EMAIL_TEXTBOX);
		senkeyToElement(driver, UserLoginPageUI.EMAIL_TEXTBOX, invalidEmail);

	}

	public String getErrorMessageUnsuccessful() {
		waitForElementVisible(driver, UserLoginPageUI.UNSUCCESFUL_ERROR_MESSAGE);
		return getElementText(driver, UserLoginPageUI.UNSUCCESFUL_ERROR_MESSAGE);
	}

	public void inputToPasswordTextbox(String incorrectPassword) {
		waitForElementVisible(driver, UserLoginPageUI.PASSWORD_TEXTBOX);
		senkeyToElement(driver, UserLoginPageUI.PASSWORD_TEXTBOX, incorrectPassword);

	}
}
