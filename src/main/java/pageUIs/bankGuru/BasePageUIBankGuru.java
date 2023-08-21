package pageUIs.bankGuru;

public class BasePageUIBankGuru {
	
	public static final String DYNAMIC_AT_HOME_PAGE = "xpath=//ul[@class='menusubnav']/li/a[text()='%s']";
	public static final String DYNAMIC_TEXTBOX_BY_NAME = "xpath=//input[@name='%s']";
	public static final String DYNAMIC_RADIOBUTTON_BY_VALUE = "xpath=//input[@value='%s']";
	public static final String DYNAMIC_TEXTBOX_BY_TEXTBOX = "xpath=//tbody/tr/td[text()='%s']/following-sibling::td";
	public static final String DYNAMIC_SUBMIT_BUTTON_BY_VALUE = "xpath=//input[@value='%s']";

}
