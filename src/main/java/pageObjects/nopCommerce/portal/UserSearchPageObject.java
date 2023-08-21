package pageObjects.nopCommerce.portal;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.portal.UserSearchPageUI;

public class UserSearchPageObject extends BasePage{

	WebDriver driver;
	public UserSearchPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public Object getMessageSearchPage(WebDriver driver, String messageValue) {
		waitForElementVisible(driver, UserSearchPageUI.MESSAGE_TEXT_SEARCH_EMPTY, messageValue);
		return getElementText(driver, UserSearchPageUI.MESSAGE_TEXT_SEARCH_EMPTY, messageValue);
	}
}
