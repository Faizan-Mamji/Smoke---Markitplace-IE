package POMMarkITplacePages;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class POMFavoritesPage {

	public static WebDriver driver;
	// Logger logg=Logger.getLogger(POMFavoritesPage.class);
	static final Logger logg = LogManager.getLogger(POMFavoritesPage.class);
	String FavoritesPageTitle = "Favorites - MarkITplace";
	String ShopPageTitle = "Shop - MarkITplace";

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public POMFavoritesPage(WebDriver driver) {
		POMFavoritesPage.driver = driver;
	}

	// POM Favorites Page Declaration

	By SelectAllCheckbox = By.xpath("//div[@class='left']//span[@class='control__indicator']");
	By AddSelectedToCart = By.id("addAllToCart");
	By FavoritesModalClose = By.xpath("(//button[@title='Close (Esc)'])[5]");
	By FavoritesDeleteBtn = By.xpath("//div[@class='btn-col']/a[@class='btn']");
	By FavoritesModalDelBtn = By.xpath("(//div[@class='btn-container clearfix']/button)[1]");
	By FavoritesLinkText = By.linkText("Favorites");
	By ShopNavClick = By.xpath("(//div[@class='homepage-nav-item-container']//a)[1]");

	public void Favorites_Page_TestFunctionality() throws InterruptedException {
		// PropertyConfigurator.configure("log4j.properties");
		SoftAssert sf =new SoftAssert();
		try {
			logg.info("Favorites TestCase Starts Here");
			driver.findElement(FavoritesLinkText).click();
			TimeUnit.MILLISECONDS.sleep(15000);
			logg.info("Favorites page opens successfully");
			sf.assertEquals(FavoritesPageTitle, driver.getTitle());
			logg.info("Favorites assertion passed successfully");
			driver.findElement(SelectAllCheckbox).click();
			TimeUnit.MILLISECONDS.sleep(4000);
			logg.info("SelectAll checkbox select all favorites products on the page");
			driver.findElement(AddSelectedToCart).click();
			TimeUnit.MILLISECONDS.sleep(20000);
			logg.info("Products added to cart");
			driver.findElement(FavoritesModalClose).click();
			TimeUnit.MILLISECONDS.sleep(2000);
			logg.info("Add to cart modal close successfully");
			driver.findElement(ShopNavClick).click();
			logg.info("Shop Page Opens Successfully");
			sf.assertEquals(driver.getTitle(), ShopPageTitle);
			logg.info("Shop Page assertion passed successfully");
			logg.info("*********************** Favorites TestCase Passed ***********************");
		}

		catch (Exception ex)

		{
			logg.info(
					"POMFavoritesPage - Exception!!! - There must be some issue on favorites page while doing add to cart"
							+ ex.getMessage());
			
			Assert.fail("Failed in class - POMFavoritesPage");
		}
	}
}
