package pageObjects.facebook;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.facebook.LoginPageUI;

public class LoginPageObject extends BasePage {
	WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToCreateNewAccountButton() {
		waitForElementClickable(driver, LoginPageUI.CREATE_NEW_ACCOUNT_BUTTON);
		clickToElement(driver, LoginPageUI.CREATE_NEW_ACCOUNT_BUTTON);

	}

	public boolean isEmailAdressTextboxDisplayed() {
		waitForElementVisible(driver, LoginPageUI.EMAIL_ADDRESS_TEXTBOX);
		return isElementDisplayed(driver, LoginPageUI.EMAIL_ADDRESS_TEXTBOX);
	}

	public void enterToEmailAdressTextbox(String emailAdress) {
		waitForAllElementVisible(driver, LoginPageUI.EMAIL_ADDRESS_TEXTBOX);
		senkeyToElement(driver, LoginPageUI.EMAIL_ADDRESS_TEXTBOX, emailAdress);

	}

	public boolean isConfirmEmailAdressTextboxDisplayed() {
		return isElementDisplayed(driver, LoginPageUI.CONFIRM_EMAIL_ADDRESS_TEXTBOX);
	}

	public void clickToCloseButtonInRegisterFrom() {
		waitForElementClickable(driver, LoginPageUI.CLOSE_ICON);
		clickToElement(driver, LoginPageUI.CLOSE_ICON);

	}

	public boolean isConfirmEmailAdressTextboxUndisplayed() {
		waitForElementUndisplayed(driver, LoginPageUI.CONFIRM_EMAIL_ADDRESS_TEXTBOX);
		return isElementUndisplayed(driver, LoginPageUI.CONFIRM_EMAIL_ADDRESS_TEXTBOX);
	}

}
