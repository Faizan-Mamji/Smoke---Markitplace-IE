package POMMarkITplacePages;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import DriverMainPackage.MainDriverClass;

public class POMSearchListing {

	public static WebDriver driver;
	// Logger logg=Logger.getLogger(POMSearchListing.class);
	static final Logger logg = LogManager.getLogger(POMSearchListing.class);

	// Variable Declaration
	String SearchPageTitle = "Printers - MarkITplace";
	String FavoritesPageTitle = "Favorites - MarkITplace";
	String favoritestext = "Added to Favorites";
	String CartPagetext;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Constructor Declaration

	public POMSearchListing(WebDriver driver) {
		POMSearchListing.driver = driver;
	}

	// POM for search listing page and favorites page for condition check
	By SearchBox = By.id("x_main-search");
	By AddToCartBtn = By.xpath("(//div[@class='cart-container clearfix']//a)[1]");
	By AddToFavoriteslinkbtn = By.xpath("(//div[@class='compare-container clearfix']/a)[1]");
	By FavoritesCheckBoxSelectAll = By.xpath("//div[@class='left']//span[@class='control__indicator']");
	By FavoritesDeleteBtn = By.xpath("(//div[@class='left']//a)[2]");
	By FavoritesModalDelBtn = By.xpath("(//div[@class='btn-container clearfix']/button)[1]");
	By AddedToFavoriteslinkbtn = By.xpath("(//a[@class='linkdisable tt-wrapper'])[1]");
	By FavoritesDelConditionCheck = By.xpath("//a[contains(text(),'Delete')]");
	By AddToCartModalClose = By.xpath("(//button[@class='mfp-close'])[2]");
	By FavoritesLinkText = By.xpath("(//a[contains(text(),'Favorites')])[2]");
	By CartIcon = By.xpath("//div[@class='shopping-cart']//a");
	By CartRemoveAll = By.xpath("(//div[@class='cart-footer']//a)[1]");
	By CartRemoveModal = By.xpath("//button[@class='btn btn-primary remove-all-item']");
	By CheckCartText = By.xpath("//div[@class='cart-header lower-shadow-medium-down fivelayer  ']//h2");

