package pageObjects.saucelab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.saucelab.ProductPageUI;

public class ProductPO extends BasePage{
	
	public ProductPO (WebDriver driver) {
		this.driver = driver;
	}
	
	private WebDriver driver;

	public void selectItemInProductSortDropdown(String textItem) {
		waitForElementVisible(driver, ProductPageUI.PRODUCT_CONTAINER_DROPSOWN);
		selectItemInDefaultDropdow(driver, ProductPageUI.PRODUCT_CONTAINER_DROPSOWN, textItem);
		
	}

	public boolean isProductNameSortByAscending() {
		// Khai báo ra 1 Arraylist đển chứa các product name trên UI
		ArrayList<String> productUIList = new ArrayList<String>();
		
		// Lấy ra hết tất cả các text product name
		List<WebElement> productNameText = getListWebElement(driver, ProductPageUI.PRODUCT_NAME);
		
		// Dùng vòng lặp để getText và add vào ArrayList trên
		for (WebElement productName : productNameText) {
			productUIList.add(productName.getText());
			System.out.println("Product name trên UI: " + productName.getText());
		}
		
		// Tạo ra 1 ArrayList mới để sort dữ liệu trong ArrayList cũ xem đúng hay ko
		ArrayList<String> productSortList = new ArrayList<String>();
		for (String product : productUIList) {
			productSortList.add(product);
		}
		
		// Sort producSortList
		Collections.sort(productSortList);
		
		for (String productName : productSortList) {
			System.out.println("Product name sau khi sort ASC: " + productName);
		}
		
		// So sánh 2 List đã bằng nhau chưa
    	return productSortList.equals(productUIList);
	}

	public boolean isProductNameSortByDecending() {
		// Khai báo ra 1 Arraylist đển chứa các product name trên UI
				ArrayList<String> productUIList = new ArrayList<String>();
				
				// Lấy ra hết tất cả các text product name
				List<WebElement> productNameText = getListWebElement(driver, ProductPageUI.PRODUCT_NAME);
				
				// Dùng vòng lặp để getText và add vào ArrayList trên
				for (WebElement productName : productNameText) {
					productUIList.add(productName.getText());
					System.out.println("Product name trên UI: " + productName.getText());

				}
				
				// Tạo ra 1 ArrayList mới để sort dữ liệu trong ArrayList cũ xem đúng hay ko
				ArrayList<String> productSortList = new ArrayList<String>();
				for (String product : productUIList) {
					productSortList.add(product);
				}
				
				// Sort producSortList
				Collections.sort(productSortList);
				for (String productName : productSortList) {
					System.out.println("Product name sau khi sort ASC: " + productName);
				}
				
				Collections.reverse(productSortList);
				for (String productName : productSortList) {
					System.out.println("Product name sau khi sort DESC: " + productName);
				}
				
				// So sánh 2 List đã bằng nhau chưa
		    	return productSortList.equals(productUIList);
	}

	public boolean isProductPriceSortByAscending() {
		// Khai báo ra 1 Arraylist đển chứa các product name trên UI
				ArrayList<Float> productUIList = new ArrayList<Float>();
				
				// Lấy ra hết tất cả các text product name
				List<WebElement> productPriceText = getListWebElement(driver, ProductPageUI.PRODUCT_PRICE);
				
				// Dùng vòng lặp để getText và add vào ArrayList trên
				for (WebElement productPrice : productPriceText) {
					productUIList.add(Float.parseFloat(productPrice.getText().replace("$", "")));
					System.out.println("Product price trên UI: " + productPrice.getText());
				}
				
				// Tạo ra 1 ArrayList mới để sort dữ liệu trong ArrayList cũ xem đúng hay ko
				ArrayList<Float> productSortList = new ArrayList<Float>();
				for (Float product : productUIList) {
					productSortList.add(product);
				}
				
				// Sort producSortList
				Collections.sort(productSortList);
				
				for (Float productName : productSortList) {
					System.out.println("Product price sau khi sort ASC: " + productName);
				}
				
				// So sánh 2 List đã bằng nhau chưa
		    	return productSortList.equals(productUIList);
			}

	public boolean isProductPriceSortByDecending() {
		// Khai báo ra 1 Arraylist đển chứa các product name trên UI
		ArrayList<Float> productUIList = new ArrayList<Float>();
		
		// Lấy ra hết tất cả các text product name
		List<WebElement> productPriceText = getListWebElement(driver, ProductPageUI.PRODUCT_PRICE);
		
		// Dùng vòng lặp để getText và add vào ArrayList trên
		for (WebElement productPrice : productPriceText) {
			productUIList.add(Float.parseFloat(productPrice.getText().replace("$", "")));
			System.out.println("Product price trên UI: " + productPrice.getText());
		}
		
		// Tạo ra 1 ArrayList mới để sort dữ liệu trong ArrayList cũ xem đúng hay ko
		ArrayList<Float> productSortList = new ArrayList<Float>();
		for (Float product : productUIList) {
			productSortList.add(product);
		}
		
		// Sort producSortList
		Collections.sort(productSortList);
		
		for (Float productName : productSortList) {
			System.out.println("Product price sau khi sort ASC: " + productName);
		}
		
		Collections.reverse(productSortList);
		for (Float productName : productSortList) {
			System.out.println("Product price sau khi sort DESC: " + productName);
		}
		
		// So sánh 2 List đã bằng nhau chưa
    	return productSortList.equals(productUIList);
	}

}
