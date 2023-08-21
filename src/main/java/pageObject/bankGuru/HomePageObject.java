package pageObject.bankGuru;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.bankGuru.HomePageUIBankGuru;

public class HomePageObject extends BasePage{

	private WebDriver driver;
	
	public HomePageObject (WebDriver driver) {
		this.driver = driver;
	}

	public String getLoginSuccessMessage() {
		waitForElementVisible(driver, HomePageUIBankGuru.LOGIN_SUCCESS_MESSAGE);
		return getElementText(driver, HomePageUIBankGuru.LOGIN_SUCCESS_MESSAGE);
		
	}

	public void clickToCloseAlert(WebDriver driver) {
		
		
	}

}
