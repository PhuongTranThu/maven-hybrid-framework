package pageObjects.nopCommerce.portal;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import io.qameta.allure.Step;
import pageUIs.nopCommerce.portal.UserRegisterPageUI;

public class UserRegisterPageObject extends BasePage {
	public UserRegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	private WebDriver driver;

	@Step("Click to Register button")
	public void clickToRegisterButton() {
		waitForElementClickable(driver, UserRegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, UserRegisterPageUI.REGISTER_BUTTON);

	}

	public String getErrorMessageAtFirstnameTextbox() {
		waitForElementVisible(driver, UserRegisterPageUI.FIRST_NAME_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.FIRST_NAME_ERROR_MESSAGE);
	}

	public String getErrorMessageAtLastnameTextbox() {
		waitForElementVisible(driver, UserRegisterPageUI.LAST_NAME_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.LAST_NAME_ERROR_MESSAGE);
	}

	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver, UserRegisterPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.EMAIL_ERROR_MESSAGE);
	}

	public String getErrorMessageAtPasswordTextbox() {
		waitForElementVisible(driver, UserRegisterPageUI.PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.PASSWORD_ERROR_MESSAGE);
	}

	public String getErrorMessageAtConfirmPasswordTextbox() {
		waitForElementVisible(driver, UserRegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
	}

	@Step("Enter to Firstname textbox with value is {0}")
	public void inputToFirstnameTextbox(String firstName) {
		waitForElementClickable(driver, UserRegisterPageUI.FIRST_NAME_TEXTBOX);
		senkeyToElement(driver, UserRegisterPageUI.FIRST_NAME_TEXTBOX, firstName);

	}

	@Step("Enter to Lastname textbox with value is {0}")
	public void inputToLastnameTextbox(String lastName) {
		waitForElementClickable(driver, UserRegisterPageUI.LAST_NAME_TEXTBOX);
		senkeyToElement(driver, UserRegisterPageUI.LAST_NAME_TEXTBOX, lastName);

	}

	@Step("Enter to EmailAdress textbox with value is {0}")
	public void inputToEmailTextbox(String emailAddress) {
		waitForElementClickable(driver, UserRegisterPageUI.EMAIL_TEXTBOX);
		senkeyToElement(driver, UserRegisterPageUI.EMAIL_TEXTBOX, emailAddress);
	}

	@Step("Enter to Password textbox with value is {0}")
	public void inputToPasswordTextbox(String password) {
		waitForElementClickable(driver, UserRegisterPageUI.PASSWORD_TEXTBOX);
		senkeyToElement(driver, UserRegisterPageUI.PASSWORD_TEXTBOX, password);
	}

	@Step("Enter to Confirm Password textbox with value is {0}")
	public void inputToConfirmPasswordTextbox(String confirmPassword) {
		waitForElementClickable(driver, UserRegisterPageUI.CONFIRM_PASSWORD);
		senkeyToElement(driver, UserRegisterPageUI.CONFIRM_PASSWORD, confirmPassword);

	}

	@Step("Verify register success message is displayed")
	public String getRegisterSuccessMessage() {
		waitForElementVisible(driver, UserRegisterPageUI.REGISTER_SUCCESS_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.REGISTER_SUCCESS_MESSAGE);
	}

	public UserHomePageObject clickToLogoutLink() {
		waitForElementClickable(driver, UserRegisterPageUI.LOGOUT_LINK);
		clickToElement(driver, UserRegisterPageUI.LOGOUT_LINK);
		return PageGeneratorManager.getUserHomePage(driver);

	}

	public String getErrorExistingEmailMessage() {
		waitForElementVisible(driver, UserRegisterPageUI.EXISTING_EMAIL_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.EXISTING_EMAIL_ERROR_MESSAGE);
	}

}
