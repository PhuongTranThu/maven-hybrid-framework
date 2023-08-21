package pageObject.bankGuru;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class EditAccountPageObject extends BasePage{
	
	private WebDriver driver;
	
	public EditAccountPageObject(WebDriver driver) {
		this.driver =  driver;
	}

	public void closeAlert() {

		try {
			acceptAlert(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	

}
