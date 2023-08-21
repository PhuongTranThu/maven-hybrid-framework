package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import io.qameta.allure.Step;
import pageUIs.wordpress.admin.AdminDashboardPageUI;

public class AdminDashBoardPO extends BasePage{
	
	public AdminDashBoardPO (WebDriver driver) {
		this.driver = driver;
	}
	
	private WebDriver driver;

	@Step("Navigate to Admin Post Search Page")
	public AdminPostSearchPO clickToPostMenuLink() {
		waitForElementVisible(driver, AdminDashboardPageUI.POSTS_LINK);
		clickToElement(driver, AdminDashboardPageUI.POSTS_LINK);
		return PageGeneratorManager.getAdminPostSearchPage(driver);
		
	}
	

}
