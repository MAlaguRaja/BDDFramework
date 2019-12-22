package CommonRepository;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;

import com.gargoylesoftware.htmlunit.javascript.host.Element;

import CommonLibrary.CommonLibrary;
import stepDefinition.LaunchStepDefinition;

public class CommonOR {

	public static String bestseller = "//div[@id='nav-xshop']//a[2]";
	public static String bestseller_one = "//a[contains(text(),'Best Sellers')]";
	public static String productlist = "(//div[@id=\"zg-center-div\"]//img)";
	public static String changeaddress = "//span[@id='glow-ingress-line1']";
	public static String updatezipcode = "//div[@id='GLOWFeature_AddressList']//input[@id='GLUXZipUpdateInput']";
	public static String applybtn = "//input[@type='submit' and contains(@aria-labelledby,'Update')]";
	public static String donebtn = "//button[text()='Done']";
	public static String continuebtn = "(//input[@id='GLUXConfirmClose'])[2]";
	public static String morebestseller = "//a[contains(text(),'See more Best Sellers in Camera & Photo')]";
	public static String product_price_fifth = "(//div[@class='a-row'])[6]";
	public static String addtocart_btn = "//input[@id='add-to-cart-button']";
	public static String nothanks_btn = "//button[@id='attachSiNoCoverage-announce']";
	public static String viewcart_btn = "//input[@aria-labelledby='attach-sidesheet-view-cart-button-announce']";
	public static String availablequantity = "//div[contains(@class,'dropdown')]//ul[@role='listbox']//li";
	public static String cart_btn_one = "(//a[@role='button' and contains(text(),'Cart')])[1]";
	public static String cart_btn_two = "(//span[contains(@id,'view-cart')])[1]";
	public static String cart_btn_three = "//*[@id ='hlb-view-cart-announce']";

	public static String added_to_cart_one = "//h1[contains(text(),'Added to Cart')]";

	public static String added_to_cart_two = "//div[contains(@id,'attachDisplayAddBaseAlert')]";
	public static String subtotal_price_txt = "//span[@id = 'sc-subtotal-amount-buybox']";
	public static String product_name_txt = "//span[contains(@class,'a-size-medium sc-product-title')]";
	public static String product_quantity = "//select[@id='quantity']";
	public static String product_title_txt = "//span[@id='productTitle']";
}
