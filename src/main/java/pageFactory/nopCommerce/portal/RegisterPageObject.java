package pageFactory.nopCommerce.portal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;

public class RegisterPageObject extends BasePageFactory {
	private WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@id='register-button']")
	private WebElement registerButton;

	@FindBy(xpath = "//span[@id='FirstName-error']")
	private WebElement firstNameErrorMessage;

	@FindBy(xpath = "//span[@id='LastName-error']")
	private WebElement lastNameErrorMessage;

	@FindBy(xpath = "//span[@id='Email-error']")
	private WebElement emailErrorMessage;

	@FindBy(xpath = "//span[@id='Password-error']")
	private WebElement passwordErrorMessage;

	@FindBy(xpath = "//span[@id='ConfirmPassword-error']")
	private WebElement confirmPasswordErrorMessage;

	@FindBy(xpath = "//input[@id='FirstName']")
	private WebElement firstNameTextbox;

	@FindBy(xpath = "//input[@id='LastName']")
	private WebElement lastNameTextbox;

	@FindBy(xpath = "//input[@id='Email']")
	private WebElement emailTextbox;

	@FindBy(xpath = "//input[@id='Password']")
	private WebElement passwordTextbox;

	@FindBy(xpath = "//div[@class='result']")
	private WebElement registerSuccessMessage;

	@FindBy(xpath = "//a[@class='ico-logout']")
	private WebElement logoutLink;

	@FindBy(xpath = "//div[contains(@class,'message-error')]//li")
	private WebElement existingEmailErrorMessage;

	@FindBy(xpath = "//input[@id='ConfirmPassword']")
	private WebElement confirmPasswordTextbox;

	public void clickToRegisterButton() {
		waitForElementClickable(driver, registerButton);
		clickToElement(driver, registerButton);

	}

	public String getErrorMessageAtFirstnameTextbox() {
		waitForElementVisible(driver, firstNameErrorMessage);
		return getElementText(driver, firstNameErrorMessage);
	}

	public String getErrorMessageAtLastnameTextbox() {
		waitForElementVisible(driver, lastNameErrorMessage);
		return getElementText(driver, lastNameErrorMessage);
	}

	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver, emailErrorMessage);
		return getElementText(driver, emailErrorMessage);
	}

	public String getErrorMessageAtPasswordTextbox() {
		waitForElementVisible(driver, passwordErrorMessage);
		return getElementText(driver, passwordErrorMessage);
	}

	public String getErrorMessageAtConfirmPasswordTextbox() {
		waitForElementVisible(driver, confirmPasswordErrorMessage);
		return getElementText(driver, confirmPasswordErrorMessage);
	}

	public void inputToFirstnameTextbox(String firstName) {
		waitForElementClickable(driver, firstNameTextbox);
		senkeyToElement(driver, firstNameTextbox, firstName);

	}

	public void inputToLastnameTextbox(String lastName) {
		waitForElementClickable(driver, lastNameTextbox);
		senkeyToElement(driver, lastNameTextbox, lastName);

	}

	public void inputToEmailTextbox(String emailAddress) {
		waitForElementClickable(driver, emailTextbox);
		senkeyToElement(driver, emailTextbox, emailAddress);
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementClickable(driver, passwordTextbox);
		senkeyToElement(driver, passwordTextbox, password);
	}

	public void inputToConfirmPasswordTextbox(String confirmPassword) {
		waitForElementClickable(driver, confirmPasswordTextbox);
		senkeyToElement(driver, confirmPasswordTextbox, confirmPassword);
	}

	public String getRegisterSuccessMessage() {
		waitForElementVisible(driver, registerSuccessMessage);
		return getElementText(driver, registerSuccessMessage);
	}

	public void clickToLogoutLink() {
		waitForElementClickable(driver, logoutLink);
		clickToElement(driver, logoutLink);

	}

	public String getErrorExistingEmailMessage() {
		waitForElementVisible(driver, existingEmailErrorMessage);
		return getElementText(driver, existingEmailErrorMessage);
	}

}
