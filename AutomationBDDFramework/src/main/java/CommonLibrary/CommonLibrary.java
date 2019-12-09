package CommonLibrary;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
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

	public static void launch_application1() {

		String path = System.getProperty("user.dir");
		System.out.println(path);
		System.setProperty("webdriver.chrome.driver", path + "\\resource\\chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		driver = new ChromeDriver(options);

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
			CommonLibrary.driver.findElement(By.xpath(CommonOR.updatezipcode)).sendKeys("72201");
			CommonLibrary.driver.findElement(By.xpath(CommonOR.applybtn)).click();
			CommonLibrary.driver.findElement(By.xpath(CommonOR.continuebtn)).click();
			Thread.sleep(2000);
		} else {

			System.out.println("Change Address:Change Address icon is not displayed");

		}
		Thread.sleep(10000);

		CommonLibrary.driver.findElement(By.xpath(CommonOR.bestseller)).click();

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

			if (all_Product > selectproduct) {
				for (int i = 1; i < all_Product; i++) {
					System.out.println("Products:" + products.get(i));
					products.get(selectproduct).click();
				}

			}
		} catch (Exception exe) {
			exe.printStackTrace();

		}
	}

	public static void click(String clickproduct) throws InterruptedException {
		if (clickproduct.equalsIgnoreCase("Add to cart")) {
			CommonLibrary.driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
			Thread.sleep(2000);

			CommonLibrary.driver.findElement(By.xpath(CommonOR.addtocart_btn)).click();

			if (CommonLibrary.driver.findElement(By.xpath(CommonOR.nothanks_btn)) != null) {
				CommonLibrary.driver.findElement(By.xpath(CommonOR.nothanks_btn)).click();
			}

			if (CommonLibrary.driver.findElement(By.xpath(CommonOR.viewcart_btn)) != null) {
				CommonLibrary.driver.findElement(By.xpath(CommonOR.viewcart_btn)).click();
			}
		}

	}

	public static void validate_cart_page() {

		String[] op = product_price.split("[$]");
		double select_product_amount = Double.parseDouble(op[1]);
		System.out.println("Selected one product Price is:" + select_product_amount);
		expected_subtotal = select_product_amount * 8;
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

	public static void selectproductquantity(int selectquantity) {

		try {

			Thread.sleep(5000);

			Select se = new Select(driver.findElement(By.xpath("//select[@id='quantity']")));

			List<WebElement> l = se.getOptions();
			int avl_qty = l.size();

			System.out.println("All QUANTITY IS:" + avl_qty);
			System.out.println("Selected Quantity:" + selectquantity);
			if (avl_qty >= selectquantity) {
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

			CommonLibrary.driver.close();
		} catch (Exception exe) {
			exe.printStackTrace();

		}

	}

}
