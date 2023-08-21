package commons;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObject.bankGuru.ManagerPageObject;
import pageObject.bankGuru.PageGeneratorManager;
import pageObjects.equateur.CreateReferencePageObject;
import pageObjects.equateur.PageGenegatorManager;
import pageObjects.nopCommerce.admin.AdminLoginPageObject;
import pageObjects.nopCommerce.portal.UserAddressPageObject;
import pageObjects.nopCommerce.portal.UserHomePageObject;
import pageObjects.nopCommerce.portal.UserMyProductReviewPageObject;
import pageObjects.nopCommerce.portal.UserRewardPointPageObject;
import pageObjects.wordpress.AdminDashBoardPO;
import pageUIs.JQuery.uploadFile.BasePageJQueryUI;
import pageUIs.bankGuru.BasePageUIBankGuru;
import pageUIs.bankGuru.HomePageUIBankGuru;
import pageUIs.bankGuru.ManagerPageUIBankGuru;
import pageUIs.equateur.AttendusPageUI;
import pageUIs.equateur.BaseUI;
import pageUIs.nopCommerce.portal.UserCustomerInforPageUI;

public class BasePage {

	public static BasePage getBasePageObject() {
		return new BasePage();
	}

	public void openPageUrl(WebDriver driver, String pageUrl) {
		driver.get(pageUrl);
	}

	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String getPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public String getPageSourceCode(WebDriver driver) {
		return driver.getPageSource();
	}

	public void backToPage(WebDriver driver) {
		driver.navigate().back();
	}

	public void forwardToPage(WebDriver driver) {
		driver.navigate().forward();
	}

