package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import io.qameta.allure.Step;
import pageUIs.wordpress.admin.AdminLoginPageUI;

public class AdminLoginPO extends BasePage{

	public AdminLoginPO (WebDriver driver) {
		this.driver = driver;
	}
	
	private WebDriver driver;

	@Step("Enter to User Name textbox with value is {0}")
	public void inputToUserNameTextbox(String valueUserName) {
		waitForElementVisible(driver, AdminLoginPageUI.USER_NAME_TEXTBOX);
		senkeyToElement(driver, AdminLoginPageUI.USER_NAME_TEXTBOX, valueUserName);
		
	}

	@Step("Enter to Password textbox with value is {0}")
	public void inputToPasswordTextbox(String valuePassword) {
		waitForElementVisible(driver, AdminLoginPageUI.PASSWORD_TEXTBOX);
		senkeyToElement(driver, AdminLoginPageUI.PASSWORD_TEXTBOX, valuePassword);
		
	}

	@Step("Navigate to Admin Dashboard")
	public AdminDashBoardPO clickToLoginButton() {
		waitForElementVisible(driver, AdminLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, AdminLoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getAdminDashBoardPage(driver);
	}
}
