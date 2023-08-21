package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import io.qameta.allure.Step;
import pageUIs.wordpress.admin.UserHomePageUI;

public class UserHomePO extends BasePage{

	public UserHomePO (WebDriver driver) {
		this.driver = driver;
	}
	
	private WebDriver driver;

	@Step("Verify Post infor displayed with postTitle is {0}")
	public boolean isPostInforDisplayedWithPostTitle(String postTitle) {
		waitForElementVisible(driver, UserHomePageUI.POST_TITLE_TEXT, postTitle);
		return isElementDisplayed(driver, UserHomePageUI.POST_TITLE_TEXT, postTitle);
	}

	@Step("Verify Post infor displayed with postBody is {0}")
	public boolean isPostInforDisplayedWithPostBody(String postTitle, String postBody) {
		waitForElementVisible(driver, UserHomePageUI.POST_BODY_TEXT_BY_POST_TITLE, postTitle, postBody);
		return isElementDisplayed(driver, UserHomePageUI.POST_BODY_TEXT_BY_POST_TITLE, postTitle, postBody);
	}

	@Step("Verify Post infor displayed with postAuthor is {0}")
	public boolean isPostInforDisplayedWithPostAuthor(String postTitle,String authorName) {
		waitForElementVisible(driver, UserHomePageUI.POST_AUTHOR_TEXT_BY_POST_TITLE, postTitle, authorName);
		return isElementDisplayed(driver, UserHomePageUI.POST_AUTHOR_TEXT_BY_POST_TITLE, postTitle, authorName);
	}

	@Step("Verify Post infor displayed with postCurrentDay is {0}")
	public boolean isPostInforDisplayedWithPostCurrentDay(String postTitle,String currentDay) {
		waitForElementVisible(driver, UserHomePageUI.POST_CURRENT_DATE_TEXT_BY_POST_TITLE, postTitle, currentDay);
		return isElementDisplayed(driver, UserHomePageUI.POST_CURRENT_DATE_TEXT_BY_POST_TITLE, postTitle, currentDay);
	}

	@Step("Click to Post title")
	public UserPostDetailPO clickToPostTitle(String postTitle) {
		waitForElementClickable(driver, UserHomePageUI.POST_TITLE_TEXT, postTitle);
		clickToElement(driver, UserHomePageUI.POST_TITLE_TEXT, postTitle);
		return PageGeneratorManager.getUserPostDetail(driver);
	}

	@Step("Verify Post title Undisplayed")
	public boolean isPostInforUnDiplayedWithPostTitle(String editPostTitle) {
		return isElementUndisplayed(driver, UserHomePageUI.POST_TITLE_TEXT, editPostTitle);
	}

	public void enterToSearchTextbox() {
		// TODO Auto-generated method stub
		
	}

	public UserSearchPostPO clickToSearchButton() {
		// TODO Auto-generated method stub
		return null;
	}
}
