package commons;

import java.io.File;

public class GlobalConstants {

	public static final String PORTAL_DEV_URL = "https://demo.nopcommerce.com";
	public static final String ADMIN_DEV_URL = "http://live.techpanda.org/index.php/backendlogin/customer/";
	public static final String PORTAL_TESTING_URL = "https://demo.nopcommerce.com";
	public static final String ADMIN_TESTING_URL = "http://live.techpanda.org/index.php/backendlogin/customer/";
	public static final String PROJECT_PATH = System.getProperty("user.dir");
	public static final String JAVA_VERSION = System.getProperty("java.version");
	public static final String OS_NAME = System.getProperty("os.namez");
	public static final String UPALOAD_FILE = PROJECT_PATH + File.separator + "uploadFiles" + File.separator;
	public static final String DOWNLOAD_FILE = PROJECT_PATH + File.separator + "downloadFiles";
	public static final String BROWSER_LOG = PROJECT_PATH + File.separator + "browserLogs";
	public static final String DRAG_DROP_HTML5 = PROJECT_PATH + File.separator + "dragDropHTML5";
	public static final String REPORTNG_SCREENSHOT = PROJECT_PATH + File.separator + "ReportNGImage";
	public static final String EXTENT_PATH = PROJECT_PATH + "/ExtentReportV2";
	public static final String DB_DEV_URL = "32.18.252.285:9860";
	public static final String DB_DEV_USER = "automationfc";
	public static final String DB_DEV_PASS = "P@ssw0rld1";
	public static final long SHORT_TIMEOUT = 5;
	public static final long LONG_TIMEOUT = 10;
	public static final long RETRY_TEST_FAIL = 3;

}