	public void refreshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();
	}
	
	public Set<Cookie> getAllCookies(WebDriver driver) {
		return driver.manage().getCookies();
	}
	
	public void setCookies (WebDriver driver, Set<Cookie> cookies) {
		for (Cookie cookie : cookies) {
			driver.manage().addCookie(cookie);
		}
		sleepInSecond(3);
	}

	public Alert waitForAlertPresence(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		return explicitWait.until(ExpectedConditions.alertIsPresent());
	}

	public void acceptAlert(WebDriver driver) {
		waitForAlertPresence(driver).accept();
	}

	public void cancelAlert(WebDriver driver) {
		waitForAlertPresence(driver).dismiss();
	}

	public String getAlertText(WebDriver driver) {
		return waitForAlertPresence(driver).getText();
	}

	public void senKeyToAlert(WebDriver driver, String textValue) {
		waitForAlertPresence(driver).sendKeys(textValue);
	}

	public void switchToWindowByID(WebDriver driver, String parentID) {
		Set<String> allWindownIDs = driver.getWindowHandles();
		for (String id : allWindownIDs) {
			if (!id.equals(parentID)) {
				driver.switchTo().window(id);
				break;
			}
		}

	}

	public void switchToWindownByTitle(WebDriver driver, String expectedPageTitle) {
		Set<String> allWindownIDs = driver.getWindowHandles();
		for (String id : allWindownIDs) {
			driver.switchTo().window(id);
			String currentPageTitle = driver.getTitle();
			if (currentPageTitle.equals(expectedPageTitle)) {
				break;
			}
		}
	}

	public void closeAllWindowWithoutParent(WebDriver driver, String parentID) {
		Set<String> allWindownIDs = driver.getWindowHandles();
		for (String id : allWindownIDs) {
			if (!id.equals(parentID)) {
				driver.switchTo().window(id);
				driver.close();
			}
		}
		driver.switchTo().window(parentID);
	}

	public By getByLocator(String locatorType) {
		By by = null;
		if (locatorType.startsWith("id=") || locatorType.startsWith("ID=") || locatorType.startsWith("Id=")) {
			by = By.id(locatorType.substring(3));
		} else if (locatorType.startsWith("class=") || locatorType.startsWith("CLASS=") || locatorType.startsWith("Class=")) {
			by = By.className(locatorType.substring(6));
		} else if (locatorType.startsWith("name=") || locatorType.startsWith("NAME=") || locatorType.startsWith("Name=")) {
			by = By.name(locatorType.substring(5));
		} else if (locatorType.startsWith("css=") || locatorType.startsWith("CSS=") || locatorType.startsWith("Css=")) {
			by = By.cssSelector(locatorType.substring(4));
		} else if (locatorType.startsWith("xpath=") || locatorType.startsWith("XPATH=") || locatorType.startsWith("Xpath=")) {
			by = By.xpath(locatorType.substring(6));
		} else {
			throw new RuntimeException("Locator type is not supported");
		}
		return by;
	}

	public String getDynamicXpath(String locatorType, String... dynamicValues) {
		if (locatorType.startsWith("xpath=") || locatorType.startsWith("XPATH=") || locatorType.startsWith("Xpath=")) {
			locatorType = String.format(locatorType, (Object[]) dynamicValues);
		}
		return locatorType;
	}

	public WebElement getWebElement(WebDriver driver, String locatorType) {
		return driver.findElement(getByLocator(locatorType));
	}

	public List<WebElement> getListWebElement(WebDriver driver, String locatorType) {
		return driver.findElements(getByLocator(locatorType));
	}

	public void clickToElement(WebDriver driver, String locatorType) {
		getWebElement(driver, locatorType).click();
	}

	public void clickToElement(WebDriver driver, String locatorType, String... dynamicValues) {
		getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).click();
	}

	public void senkeyToElement(WebDriver driver, String locatorType, String textValue) {
		WebElement element = getWebElement(driver, locatorType);
		element.clear();
		element.sendKeys(textValue);
	}

	public void senkeyToElement(WebDriver driver, String locatorType, String textValue, String... dynamicValues) {
		WebElement element = getWebElement(driver, getDynamicXpath(locatorType, dynamicValues));
		element.clear();
		element.sendKeys(textValue);
	}
	
	public void senkeyToFloatElement(WebDriver driver, String locatorType, Float textValue, String... dynamicValues) {
		WebElement element = getWebElement(driver, getDynamicXpath(locatorType, dynamicValues));
		element.clear();
		element.sendKeys(Float.toString(textValue));
	}
	
	public void clearValueInElementByPressKey(WebDriver driver, String locatorType) {
		WebElement element = getWebElement(driver, getDynamicXpath(locatorType));
		element.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.CLEAR));
	}

	public void selectItemInDefaultDropdow(WebDriver driver, String locatorType, String textValue) {
		Select select = new Select(getWebElement(driver, locatorType));
		select.selectByVisibleText(textValue);
	}

	public void selectItemInDefaultDropdow(WebDriver driver, String locatorType, String textValue, String... dynamicValues) {
		Select select = new Select(getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)));
		select.selectByVisibleText(textValue);
	}

	public String getSelectedItemDefaultDropdown(WebDriver driver, String locatorType) {
		Select select = new Select(getWebElement(driver, locatorType));
		return select.getFirstSelectedOption().getText();
	}

	public String getSelectedItemDefaultDropdown(WebDriver driver, String locatorType, String... dynamicValues) {
		Select select = new Select(getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)));
		return select.getFirstSelectedOption().getText();
	}

	public boolean isDropdownMultiple(WebDriver driver, String locatorType) {
		Select select = new Select(getWebElement(driver, locatorType));
		return select.isMultiple();
	}

	public boolean isDropdownMultiple(WebDriver driver, String locatorType, String... dynamicValues) {
		Select select = new Select(getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)));
		return select.isMultiple();
	}

	public void selectItemInCustomDropdown(WebDriver driver, String parentXpath, String childXpath, String textExpectedItem) {
		getWebElement(driver, parentXpath).click();
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(childXpath)));
		List<WebElement> allItems = driver.findElements(By.xpath(childXpath));
		for (WebElement item : allItems) {
			String textActualItem = item.getText();
			if (textExpectedItem.equals(textActualItem)) {
				item.click();
			}
		}
	}

	public String getElementAttibute(WebDriver driver, String xpathLocator, String attributeName) {
		return getWebElement(driver, xpathLocator).getAttribute(attributeName);
	}
	
	public String getElementAttibute(WebDriver driver, String locatorType, String attributeName, String... dynamicValues) {
		return getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).getAttribute(attributeName);
	}

	public String getElementText(WebDriver driver, String locatorType) {
		return getWebElement(driver, locatorType).getText();
	}

	public String getElementText(WebDriver driver, String locatorType, String... dynamicValues) {
		return getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).getText();
	}

	public String getElementCssValue(WebDriver driver, String locatorType) {
		return getWebElement(driver, locatorType).getCssValue(locatorType);
	}

	public String getHexaColorFromRGBA(String rgbaValue) {
		return Color.fromString(rgbaValue).asHex();
	}

	public int getElementSize(WebDriver driver, String locatorType) {
		return getListWebElement(driver, locatorType).size();
	}

	public int getElementSize(WebDriver driver, String locatorType, String... dynamicValues) {
		return getListWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).size();
	}

	public void checkToDefaultCheckboxOrRadio(WebDriver driver, String locatorType) {
		WebElement element = getWebElement(driver, locatorType);
		if (!element.isSelected()) {
			element.click();
		}
	}

	public void checkToDefaultCheckboxOrRadio(WebDriver driver, String locatorType, String... dynamicValues) {
		WebElement element = getWebElement(driver, getDynamicXpath(locatorType, dynamicValues));
		if (!element.isSelected()) {
			element.click();
		}
	}

	public void uncheckToDefaultCheckboxRadio(WebDriver driver, String locatorType) {
		WebElement element = getWebElement(driver, locatorType);
		if (element.isSelected()) {
			element.click();
		}
	}

	public void uncheckToDefaultCheckboxRadio(WebDriver driver, String locatorType, String... dynamicValues) {
		WebElement element = getWebElement(driver, getDynamicXpath(locatorType, dynamicValues));
		if (element.isSelected()) {
			element.click();
		}
	}

	public boolean isElementDisplayed(WebDriver driver, String locatorType) {
		try {
			// Tìm thấy element
			// Case 1: Displayed - trả về true
			// Case 2: Undisplayed - trả về false
			return getWebElement(driver, locatorType).isDisplayed();
		} catch (NoSuchElementException e) {
			// Case 3: Undisplayed - trả về false
		}
		return false;
	}

	public boolean isElementDisplayed(WebDriver driver, String locatorType, String... dynamicValues) {
		return getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).isDisplayed();
	}

	// Case 2 + 3
	public boolean isElementUndisplayed(WebDriver driver, String locator) {
		overrrideImplicitTimeout(driver, shortTimeout);
		List<WebElement> elements = getListWebElement(driver, locator);
		overrrideImplicitTimeout(driver, longTimeout);
		
		if (elements.size() == 0) {
			return true;
			// Có kích thước = 1 (Có trong DOM_
			// Ko đc hiển thị
		} else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isElementUndisplayed(WebDriver driver, String locatorType, String... dynamicValues) {
		overrrideImplicitTimeout(driver, shortTimeout);
		List<WebElement> elements = getListWebElement(driver, getDynamicXpath(locatorType, dynamicValues));
		overrrideImplicitTimeout(driver, longTimeout);

		if (elements.size() == 0) {
			return true;
			// Có kích thước = 1 (Có trong DOM_
			// Ko đc hiển thị
		} else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

	public void overrrideImplicitTimeout(WebDriver driver, long timeOut) {
		driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
	}

	public boolean isElementEnable(WebDriver driver, String locatorType) {
		return getWebElement(driver, locatorType).isEnabled();
	}

	public boolean isElementSelected(WebDriver driver, String locatorType) {
		return getWebElement(driver, locatorType).isSelected();
	}

	public void switchToFrameIframe(WebDriver driver, String locatorType) {
		driver.switchTo().frame(getWebElement(driver, locatorType));
	}

	public void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	public void hoverMouseToElement(WebDriver driver, String locatorType) {
		Actions action = new Actions(driver);
		action.moveToElement(getWebElement(driver, locatorType)).perform();
	}

	public void pressKeyToElement(WebDriver driver, String locatorType, Keys key) {
		Actions action = new Actions(driver);
		action.sendKeys(getWebElement(driver, locatorType), key).perform();
	}

	public void pressKeyToElement(WebDriver driver, String locatorType, Keys key, String... dynamicValues) {
		Actions action = new Actions(driver);
		action.sendKeys(getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)), key).perform();
	}

	public void scrollToBottomPage(WebDriver driver) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void highlightElement(WebDriver driver, String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		WebElement element = getWebElement(driver, locatorType);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
	}

	public void clickToElementByJS(WebDriver driver, String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", getWebElement(driver, locatorType));
	}

	public void scrollToElement(WebDriver driver, String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, locatorType));
	}

	public void removeAttributeInDOM(WebDriver driver, String locatorType, String attributeRemove) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getWebElement(driver, locatorType));
	}

	public boolean areJQueryAndJSLoadedSuccess(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					return ((Long) jsExecutor.executeScript("return jQuery.active") == 0);
				} catch (Exception e) {
					return true;
				}
			}
		};

		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
			}
		};

		return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
	}

	public String getElementValidationMessage(WebDriver driver, String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getWebElement(driver, locatorType));
	}

	public boolean isImageLoaded(WebDriver driver, String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", getWebElement(driver, locatorType));
		return status;
	}

	public boolean isImageLoaded(WebDriver driver, String locatorType, String... dynamicValues) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)));
		return status;
	}

	public void uploadMultipleFiles(WebDriver driver, String... fileNames) {
		// Dường dẫn của thư mục uploadFile
		String filePath = GlobalConstants.UPALOAD_FILE;

		// Đường dẫn của tất cả các file
		// 1 file: Java.jpeg
		// Nhiều file: String[] fileNames = {"CSharp.jpeg", "Python.jpeg"};
		String fullFileName = "";
		for (String file : fileNames) {
			fullFileName = fullFileName + filePath + file + "\n";
		}
		fullFileName = fullFileName.trim();
		getWebElement(driver, BasePageJQueryUI.UPLOAD_FILE).sendKeys(fullFileName);
	}

	public void sleepInSecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void waitForElementVisible(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locatorType)));
	}

	public void waitForElementVisible(WebDriver driver, String locatorType, String... dynamicValues) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(getDynamicXpath(locatorType, dynamicValues))));
	}

	public void waitForAllElementVisible(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(locatorType)));
	}

	public void waitForAllElementVisible(WebDriver driver, String locatorType, String... dynamicValues) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(getDynamicXpath(locatorType, dynamicValues))));
	}

	public void waitForElementInvisible(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locatorType)));
	}

	public void waitForElementInvisible(WebDriver driver, String locatorType, String... dynamicValues) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(getDynamicXpath(locatorType, dynamicValues))));
	}

	/*
	 * wait for element undisplayed in DOM and override implicit timeout
	 */
	public void waitForElementUndisplayed(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, shortTimeout);
		overrrideImplicitTimeout(driver, shortTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locatorType)));
		overrrideImplicitTimeout(driver, longTimeout);
	}

	public void waitForElementUndisplayed(WebDriver driver, String locatorType, String... dynamicValues) {
		WebDriverWait explicitWait = new WebDriverWait(driver, shortTimeout);
		overrrideImplicitTimeout(driver, shortTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(getDynamicXpath(locatorType, dynamicValues))));
		overrrideImplicitTimeout(driver, longTimeout);
	}

	public void waitForAllElementInvisible(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getListWebElement(driver, locatorType)));
	}

	public void waitForAllElementInvisible(WebDriver driver, String locatorType, String... dynamicValues) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getListWebElement(driver, getDynamicXpath(locatorType, dynamicValues))));
	}

	public void waitForElementClickable(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocator(locatorType)));
	}

	public void waitForElementClickable(WebDriver driver, String locatorType, String... dynamicValues) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocator(getDynamicXpath(locatorType, dynamicValues))));
	}

	public UserAddressPageObject openAddressPage(WebDriver driver) {
		waitForElementClickable(driver, BasePageUI.ADDRESS_LINK);
		clickToElement(driver, BasePageUI.ADDRESS_LINK);
		return commons.PageGeneratorManager.getUserAddressPage(driver);
	}

	public UserMyProductReviewPageObject openMyProductReviewPage(WebDriver driver) {
		waitForElementVisible(driver, BasePageUI.MY_PRODUCT_REVIEW_LINK);
		clickToElement(driver, BasePageUI.MY_PRODUCT_REVIEW_LINK);
		return commons.PageGeneratorManager.getUserMyProductReviewPage(driver);
	}

	public UserRewardPointPageObject openRewardPointPage(WebDriver driver) {
		waitForElementVisible(driver, BasePageUI.MY_PRODUCT_REVIEW_LINK);
		clickToElement(driver, BasePageUI.MY_PRODUCT_REVIEW_LINK);
		return commons.PageGeneratorManager.getUserRewardPointPage(driver);
	}

	public UserHomePageObject clickToLogoutLinkAtUserPage(WebDriver driver) {
		waitForElementVisible(driver, BasePageUI.LOGOUT_LINK_AT_USER);
		clickToElement(driver, BasePageUI.LOGOUT_LINK_AT_USER);
		return commons.PageGeneratorManager.getUserHomePage(driver);
	}

	// Dynamic Locator: page ít
	public BasePage openPagesAtMyAccountByName(WebDriver driver, String pageName) {
		waitForElementClickable(driver, BasePageUI.DYNAMIC_AT_MY_ACCOUNT_PAGE_AREA, pageName);
		clickToElement(driver, BasePageUI.DYNAMIC_AT_MY_ACCOUNT_PAGE_AREA, pageName);
		switch (pageName) {
		case "Addresses":
			return commons.PageGeneratorManager.getUserAddressPage(driver);
		case "My product reviews":
			return commons.PageGeneratorManager.getUserMyProductReviewPage(driver);
		case "Reward points":
			return commons.PageGeneratorManager.getUserRewardPointPage(driver);
		case "Customer info":
			return commons.PageGeneratorManager.getUserCustomerInforPage(driver);
		default:
			throw new RuntimeException("Invalid page name at My Account area.");
		}
	}

	// Dynamic locator: page nhiều
	public void openPagesAtMyAccountByPageName(WebDriver driver, String pageName) {
		waitForElementClickable(driver, BasePageUI.DYNAMIC_AT_MY_ACCOUNT_PAGE_AREA, pageName);
		clickToElement(driver, BasePageUI.DYNAMIC_AT_MY_ACCOUNT_PAGE_AREA, pageName);
	}
	
	/** 
	 * Enter to dynamic locator by ID
	 * @param driver
	 * @param textboxID
	 * @param value
	 */
	public void inputToTextboxByID(WebDriver driver, String textboxID, String value) {
		waitForElementVisible(driver, BasePageUI.DYNAMIC_TEXTBOX_BY_ID, textboxID);
		senkeyToElement(driver, BasePageUI.DYNAMIC_TEXTBOX_BY_ID, value, textboxID);
		
	}
	
	/** 
	 * Click to dynamic Button by Text
	 * @param driver
	 * @param buttonText
	 */
	public void clickToButtonByText(WebDriver driver, String buttonText) {
		waitForElementVisible(driver, BasePageUI.DYNAMIC_BUTTON_BY_TEXT, buttonText);
		clickToElement(driver, BasePageUI.DYNAMIC_BUTTON_BY_TEXT, buttonText);
		
	}
	
	/**
	 * Select item in Dropdown by Name attribute
	 * @param driver
	 * @param dropdownAttributeName
	 * @param itemvalue
	 */
	public void selectToDropdownByName(WebDriver driver, String dropdownAttributeName, String itemvalue) {
		waitForElementClickable(driver, BasePageUI.DYNAMIC_DROPDOWN_BY_NAME, dropdownAttributeName);
		selectItemInDefaultDropdow(driver, BasePageUI.DYNAMIC_DROPDOWN_BY_NAME, itemvalue, dropdownAttributeName);
		
	}
	
	/**
	 * Click to dynamic Radio by Name
	 * @param driver
	 * @param radioButtonLabelName
	 */
	public void clickToRadioButtonByLabel(WebDriver driver, String radioButtonLabelName) {
		waitForElementClickable(driver, BasePageUI.DYNAMIC_RADIO_BUTTON_BY_LABEL, radioButtonLabelName);
		checkToDefaultCheckboxOrRadio(driver, BasePageUI.DYNAMIC_RADIO_BUTTON_BY_LABEL, radioButtonLabelName);
		
	}
	
	/**
	 * Click to dynamic Checkbox by Name
	 * @param driver
	 * @param checkboxButtonLabelName
	 */
	public void clickToCheckboxByLabel(WebDriver driver, String checkboxButtonLabelName) {
		waitForElementClickable(driver, BasePageUI.DYNAMIC_CHECKBOX_BUTTON_BY_LABEL, checkboxButtonLabelName);
		checkToDefaultCheckboxOrRadio(driver, BasePageUI.DYNAMIC_CHECKBOX_BUTTON_BY_LABEL, checkboxButtonLabelName);
		
	}
	
	/**
	 * get value in textbox ny TextboxID
	 * @param driver
	 * @param textboxID
	 * @return
	 */
	public String getTextboxValueByID(WebDriver driver, String textboxID) {
		waitForAllElementVisible(driver, BasePageUI.DYNAMIC_TEXTBOX_BY_ID, textboxID);
		return getElementAttibute(driver, BasePageUI.DYNAMIC_TEXTBOX_BY_ID, "value", textboxID);
	}

	public AdminLoginPageObject clickToLogoutLinkAtAdminPage(WebDriver driver) {
		waitForElementVisible(driver, BasePageUI.LOGOUT_LINK_AT_ADMIN);
		clickToElement(driver, BasePageUI.LOGOUT_LINK_AT_ADMIN);
		return commons.PageGeneratorManager.getAdminLoginPage(driver);
	}
	
	
	//Bank Guru
	/**
	 * open page bank guru at home page by Name
	 * @param driver
	 * @param pageName
	 */
	public void openPagesAtHomePageBankGuruByName(WebDriver driver, String pageName) {
		waitForElementClickable(driver, BasePageUIBankGuru.DYNAMIC_AT_HOME_PAGE, pageName);
		clickToElement(driver, BasePageUIBankGuru.DYNAMIC_AT_HOME_PAGE, pageName);
	}
	
	/**
	 * input to textbox bank guru by Name
	 * @param driver
	 * @param textboxName
	 * @param value
	 */
	public void inputToTextboxBankGuruByName(WebDriver driver, String textboxName, String value) {
		waitForElementVisible(driver, BasePageUIBankGuru.DYNAMIC_TEXTBOX_BY_NAME, textboxName);
		senkeyToElement(driver, BasePageUIBankGuru.DYNAMIC_TEXTBOX_BY_NAME, value, textboxName);
	}
	
	/**
	 * click to radio button bank guru by Value
	 * @param driver
	 * @param radioButtonValue
	 */
	public void clickToRadioButtonBankGuruByValue(WebDriver driver, String radioButtonValue) {
		waitForElementVisible(driver, BasePageUIBankGuru.DYNAMIC_RADIOBUTTON_BY_VALUE, radioButtonValue);
		checkToDefaultCheckboxOrRadio(driver, BasePageUIBankGuru.DYNAMIC_RADIOBUTTON_BY_VALUE, radioButtonValue);
		
	}
	
	/**
	 * get textbox value bank guru by Text
	 * @param driver
	 * @param textbox
	 * @return
	 */
	public String getTextboxValueBankGuruByText(WebDriver driver, String textbox) {
		waitForElementVisible(driver, BasePageUIBankGuru.DYNAMIC_TEXTBOX_BY_TEXTBOX, textbox);
		return getElementText(driver, BasePageUIBankGuru.DYNAMIC_TEXTBOX_BY_TEXTBOX, textbox);
	}
	
	/**
	 * click to button bank guru by Value
	 * @param driver
	 * @return
	 */
	public ManagerPageObject clickToButtonBankGuruByValue(WebDriver driver, String valueButton) {
		waitForElementClickable(driver, BasePageUIBankGuru.DYNAMIC_SUBMIT_BUTTON_BY_VALUE, valueButton);
		clickToElement(driver, BasePageUIBankGuru.DYNAMIC_SUBMIT_BUTTON_BY_VALUE, valueButton);
		return PageGeneratorManager.getManagerPage(driver);
	}
	
	/**
	 * edit textbox bank guru by Text
	 * @param driver
	 * @param textboxName
	 * @param valueEdit
	 */
	public void inputToEditTextboxbankGuruByText(WebDriver driver, String textboxName, String valueEdit) {
		waitForElementVisible(driver, BasePageUIBankGuru.DYNAMIC_TEXTBOX_BY_TEXTBOX, textboxName);
		senkeyToElement(driver, BasePageUIBankGuru.DYNAMIC_TEXTBOX_BY_TEXTBOX, valueEdit, textboxName);
		
	}
	
	public pageObjects.wordpress.UserHomePO openEndUserSite(WebDriver driver, String endUserUrl) {
		openPageUrl(driver, endUserUrl);
		return pageObjects.wordpress.PageGeneratorManager.getUserHomePage(driver);
		
	}
	
	public AdminDashBoardPO openAdminSite(WebDriver driver, String adminUrl) {
		openPageUrl(driver, adminUrl);
		return pageObjects.wordpress.PageGeneratorManager.getAdminDashBoardPage(driver);
	}
	
	// Equateur
	public CreateReferencePageObject clickToStockLink(WebDriver driver) {
		waitForElementClickable(driver, BaseUI.GESTION_DE_STOCK_DRODOWN);
		clickToElement(driver, BaseUI.GESTION_DE_STOCK_DRODOWN);
		waitForElementClickable(driver, BaseUI.STOCK_LINK);
		clickToElement(driver, BaseUI.STOCK_LINK);
		return PageGenegatorManager.getCreateReferencePage(driver);
		
	}


	private long longTimeout = GlobalConstants.LONG_TIMEOUT;
	private long shortTimeout = GlobalConstants.SHORT_TIMEOUT;
}
