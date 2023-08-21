package pageObjects.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveGuru.RegisterPageUI;

public class RegisterPageObject extends BasePage {
	private WebDriver driver;

	public void inputToFirstName(String firstName) {
		waitForElementVisible(driver, RegisterPageUI.FIRST_NAME_TEXTBOX);
		senkeyToElement(driver, RegisterPageUI.FIRST_NAME_TEXTBOX, firstName);

	}

	public void inputToLastName() {
		// TODO Auto-generated method stub

	}

	public void inputToEmailAddress() {
		// TODO Auto-generated method stub

	}

	public void inputToPassword() {
		// TODO Auto-generated method stub

	}

	public void inputToConfirmPassword() {
		// TODO Auto-generated method stub

	}

	public void clickToRegisterButton() {
		// TODO Auto-generated method stub

	}

}
