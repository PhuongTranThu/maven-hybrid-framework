package com.wordpress.admin;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import io.qameta.allure.Description;
import pageObjects.wordpress.AdminDashBoardPO;
import pageObjects.wordpress.AdminLoginPO;
import pageObjects.wordpress.AdminPostAddNewPO;
import pageObjects.wordpress.AdminPostSearchPO;
import pageObjects.wordpress.PageGeneratorManager;
import pageObjects.wordpress.UserHomePO;
import pageObjects.wordpress.UserPostDetailPO;
import pageObjects.wordpress.UserSearchPostPO;

public class Post_01_Create_Read_Update_Delete_Update_Search extends BaseTest {
	
	String adminUsername = "admin";
	String adminPassword = "123456";
	String searchPostUrl;
	int  randomNumber = generateFakeNumber();
	String postTitle = "Title " + randomNumber;
	String postBody = "Body " + randomNumber;
	String editPostTitle = "Edit Title " + randomNumber;
	String editPostBody = "Edit Body " + randomNumber;
	String authorName = "admin";
	String currentDay = getCurrentDay();
	String adminUrl, endUserUrl;
	
	@Parameters({ "browser", "urlAdmin", "urlUser"})
	@BeforeClass
	public void beforeClass(String browserName, String adminUrl, String endUserUrl) {
		log.info("Pre-Condition - Step 01: Open browser and admin Url");
		this.adminUrl = adminUrl;
		this.endUserUrl = endUserUrl;
		driver = getBrowserDriver(browserName, this.adminUrl);
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);

		
		adminLoginPage.inputToUserNameTextbox(adminUsername);
		
		adminLoginPage.inputToPasswordTextbox(adminPassword);
		
