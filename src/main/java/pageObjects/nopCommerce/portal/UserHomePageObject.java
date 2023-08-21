package pageObjects.nopCommerce.portal;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import io.qameta.allure.Step;
import pageUIs.nopCommerce.portal.UserHomePageUI;
import pageUIs.nopCommerce.portal.UserLoginPageUI;

public class UserHomePageObject extends BasePage {

	public UserHomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	private WebDriver driver;

	@Step("Navigate to Register page")
	public UserRegisterPageObject clickToRegisterLink() {
		waitForElementClickable(driver, UserHomePageUI.REGISTER_LINK);
		clickToElement(driver, UserHomePageUI.REGISTER_LINK);
		return PageGeneratorManager.getUserRegisterPage(driver);

	}

	@Step("Navigate to Login page")
	public UserLoginPageObject clickToLoginLink() {
		waitForElementClickable(driver, UserHomePageUI.LOGIN_LINK);
		clickToElement(driver, UserHomePageUI.LOGIN_LINK);
		return PageGeneratorManager.getUserLoginPage(driver);

	}

	@Step("Verify 'My Account' link to displayed")
	public boolean isMyAccountLinkDisplayed() {
		waitForElementVisible(driver, UserLoginPageUI.MY_ACCOUNT_LINK);
		return isElementDisplayed(driver, UserLoginPageUI.MY_ACCOUNT_LINK);
	}

	@Step("Navigate to 'My Account' page")
	public UserCustomerInforPageObject openMyAccountPage() {
		waitForElementClickable(driver, UserHomePageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, UserHomePageUI.MY_ACCOUNT_LINK);
		return PageGeneratorManager.getUserCustomerInforPageObject(driver);
	}

	public UserSearchPageObject clickToSearchLink() {
		waitForElementVisible(driver, UserHomePageUI.SEARCH_LINK);
		clickToElement(driver, UserHomePageUI.SEARCH_LINK);
		return PageGeneratorManager.getSearchPageObject(driver);
		
	}


}
