package pageObject.bankGuru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.bankGuru.LoginPageUIBankGuru;

public class LoginPageObject extends BasePage{

	public LoginPageObject(WebDriver driver) {
		this.driver =  driver;
	}
	
	private WebDriver driver;

	public void inputToUserId(String userId) {
		waitForElementVisible(driver, LoginPageUIBankGuru.USERID_TEXTBOX);
		senkeyToElement(driver, LoginPageUIBankGuru.USERID_TEXTBOX, userId);
		
	}

	public void inputToPassword(String password) {
		waitForElementVisible(driver, LoginPageUIBankGuru.PASSWORD_TEXTBOX);
		senkeyToElement(driver, LoginPageUIBankGuru.PASSWORD_TEXTBOX, password);
		
	}

	public HomePageObject clickToLoginButton() {
		waitForElementClickable(driver, LoginPageUIBankGuru.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUIBankGuru.LOGIN_BUTTON);
		return PageGeneratorManager.getHomePage(driver);
	}
}
