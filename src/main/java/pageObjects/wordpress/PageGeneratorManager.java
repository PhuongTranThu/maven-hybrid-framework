package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {

	public static AdminLoginPO getAdminLoginPage(WebDriver driver) {
		return new AdminLoginPO(driver);
	}
	
	public static AdminDashBoardPO getAdminDashBoardPage(WebDriver driver) {
		return new AdminDashBoardPO(driver);
	}
	
	public static AdminPostAddNewPO getAdminPostAddNewPage(WebDriver driver) {
		return new AdminPostAddNewPO(driver);
	}
	
	public static AdminPostCategoriesPO getPostCategoriesPage(WebDriver driver) {
		return new AdminPostCategoriesPO(driver);
	}
	
	public static AdminPostSearchPO getAdminPostSearchPage(WebDriver driver) {
		return new AdminPostSearchPO(driver);
	}
	
	public static AdminPostTagPO getAdminPostTagPage(WebDriver driver) {
		return new AdminPostTagPO(driver);
	}
	
	public static UserHomePO getUserHomePage(WebDriver driver) {
		return new UserHomePO(driver);
	}
	
	public static UserPostDetailPO getUserPostDetail(WebDriver driver) {
		return new UserPostDetailPO(driver);
	}
}
