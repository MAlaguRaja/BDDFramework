package stepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import CommonLibrary.CommonLibrary;
import CommonRepository.CommonOR;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import junit.framework.Assert;
import java.util.List;

public class LaunchStepDefinition extends CommonLibrary {

	public static WebDriver driver;

	@Given("^User is on home screen$")
	public void launch_application() {

		CommonLibrary.launch_application1();

	}

	@Then("^Verify home page is displayed on the screen$")
	public void home_page() {
		CommonLibrary.homepage();
	}

	@Then("^User tap on \\\"(.*)\\\" option in home screen$")
	public void select_catagory(String product) throws InterruptedException {

		CommonLibrary.bestsellerlink();

	}

	@And("^User tap on See more Best Sellers in Camera & Photo in best sellers page$")
	public void more_best_seller_products() {

		CommonLibrary.morebestseller();
		// WebElement element = driver.findElement(By.name(best.toString()));
		// element.click();
	}

	@And("^User select fifth product in product list page$")
	public void product_list_page() {

		CommonLibrary.productlistpage();
	}

	@And("^User select \\\"(.*)\\\" product quantity in product details page$")
	public void select_product_quantity(int selectquantity) {

		CommonLibrary.selectproductquantity(selectquantity);

	}

	@And("^User tap on \\\"(.*)\\\" to add the product in cart$")
	public void add_to_cart(String products) throws InterruptedException {

		switch (products) {
		case "Add to cart":
			CommonLibrary.click("Add to cart");
			break;
		}

	}

	@Then("^Verify product name and total amount is displayed correctly on cart screen$")
	public void cart_page() {

		CommonLibrary.validate_cart_page();

	}

	@Then("^User close the browser$")
	public void close_browser() {

		CommonLibrary.close_browser_action();

	}

}
