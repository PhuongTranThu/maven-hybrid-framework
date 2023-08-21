package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import io.qameta.allure.Step;
import pageUIs.wordpress.admin.AdminPostSearchPageUI;

public class AdminPostSearchPO extends BasePage{

	public AdminPostSearchPO (WebDriver driver) {
		this.driver = driver;
	}
	
	private WebDriver driver;

	@Step("Navigate to Amdin Post add new page")
	public AdminPostAddNewPO clickToAddNewButton() {
		waitForElementVisible(driver, AdminPostSearchPageUI.ADD_NEW_BUTTON);
		clickToElement(driver, AdminPostSearchPageUI.ADD_NEW_BUTTON);
		return PageGeneratorManager.getAdminPostAddNewPage(driver);
		
	}

	@Step("Enter to Search textbox with value {0}")
	public void enterToSearchTextbox(String postTitle) {
		waitForElementVisible(driver, AdminPostSearchPageUI.SEARCH_POST_TEXTBOX);
		senkeyToElement(driver, AdminPostSearchPageUI.SEARCH_POST_TEXTBOX, postTitle);
		
	}

	@Step("Click to Search button")
	public void clickToSearchPostsButton() {
		waitForElementClickable(driver, AdminPostSearchPageUI.SEARCH_POST_BUTTON);
		clickToElement(driver, AdminPostSearchPageUI.SEARCH_POST_BUTTON);
		
	}

	@Step("Verify Post search table displayed with cellValue is {0}")
	public boolean isPostSearchTableDisplayed(String headerID, String cellValue) {
		int headerIndex = getElementSize(driver, AdminPostSearchPageUI.TABLE_HEADER_INDEX_BY_HEADER_NAME, headerID) + 1;
		waitForElementVisible(driver, AdminPostSearchPageUI.TABLE_ROW_VALUE_BY_HEADER_INDEX, String.valueOf(headerIndex), cellValue);
		return isElementDisplayed(driver, AdminPostSearchPageUI.TABLE_ROW_VALUE_BY_HEADER_INDEX, String.valueOf(headerIndex), cellValue);
	}

	@Step("Click to Post title link")
	public AdminPostAddNewPO clickToPostTitleLink(String postTitle) {
		waitForElementClickable(driver, AdminPostSearchPageUI.ROW_TITLE_DETAIL_BY_TITLE_NAME, postTitle);
		clickToElement(driver, AdminPostSearchPageUI.ROW_TITLE_DETAIL_BY_TITLE_NAME, postTitle);
		return PageGeneratorManager.getAdminPostAddNewPage(driver);
	}

	@Step("Select post checkbox by title with post title is {0}")
	public void selectPostCheckboxByTitle(String editPostTitle) {
		waitForElementVisible(driver, AdminPostSearchPageUI.CHECKBOX_BY_TITLE_NAME, editPostTitle);
		checkToDefaultCheckboxOrRadio(driver, AdminPostSearchPageUI.CHECKBOX_BY_TITLE_NAME, editPostTitle);
		
	}

	@Step("Select text item in action dropdown")
	public void selectTextItemInActionDropdown(String action) {
		waitForElementVisible(driver, AdminPostSearchPageUI.ACTION_DROPDOWN, action);
		selectItemInDefaultDropdow(driver, AdminPostSearchPageUI.ACTION_DROPDOWN, action);
		 
	}

	@Step("Click to apply button")
	public void clickToApplyButton() {
		waitForElementClickable(driver, AdminPostSearchPageUI.APPLY_BUTTON);
		clickToElement(driver, AdminPostSearchPageUI.APPLY_BUTTON);
		
	}

	@Step("Verify Move To Trash message is displayed")
	public boolean isMoveToTrashMessageDisplayed(String message) {
		waitForElementVisible(driver, AdminPostSearchPageUI.MOVE_TO_TRASH_MESSAGE, message);
		return isElementDisplayed(driver, AdminPostSearchPageUI.MOVE_TO_TRASH_MESSAGE, message);
	}

	@Step("Verify No Post Found message is displayed")
	public boolean isNoPostFoundMessageDisplayed(String noPostMessage) {
		waitForElementVisible(driver, AdminPostSearchPageUI.NO_POST_FOUND_MESSAGE, noPostMessage);
		return isElementDisplayed(driver, AdminPostSearchPageUI.NO_POST_FOUND_MESSAGE, noPostMessage);
	}


}
