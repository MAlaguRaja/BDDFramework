package CommonLibrary;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import CommonRepository.CommonOR;
import junit.framework.Assert;

public class CommonLibrary extends CommonOR {
	public static WebDriver driver;
	public static String product_price;
	public static String expected_product_name;
	public static Double expected_subtotal;
	public static int selectquanity = 0;
	public static String zipcode = "94545";

	public static void launch_application1() {

		String path = System.getProperty("user.dir");
		System.out.println(path);
		System.setProperty("webdriver.chrome.driver", path + "\\resource\\chromedriver.exe");

		
		// ChromeOptions options = new ChromeOptions();
		// options.addArguments("--start-maximized");
		driver = new ChromeDriver();

		// Open Amazon
		
		
		driver.get("http://www.amazon.com");
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	public static void homepage() {
		String title = driver.getTitle();
		System.out.println(title);
		String expected = "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";
		Assert.assertEquals(expected, title);

	}

	public static void bestsellerlink() throws InterruptedException {

		Thread.sleep(5000);

		if (CommonLibrary.driver.findElement(By.xpath(CommonOR.changeaddress)).isDisplayed()) {

			CommonLibrary.driver.findElement(By.xpath(CommonOR.changeaddress)).click();

			CommonLibrary.driver.findElement(By.xpath(CommonOR.changeaddress));
			CommonLibrary.driver.findElement(By.xpath(CommonOR.updatezipcode)).clear();
			CommonLibrary.driver.findElement(By.xpath(CommonOR.updatezipcode)).sendKeys(zipcode);
			CommonLibrary.driver.findElement(By.xpath(CommonOR.applybtn)).click();

			CommonLibrary.driver.findElement(By.xpath(CommonOR.continuebtn)).click();
			Thread.sleep(2000);
		} else {

			System.out.println("Change Address:Change Address icon is not displayed");

		}
		Thread.sleep(20000);

		try {

			if (CommonLibrary.driver.findElement(By.xpath(CommonOR.bestseller_one)).isDisplayed()) {
				CommonLibrary.driver.findElement(By.xpath(CommonOR.bestseller_one)).click();
			}
		} catch (NoSuchElementException e) {

		}

	}

	public static void morebestseller() {

		CommonLibrary.driver.findElement(By.xpath(morebestseller)).click();

	}

	public static void productlistpage() {

		try {

			product_price = CommonLibrary.driver.findElement(By.xpath(CommonOR.product_price_fifth)).getText();

			System.out.println("Selected product Price is:" + product_price);

			List<WebElement> products = CommonLibrary.driver.findElements(By.xpath(CommonOR.productlist));
			int all_Product = products.size();
			System.out.println("All products in products list page:" + all_Product);

			int selectproduct = 4;

			products.get(selectproduct).click();

		} catch (Exception exe) {
			exe.printStackTrace();

		}
	}

	public static void click(String clickproduct) throws InterruptedException {
		if (clickproduct.equalsIgnoreCase("Add to cart")) {
			CommonLibrary.driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
			Thread.sleep(2000);

			CommonLibrary.driver.findElement(By.xpath(CommonOR.addtocart_btn)).click();

			try {
				if (CommonLibrary.driver.findElement(By.xpath(CommonOR.nothanks_btn)).isDisplayed()) {
					CommonLibrary.driver.findElement(By.xpath(CommonOR.nothanks_btn)).click();
				}

				if (CommonLibrary.driver.findElement(By.xpath(CommonOR.viewcart_btn)).isDisplayed()) {
					CommonLibrary.driver.findElement(By.xpath(CommonOR.viewcart_btn)).click();
				}

			} catch (NoSuchElementException e) {
			  System.out.println("Expected element is not visible on screen");
			}

			if (CommonLibrary.driver.findElement(By.xpath(CommonOR.added_to_cart_one)).isDisplayed()
					|| CommonLibrary.driver.findElement(By.xpath(CommonOR.added_to_cart_two)).isDisplayed()) {

				if (CommonLibrary.driver.findElement(By.xpath(CommonOR.cart_btn_one)).isDisplayed()) {
					CommonLibrary.driver.findElement(By.xpath(CommonOR.cart_btn_one)).click();
				}

				else if (CommonLibrary.driver.findElement(By.xpath(CommonOR.cart_btn_two)) != null) {
					CommonLibrary.driver.findElement(By.xpath(CommonOR.cart_btn_two)).click();
				}

				else if (CommonLibrary.driver.findElement(By.xpath(CommonOR.cart_btn_three)) != null) {
					CommonLibrary.driver.findElement(By.xpath(CommonOR.cart_btn_three)).click();
				}
			}
		}

	}

	public static void validate_cart_page() {

		String[] op = product_price.split("[$]");
		double select_product_amount = Double.parseDouble(op[1]);
		System.out.println("Selected one product Price is:" + select_product_amount);
		expected_subtotal = select_product_amount * selectquanity;
		System.out.println("Expected subtotal amount is:" + expected_subtotal);
		String subtotoal_price = driver.findElement(By.xpath("//span[@id = 'sc-subtotal-amount-buybox']")).getText();
		String[] sp = subtotoal_price.split("[$]");
		double subtotal = Double.parseDouble(sp[1]);
		System.out.println("Actual subtotal amount is:" + subtotal);
		Assert.assertEquals(expected_subtotal, subtotal);
		String actual_product_name = driver
				.findElement(By.xpath("//span[@class='a-size-medium sc-product-title a-text-bold']")).getText();
		System.out.println("Actual Product Name is:" + actual_product_name);
		System.out.println("Expected product name is:" + expected_product_name);
		Assert.assertEquals(expected_product_name, actual_product_name);

	}
	

	public static void selectproductquantity(int quantity) {
		selectquanity = quantity;
		try {

			Thread.sleep(5000);

			Select se = new Select(driver.findElement(By.xpath("//select[@id='quantity']")));

			List<WebElement> l = se.getOptions();
			int avl_qty = l.size();

			System.out.println("All QUANTITY IS:" + avl_qty);
			System.out.println("Selected Quantity:" + selectquanity);
			if (avl_qty >= selectquanity) {
				Select selectByValue = new Select(driver.findElement(By.xpath("//select[@id='quantity']")));
				Thread.sleep(5000);
				selectByValue.selectByIndex(7);
			} else {
				System.out.println("Available quqntity is mismatched with expected quantity");
			}

			WebElement product_title = driver.findElement(By.xpath("//span[@id='productTitle']"));
			expected_product_name = product_title.getText();

			System.out.println("Selected product name is:" + expected_product_name);
		} catch (Exception exe) {
			exe.printStackTrace();

		}

	}

	public static void close_browser_action() {

		try {

			Thread.sleep(5000);

			CommonLibrary.driver.quit();
		} catch (Exception exe) {
			exe.printStackTrace();

		}

	}

}