		adminDashBoardPage = adminLoginPage.clickToLoginButton();
				
	}
	
	@Description("Create new post")
	@Test
	public void Post_01_Create_new_Post() {
		adminPostSearchPage = adminDashBoardPage.clickToPostMenuLink();
		
		searchPostUrl = adminPostSearchPage.getPageUrl(driver);
		
		adminPostAddNewPage = adminPostSearchPage.clickToAddNewButton();
		
		adminPostAddNewPage.enterToAddNewPostTitle(postTitle);
		
		adminPostAddNewPage.enterToAddnewPostBody(postBody );
		
		adminPostAddNewPage.clickToPublishOrEditButton();
		
		adminPostAddNewPage.clickToPrePublishButton();
		
		verifyTrue(adminPostAddNewPage.isPostMessageIsDisplayed("Post published."));
	}
	

	@Description("Search post")
	@Test
	public void Post_02_Search_Post() {
		adminPostSearchPage = adminPostAddNewPage.openSearchPostPageUrl(searchPostUrl);
		
		adminPostSearchPage.enterToSearchTextbox(postTitle);
		
		adminPostSearchPage.clickToSearchPostsButton();
		
		verifyTrue(adminPostSearchPage.isPostSearchTableDisplayed("title", postTitle));
		
		verifyTrue(adminPostSearchPage.isPostSearchTableDisplayed("author", authorName));
		
		userHomePage = adminPostSearchPage.openEndUserSite(driver, this.endUserUrl);
		
		verifyTrue(userHomePage.isPostInforDisplayedWithPostTitle(postTitle));
		verifyTrue(userHomePage.isPostInforDisplayedWithPostBody(postTitle, postBody));
		verifyTrue(userHomePage.isPostInforDisplayedWithPostAuthor(postTitle, authorName));
//		verifyTrue(userHomePage.isPostInforDisplayedWithPostCurrentDay(postTitle, currentDay));
		
		userPostDetailPage = userHomePage.clickToPostTitle(postTitle);
		
		verifyTrue(userPostDetailPage.isPostInforDisplayedWithPostTitle(postTitle));
		verifyTrue(userPostDetailPage.isPostInforDisplayedWithPostBody(postTitle, postBody));
		verifyTrue(userPostDetailPage.isPostInforDisplayedWithPostAuthor(postTitle, authorName));
//		verifyTrue(userPostDetailPage.isPostInforDisplayedWithPostCurrentDay(postTitle, currentDay));
	}
	

	@Description("Edit post")
	@Test
	public void Post_03_Edit_Post() {
		adminDashBoardPage = userPostDetailPage.openAdminSite(driver, this.adminUrl);
		
		adminPostSearchPage = adminDashBoardPage.clickToPostMenuLink();
		
		adminPostSearchPage.enterToSearchTextbox(postTitle);
		
		adminPostSearchPage.clickToSearchPostsButton();

		adminPostAddNewPage = adminPostSearchPage.clickToPostTitleLink(postTitle);
		
		adminPostAddNewPage.enterToAddNewPostTitle(editPostTitle);
		
		adminPostAddNewPage.enterToEditPostBody(editPostBody);
		
		adminPostAddNewPage.clickToPublishOrEditButton();
		
		verifyTrue(adminPostAddNewPage.isPostMessageIsDisplayed("Post updated."));
		
		adminPostSearchPage = adminPostAddNewPage.openSearchPostPageUrl(searchPostUrl);
		
		verifyTrue(adminPostSearchPage.isPostSearchTableDisplayed("title", editPostTitle));
		
		verifyTrue(adminPostSearchPage.isPostSearchTableDisplayed("author", authorName));
		
		userHomePage = adminPostSearchPage.openEndUserSite(driver, this.endUserUrl);
		
		verifyTrue(userHomePage.isPostInforDisplayedWithPostTitle(editPostTitle));
//		verifyTrue(userHomePage.isPostInforDisplayedWithPostBody(editPostTitle, editPostBody));
		verifyTrue(userHomePage.isPostInforDisplayedWithPostAuthor(editPostTitle, authorName));
//		verifyTrue(userHomePage.isPostInforDisplayedWithPostCurrentDay(editPostTitle, currentDay));
		
		userPostDetailPage = userHomePage.clickToPostTitle(editPostTitle);

		verifyTrue(userPostDetailPage.isPostInforDisplayedWithPostTitle(editPostTitle));
//		verifyTrue(userPostDetailPage.isPostInforDisplayedWithPostBody(editPostTitle, editPostBody));
		verifyTrue(userPostDetailPage.isPostInforDisplayedWithPostAuthor(editPostTitle, authorName));
//		verifyTrue(userPostDetailPage.isPostInforDisplayedWithPostCurrentDay(editPostTitle, currentDay));
	}
	
	@Description("Edit post")
	@Test
	public void Post_04_Delete_Post() {
		adminDashBoardPage = userPostDetailPage.openAdminSite(driver, this.adminUrl);
		
		adminPostSearchPage = adminDashBoardPage.clickToPostMenuLink();
		
		adminPostSearchPage.enterToSearchTextbox(editPostTitle);
		
		adminPostSearchPage.clickToSearchPostsButton();
		
		adminPostSearchPage.selectPostCheckboxByTitle(editPostTitle);
		
		adminPostSearchPage.selectTextItemInActionDropdown("Move to Trash");
		
		adminPostSearchPage.clickToApplyButton();
		
		adminPostSearchPage.isMoveToTrashMessageDisplayed("1 post moved to the Trash.");
		
		adminPostSearchPage.enterToSearchTextbox(editPostTitle);
		
		adminPostSearchPage.clickToSearchPostsButton();
		
		adminPostSearchPage.isNoPostFoundMessageDisplayed("No posts found.");
		
		userHomePage = adminPostSearchPage.openEndUserSite(driver, this.endUserUrl);
		
		verifyTrue(userHomePage.isPostInforUnDiplayedWithPostTitle(editPostTitle));
		
//		userHomePage.enterToSearchTextbox();
//		
//		userSearchPostPage = userHomePage.clickToSearchButton();
//		
//		userSearchPostPage.isNothingFoundMessageDisplayed();
	}
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}
	
	private WebDriver driver;
	private AdminLoginPO adminLoginPage;
	private AdminDashBoardPO adminDashBoardPage;
	private AdminPostAddNewPO adminPostAddNewPage;
	private AdminPostSearchPO adminPostSearchPage;
	private UserHomePO userHomePage;
	private UserPostDetailPO userPostDetailPage;
	private UserSearchPostPO userSearchPostPage;
	

}
