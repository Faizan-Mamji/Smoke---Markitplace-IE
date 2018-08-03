package POMMarkITplacePages;

import static org.testng.Assert.assertEquals;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class POMTrackPage {

	public static WebDriver driver;
	String TrackPageTitle = "Track Dashboard - MarkITplace";
	String TrackSearchResultPageTitle = "Search Result - MarkITplace";
	Logger logg = LogManager.getLogger(POMTrackPage.class);

	public static void main(String[] args) {
	}

	public POMTrackPage(WebDriver driver) {
		POMTrackPage.driver = driver;
	}

	// Define Track Page POM
	By TrackNavClick = By.xpath("(//div[@class='homepage-nav-item-container']//a)[2]");
	By BtnBuyItemsAgain = By.xpath("(//div[@class='accordion-content clearfix active']//a)[2]");
	By QuickFinderSearch = By.xpath("//input[@class='quick-search']");
	By CloseBtnAddToCart = By.xpath("(//button[@title='Close (Esc)'])[1]");

	public void TrackPageFunction_BuyItemsAgain() {
		SoftAssert sf =new SoftAssert();
		try {
			logg.info("Track TestCase Starts Here");
			driver.findElement(TrackNavClick).click();
			TimeUnit.SECONDS.sleep(10);
			logg.info("Track Dashboard opens successfully");
			sf.assertEquals(driver.getTitle(), TrackPageTitle);
			logg.info("Track Dashboard Assertion verified");
			driver.findElement(BtnBuyItemsAgain).click();
			TimeUnit.SECONDS.sleep(30);
			logg.info("Buy items button click successfully");
			driver.findElement(CloseBtnAddToCart).click();
			logg.info("Add To Cart Modal Close successfully");
			TimeUnit.SECONDS.sleep(5);
			logg.info("*********************** Track Page TestCase Passed ***********************");
		}

		catch (Exception ex) {
			logg.info(
					"POMTrackPage - Exception!!! - Must have issue on track page while using Buy Items Again - TrackPageFunction_BuyItemsAgain "
							+ ex.getMessage());
		}
	}

	public void TrackPageFunction_QuickSearch() {
		SoftAssert sf =new SoftAssert();
		try {
			logg.info("QuickSearch Function Starts Here");
			driver.findElement(QuickFinderSearch).sendKeys("11");
			TimeUnit.SECONDS.sleep(2);
			driver.findElement(QuickFinderSearch).sendKeys(Keys.ENTER);
			TimeUnit.SECONDS.sleep(50);
			sf.assertEquals(driver.getTitle(), TrackSearchResultPageTitle);
			logg.info("Track Search Result Page Assertion verified");
			TimeUnit.SECONDS.sleep(3);
			logg.info("*********************** Track Page TestCase Passed ***********************");
		}

		catch (Exception ex) {
			logg.info(
					"POMTrackPage - Exception!!! - Must have issue on track page while doing Buy Items Again - TrackPageFunction_QuickSearch  "
							+ ex.getMessage());
			Assert.fail("Failed in class - POMTrackPage");
		}
	}
}
