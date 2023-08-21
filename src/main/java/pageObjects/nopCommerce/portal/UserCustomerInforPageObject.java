package pageObjects.nopCommerce.portal;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.BasePageUI;
import pageUIs.nopCommerce.portal.UserCustomerInforPageUI;

public class UserCustomerInforPageObject extends BasePage {

	public UserCustomerInforPageObject(WebDriver driver) {
		this.driver = driver;
	}

	private WebDriver driver;

	public boolean isCustomerInforPageDisplayed() {
		waitForElementVisible(driver, UserCustomerInforPageUI.CUSTOMER_INFOR_HEADER);
		return isElementDisplayed(driver, UserCustomerInforPageUI.CUSTOMER_INFOR_HEADER);
	}

	public void clickToRadioButtonGender(WebDriver driver, String valueButtonLabel) {
		waitForElementVisible(driver, UserCustomerInforPageUI.GENDER_RADIO_BUTTON, valueButtonLabel);
		checkToDefaultCheckboxOrRadio(driver, UserCustomerInforPageUI.GENDER_RADIO_BUTTON, valueButtonLabel);
		
	}

	public String getTextEditSuccess(WebDriver driver) {
		waitForElementVisible(driver, UserCustomerInforPageUI.EDIT_SUCCESS_TEXT);
		return getElementText(driver, UserCustomerInforPageUI.EDIT_SUCCESS_TEXT);
	}

}
