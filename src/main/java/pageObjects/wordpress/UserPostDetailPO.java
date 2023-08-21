package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import io.qameta.allure.Step;
import pageUIs.wordpress.admin.UserHomePageUI;
import pageUIs.wordpress.admin.UserPostDetailPageUI;

public class UserPostDetailPO extends BasePage{
	public UserPostDetailPO (WebDriver driver) {
		this.driver = driver;
	}
	
	private WebDriver driver;

	@Step("Verify Post infor displayed with postTitle is {0}")
	public boolean isPostInforDisplayedWithPostTitle(String postTitle) {
		waitForElementVisible(driver, UserPostDetailPageUI.POST_TITLE_TEXT, postTitle);
		return isElementDisplayed(driver, UserPostDetailPageUI.POST_TITLE_TEXT, postTitle);
	}
	
	@Step("Verify Post infor displayed with postBody is {0}")
	public boolean isPostInforDisplayedWithPostBody(String postTitle, String postBody) {
		waitForElementVisible(driver, UserPostDetailPageUI.POST_BODY_TEXT_BY_POST_TITLE, postTitle, postBody);
		return isElementDisplayed(driver, UserPostDetailPageUI.POST_BODY_TEXT_BY_POST_TITLE, postTitle, postBody);
	}

	@Step("Verify Post infor displayed with postAuthor is {0}")
	public boolean isPostInforDisplayedWithPostAuthor(String postTitle,String authorName) {
		waitForElementVisible(driver, UserPostDetailPageUI.POST_AUTHOR_TEXT_BY_POST_TITLE, postTitle, authorName);
		return isElementDisplayed(driver, UserPostDetailPageUI.POST_AUTHOR_TEXT_BY_POST_TITLE, postTitle, authorName);
	}

	@Step("Verify Post infor displayed with postCurrentDay is {0}")
	public boolean isPostInforDisplayedWithPostCurrentDay(String postTitle,String currentDay) {
		waitForElementVisible(driver, UserPostDetailPageUI.POST_CURRENT_DATE_TEXT_BY_POST_TITLE, postTitle, currentDay);
		return isElementDisplayed(driver, UserPostDetailPageUI.POST_CURRENT_DATE_TEXT_BY_POST_TITLE, postTitle, currentDay);
	}

	@Step("Click To Post title")
	public UserPostDetailPO clickToPostTitle(String postTitle) {
		waitForElementClickable(driver, UserPostDetailPageUI.POST_TITLE_TEXT, postTitle);
		clickToElement(driver, UserPostDetailPageUI.POST_TITLE_TEXT, postTitle);
		return PageGeneratorManager.getUserPostDetail(driver);
	}
	
}
