package pageObjects.liveTechpanda.admin;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	public static AdminHomePageObject getAdminHomePage(WebDriver driver) {
		return new AdminHomePageObject(driver);
	}

	public static AdminLoginPageObject getAdminLoginPage(WebDriver driver) {
		return new AdminLoginPageObject(driver);
	}

}
