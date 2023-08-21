package pageObjects.equateur;

import org.openqa.selenium.WebDriver;

public class PageGenegatorManager {

	public static LoginPageObject getLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
		
	}
	public static AttendusPageObject getAttendusPage(WebDriver driver) {
		return new AttendusPageObject(driver);
		
	}
	public static CreateReferencePageObject getCreateReferencePage(WebDriver driver) {
	return new CreateReferencePageObject(driver);
	
	}
}
