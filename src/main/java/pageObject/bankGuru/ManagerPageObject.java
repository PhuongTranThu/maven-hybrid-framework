package pageObject.bankGuru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.bankGuru.BasePageUIBankGuru;
import pageUIs.bankGuru.ManagerPageUIBankGuru;

public class ManagerPageObject extends BasePage{
	
	private WebDriver driver;
	public ManagerPageObject (WebDriver driver) {
		this.driver = driver;
	}
	
	public String getRegisterSuccess() {
		waitForElementVisible(driver, ManagerPageUIBankGuru.REGISTER_SUCCESS_MESSAGE);
		return getElementText(driver, ManagerPageUIBankGuru.REGISTER_SUCCESS_MESSAGE);
	}

	public String getCustomerId() {
		waitForElementVisible(driver, ManagerPageUIBankGuru.CUSTOMER_TEXT);
		return getElementText(driver,  ManagerPageUIBankGuru.CUSTOMER_TEXT);
		
	}


}
