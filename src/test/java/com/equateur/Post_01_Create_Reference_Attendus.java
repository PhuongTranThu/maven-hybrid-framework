package com.equateur;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import pageObjects.equateur.AttendusPageObject;
import pageObjects.equateur.CreateReferencePageObject;
import pageObjects.equateur.LoginPageObject;
import pageObjects.equateur.PageGenegatorManager;
import com.opencsv.CSVReader;
import java.io.FileReader;
import java.util.Iterator;

public class Post_01_Create_Reference_Attendus extends BaseTest{

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);	
		loginPage = PageGenegatorManager.getLoginPage(driver);
		dataFaker = Data_Faker.getDataHelper();	
		
		userCode = "6625";
		password = "test";
		referenceName = dataFaker.getReferenceName();
		
		libele = "tao test";
		nom = "pallete";
		poids_net = 1.34f;
		poids_brut = 5.6f;
		poids_add = 50f;
		longueur = 3.3f;
		largeur = 4.4f;
		hauteur = 5.67f;
		String CSV_PATH = GlobalConstants.PROJECT_PATH + "/src/test/resources/file.csv";
//		csvReader = new CSVReader(new FileReader(CSV_PATH));
//		
//		int i;
//		for (int i = 0; i < array.length; i++) {
//			
//		}
		code_barre = dataFaker.getCdnEAN();
		System.out.println(code_barre);
		
		
		loginPage.inputToUserCode(userCode);
		loginPage.inputPassword(password);
		attenduPage = loginPage.clickToLoginButton();
	}
	
	@Test
	public void User_01_Create_Attendus() {
		createReferencePage = attenduPage.clickToStockLink(driver);
		createReferencePage.clickToCreateReferenceButton();
		
		createReferencePage.inputToTextboxByName(driver, "nom", referenceName);
		createReferencePage.inputToTextboxByName(driver, "libelle_long", libele);
		
		createReferencePage.inputToTextboxStringCdnByName(driver, "nom", nom);
		createReferencePage.inputToTextboxCdnByName(driver, "poids_net", poids_net);
		createReferencePage.inputToTextboxCdnByName(driver, "poids_brut", poids_brut);
		createReferencePage.inputToTextboxCdnByName(driver, "poids_add", poids_add);
		createReferencePage.inputToTextboxCdnByName(driver, "longueur", longueur);
		createReferencePage.inputToTextboxCdnByName(driver, "largeur", largeur);
		createReferencePage.inputToTextboxCdnByName(driver, "hauteur", hauteur);
		createReferencePage.inputToTextboxStringCdnByName(driver, "code_barre", code_barre);
		

		
	}
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}
	
	private WebDriver driver;
	private LoginPageObject loginPage;
	private AttendusPageObject attenduPage;
	private CreateReferencePageObject createReferencePage;
	private Data_Faker dataFaker;
	private String userCode, password;
	private String referenceName, libele, nom, code_barre;
	private Float poids_net, poids_brut, poids_add, longueur, largeur, hauteur;
//	private cvsReader csvReader;

}
    
