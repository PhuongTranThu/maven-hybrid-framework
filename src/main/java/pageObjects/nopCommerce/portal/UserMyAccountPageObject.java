package pageObjects.nopCommerce.portal;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.portal.UserMyAccountPageUI;

public class UserMyAccountPageObject extends BasePage {

	public UserMyAccountPageObject(WebDriver driver) {
		this.driver = driver;
	}

	private WebDriver driver;

	public boolean isMyAccountPageDisplayed() {
		waitForElementVisible(driver, UserMyAccountPageUI.MY_ACCOUNT_TEXT);
		return isElementDisplayed(driver, UserMyAccountPageUI.MY_ACCOUNT_TEXT);
	}

}
