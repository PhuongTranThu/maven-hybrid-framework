package com.facebook;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.facebook.LoginPageObject;
import pageObjects.facebook.PageGeneratorManager;

public class Level_13_Element_Undisplayed extends BaseTest {

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);

		loginPage = PageGeneratorManager.getLoginPageObject(driver);

	}

	@Test
	public void TC_01_Verify_Element_Displayed() {
		loginPage.clickToCreateNewAccountButton();

		// nếu 1 hàm chỉ mong muốn verify display thôi -> kết hợp cả wait + isDissplayed
		// waitzForElementVisible
		// isElementDisplayed

		// Verify True - mong đợi Confirm Email Displayed
		loginPage.enterToEmailAdressTextbox("abc@gmail.com");
		loginPage.sleepInSecond(2);
		verifyTrue(loginPage.isConfirmEmailAdressTextboxDisplayed());

	}

	@Test
	public void TC_02_Verify_Element_Displayed_In_DOM() {

		// Nếu như mong đợi 1 hàm vừa verify Displayed vừa verify UnDisplayed thì ko dùng wait
		// isElementDisplayed

		// Verify False - mong đợi Confirm Email UnDisplayed
		loginPage.enterToEmailAdressTextbox("");
		loginPage.sleepInSecond(2);
		// verifyFalse(loginPage.isConfirmEmailAdressTextboxDisplayed());
		verifyTrue(loginPage.isConfirmEmailAdressTextboxUndisplayed());

	}

	@Test
	public void TC_03_Verify_Element_Displayed_Not_In_DOM() {
		loginPage.clickToCloseButtonInRegisterFrom();
		loginPage.sleepInSecond(3);
		// Khi Close button ở from Register đi -> Confirm Email ko còn trong DOM nữa
		// Nên hàm findElement sẽ bị fail vì ko tìm thấy element
		// 1. Nó sẽ chờ tới hết timeout của implicit: 30s
		// 2. Nó sẽ đành fail TC tại đúng step này luôn
		// 3. Ko chạy step còn lại nữa

		// Hmaf isDisplayed: bản chất ko kiểm tra 1 element ko có trong DOM được
		// verifyFalse(loginPage.isConfirmEmailAdressTextboxDisplayed());

		verifyTrue(loginPage.isConfirmEmailAdressTextboxUndisplayed());

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	private WebDriver driver;
	private LoginPageObject loginPage;

}
