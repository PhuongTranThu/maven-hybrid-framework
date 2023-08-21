package pageObjects.equateur;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.equateur.LoginPageUI;

public class LoginPageObject extends BasePage {

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}
	private WebDriver driver;
	public void inputToUserCode(String userCode) {
		waitForAllElementVisible(driver, LoginPageUI.USER_CODE_TEXTBOX);
		senkeyToElement(driver, LoginPageUI.USER_CODE_TEXTBOX, userCode);
	}
	
	public void inputPassword(String password) {
		waitForAllElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		senkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
	}

	public AttendusPageObject clickToLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageGenegatorManager.getAttendusPage(driver);
	}

}
