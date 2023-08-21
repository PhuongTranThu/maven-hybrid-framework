package pageObjects.equateur;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.equateur.CreateStockPageUI;

public class CreateReferencePageObject extends BasePage{

	public CreateReferencePageObject(WebDriver driver) {
		this.driver = driver;
	}
	private WebDriver driver;
	
	public void clickToCreateReferenceButton() {
		waitForElementClickable(driver, CreateStockPageUI.ADD_STOCK_BUTTON);
		clickToElement(driver, CreateStockPageUI.ADD_STOCK_BUTTON);
		
	}

	public void inputToTextboxByName(WebDriver driver, String textboxName, String referenceName) {
		waitForElementVisible(driver, CreateStockPageUI.DYNAMIC_TEXTBOX_BY_NAME, textboxName);
		senkeyToElement(driver, CreateStockPageUI.DYNAMIC_TEXTBOX_BY_NAME, referenceName, textboxName);
		
	}
	
	public void inputToTextboxStringCdnByName(WebDriver driver, String textboxName, String value) {
		waitForElementVisible(driver, CreateStockPageUI.DYNAMIC_TEXTBOX_CDN_BY_NAME, textboxName);
		senkeyToElement(driver, CreateStockPageUI.DYNAMIC_TEXTBOX_CDN_BY_NAME, value, textboxName);
		
	}

	public void inputToTextboxCdnByName(WebDriver driver, String textboxName, Float value) {
		waitForElementVisible(driver, CreateStockPageUI.DYNAMIC_TEXTBOX_CDN_BY_NAME, textboxName);
		senkeyToFloatElement(driver, CreateStockPageUI.DYNAMIC_TEXTBOX_CDN_BY_NAME, value, textboxName);
		
	}
	




}
