package pageObjects.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveGuru.HomePageUI;

public class HomePageObject extends BasePage {
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	private WebDriver driver;

	public void clickToAccountLink() {
		waitForElementClickable(driver, HomePageUI.ACCOUNT_LINK);
		clickToElement(driver, HomePageUI.ACCOUNT_LINK);

	}

	public void clickToRegisterLink() {
		waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);

	}

	public void clickToLoginLink() {
		waitForElementClickable(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);

	}

}
