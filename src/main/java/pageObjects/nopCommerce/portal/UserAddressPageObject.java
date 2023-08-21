package pageObjects.nopCommerce.portal;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.portal.UserAddressPageUI;

public class UserAddressPageObject extends BasePage {

	public UserAddressPageObject(WebDriver driver) {
		this.driver = driver;
	}

	private WebDriver driver;

	public String getTextNewAddressSuccess(WebDriver driver) {
		waitForElementVisible(driver, UserAddressPageUI.MESSAGE_NEW_ADDRESS_SUCCESS);
		return getElementText(driver, UserAddressPageUI.MESSAGE_NEW_ADDRESS_SUCCESS);
	}

	public String getAttributeValueText(WebDriver driver,String textName) {
		waitForElementVisible(driver, UserAddressPageUI.DYNAMIC_ATTRIBUTE_BY_TEXT, textName);
		return getElementAttibute(driver, UserAddressPageUI.DYNAMIC_ATTRIBUTE_BY_TEXT, textName);
	}

}