	public void OpenSearchPage_AddToCart_And_Verifyproducts_On_FavoritesPage() throws InterruptedException {
		SoftAssert sf =new SoftAssert();
		MainDriverClass objDriver =new MainDriverClass();
		String FallBackUrl = objDriver.getConfigValue("MainUrl");
		try {
			logg.info("SearchListing TestCase Starts");
			driver.findElement(SearchBox).sendKeys("printers");
			TimeUnit.MILLISECONDS.sleep(2000);
			logg.info("Printers text enters in textbox");
			driver.findElement(SearchBox).sendKeys(Keys.ENTER);
			TimeUnit.MILLISECONDS.sleep(18000);
			logg.info("Printers Search ListingPage Opens");
			sf.assertEquals(SearchPageTitle, driver.getTitle());
			logg.info("Assertion Passed For SearchListing Page");
			String SearchlistingUrl = driver.getCurrentUrl();
			TimeUnit.MILLISECONDS.sleep(2000);
			String LinkCheck = driver.findElement(AddToFavoriteslinkbtn).getAttribute("class");
			TimeUnit.MILLISECONDS.sleep(2000);
			if (LinkCheck.equalsIgnoreCase("")) {
				logg.info("Add To Favorites Get class = null");

				// Here Navigate to cart page and to delete the all products from cart

				logg.info("Click on cart icon");
				//driver.findElement(CartIcon).click();
				driver.navigate().to(FallBackUrl+"shop/cart");
				TimeUnit.MILLISECONDS.sleep(10000);
				logg.info("Cart Page Opens successfully");
				CartPagetext = driver.findElement(CheckCartText).getText();

				// Check Condition on cart page if products exist or not

				if (CartPagetext.equalsIgnoreCase("Your cart is empty")) {
					logg.info("Get Cart Empty so navigate to search listing page");
					driver.navigate().to(SearchlistingUrl);
					TimeUnit.MILLISECONDS.sleep(18000);
					logg.info("Products Listing Page Opens");
					sf.assertEquals(SearchPageTitle, driver.getTitle());
					TimeUnit.MILLISECONDS.sleep(2000);
					logg.info("SearchListing assert Verified");
					logg.info("Click on Add To Cart Button");
					driver.findElement(AddToCartBtn).click();
					TimeUnit.MILLISECONDS.sleep(20000);
					logg.info("Product Added To Cart successfully");
					driver.findElement(AddToCartModalClose).click();
					TimeUnit.MILLISECONDS.sleep(5000);
					logg.info("Add To Cart Modal Closed");
					driver.findElement(AddToFavoriteslinkbtn).click();
					TimeUnit.MILLISECONDS.sleep(10000);
					logg.info("Product Added To Favorites");
					logg.info("*********************** SearchListing TestCase Passed ***********************");
				}

				else {
					logg.info("Products exist in cart so removing first");
					driver.findElement(CartRemoveAll).click();
					logg.info("Click on Remove All button and modal opens successfully");
					TimeUnit.MILLISECONDS.sleep(3000);
					driver.findElement(CartRemoveModal).click();
					TimeUnit.MILLISECONDS.sleep(20000);
					logg.info("Click on Yes Button in modal and all products deleted from cart");

					// Here Navigate to Search Listing page again

					logg.info("Now Navigate to Search listing from Cart Page");
					driver.navigate().to(SearchlistingUrl);
					TimeUnit.MILLISECONDS.sleep(18000);
					logg.info("Products Listing Page Opens");
					sf.assertEquals(SearchPageTitle, driver.getTitle());
					TimeUnit.MILLISECONDS.sleep(2000);
					logg.info("SearchListing assert Verified");
					logg.info("Click on Add To Cart Button");
					driver.findElement(AddToCartBtn).click();
					TimeUnit.MILLISECONDS.sleep(20000);
					logg.info("Product Added To Cart successfully");
					driver.findElement(AddToCartModalClose).click();
					TimeUnit.MILLISECONDS.sleep(5000);
					logg.info("Add To Cart Modal Closed");
					driver.findElement(AddToFavoriteslinkbtn).click();
					TimeUnit.MILLISECONDS.sleep(10000);
					logg.info("Product Added To Favorites");
					logg.info("*********************** SearchListing TestCase Passed ***********************");
				}
			}

			// Cart Conditions Ends Here

			// This else is of search listing added to favorites

			else {
				logg.info("Add To Favorites Get class = Disable");
				//driver.findElement(FavoritesLinkText).click();
				driver.navigate().to(FallBackUrl+"shop/favorites");
				TimeUnit.MILLISECONDS.sleep(18000);
				logg.info("Favorites Page Opens Successfully");
				sf.assertEquals(FavoritesPageTitle, driver.getTitle());
				logg.info("Favorites Page Validation Passed");
				driver.findElement(FavoritesCheckBoxSelectAll).click();
				TimeUnit.MILLISECONDS.sleep(2000);
				driver.findElement(FavoritesDeleteBtn).click();
				TimeUnit.MILLISECONDS.sleep(2000);
				logg.info("Delete popup opened");
				driver.findElement(FavoritesModalDelBtn).click();
				TimeUnit.MILLISECONDS.sleep(15000);
				logg.info("Products Deleted From Favorites");
				TimeUnit.MILLISECONDS.sleep(3000);

				// Here Navigate to cart page and to checking the products exist in cart or not

				logg.info("Click on cart icon");
				//driver.findElement(CartIcon).click();
				driver.navigate().to(FallBackUrl+"shop/cart");
				TimeUnit.MILLISECONDS.sleep(10000);
				logg.info("Cart Page Opens successfully");
				CartPagetext = driver.findElement(CheckCartText).getText();

				// Checking here whether products exist in cart or not

				if (CartPagetext.equalsIgnoreCase("Your cart is empty")) {
					logg.info("Now Navigate to Search listing from Cart Page as cart page is empty");
					driver.navigate().to(SearchlistingUrl);
					TimeUnit.MILLISECONDS.sleep(18000);
					logg.info("Products Listing Page Opens");
					sf.assertEquals(SearchPageTitle, driver.getTitle());
					TimeUnit.MILLISECONDS.sleep(2000);
					logg.info("SearchListing assert Verified");
					driver.findElement(AddToCartBtn).click();
					TimeUnit.MILLISECONDS.sleep(20000);
					logg.info("Product Added To Cart successfully");
					driver.findElement(AddToCartModalClose).click();
					TimeUnit.MILLISECONDS.sleep(2000);
					logg.info("Add To Cart Modal Close");
					driver.findElement(AddToFavoriteslinkbtn).click();
					TimeUnit.MILLISECONDS.sleep(10000);
					logg.info("Products Added To Favorites");
					logg.info("*********************** SearchListing TestCase Passed ***********************");
				}

				else {
					logg.info("As products exist in cart so deleting products from cart");
					driver.findElement(CartRemoveAll).click();
					logg.info("Click on Remove All button and modal opens successfully");
					TimeUnit.MILLISECONDS.sleep(3000);
					driver.findElement(CartRemoveModal).click();
					TimeUnit.MILLISECONDS.sleep(20000);
					logg.info("Click on Yes Button in modal and all products deleted from cart");

					// Navigate again to listing page for add to cart and add to favorite the
					// product

					logg.info("Now Navigate to Search listing from Cart Page");
					driver.navigate().to(SearchlistingUrl);
					TimeUnit.MILLISECONDS.sleep(18000);
					logg.info("Products Listing Page Opens");
					sf.assertEquals(SearchPageTitle, driver.getTitle());
					TimeUnit.MILLISECONDS.sleep(2000);
					logg.info("SearchListing assert Verified");
					driver.findElement(AddToCartBtn).click();
					TimeUnit.MILLISECONDS.sleep(20000);
					logg.info("Product Added To Cart successfully");
					driver.findElement(AddToCartModalClose).click();
					TimeUnit.MILLISECONDS.sleep(2000);
					logg.info("Add To Cart Modal Close");
					driver.findElement(AddToFavoriteslinkbtn).click();
					TimeUnit.MILLISECONDS.sleep(10000);
					logg.info("Products Added To Favorites");
					logg.info("*********************** SearchListing TestCase Passed ***********************");
				}
			}
		}

		catch (Exception ex) {
			logg.info(
					"POMSearchListing - Exception!!! - There is some issue on search listing page while loading, add to cart or add to favorite the product and can be found on page: POMSearchListing - "
							+ ex.getMessage());
			Assert.fail("Failed in class - POMSearchListing");
			
		}
	}
}
