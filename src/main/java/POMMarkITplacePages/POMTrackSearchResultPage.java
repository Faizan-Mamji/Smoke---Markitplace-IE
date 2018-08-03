package POMMarkITplacePages;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class POMTrackSearchResultPage {

	public static WebDriver driver;
	String TrackSearchResultPageTitle = "Search Result - MarkITplace";
	String OrderLoadMoreBtnClass = "btn load-more-link order-load-more";
	String QuotesLoadMoreBtnClass = "btn load-more-link quote-load-more";
	String AssetsLoadMoreBtnClass = "btn load-more-link asset-load-more";
	String ShipmentsLoadMoreBtnClass = "btn load-more-link asset-load-more";
	Logger logg = LogManager.getLogger(POMTrackSearchResultPage.class);

	public static void main(String[] args) {

	}

	public POMTrackSearchResultPage(WebDriver driver) {
		POMTrackSearchResultPage.driver = driver;
	}

	// Search Result Page POM
	By LoadMoreBtn = By.xpath("//div[@class='row order-footer-controls']//button");
	By BtnQuotes = By.xpath("(//Section[@id='order-top']//span)[2]");
	By BtnAssets = By.xpath("(//Section[@id='order-top']//span)[3]");
	By BtnShipments = By.xpath("(//Section[@id='order-top']//span)[4]");
	By CheckTotalCount = By.xpath("//div[@class='search-matching-container']//p");

	public void TrackSearchResultPage_Function() {
		SoftAssert sf =new SoftAssert();
		try {
			sf.assertEquals(driver.getTitle(), TrackSearchResultPageTitle);
			logg.info("Track Search Result Assertion verified");
			TimeUnit.SECONDS.sleep(2);
			String OrdersCheckCountText = driver.findElement(CheckTotalCount).getText();
			logg.info("Get Count Of Orders Tab");
			TimeUnit.SECONDS.sleep(2);
			if (OrdersCheckCountText.contains("0 result matching")) {
				logg.info("Enter in condition here count is 0 in orders tab");
				driver.findElement(BtnQuotes).click();
				TimeUnit.SECONDS.sleep(3);
				logg.info("Navigate to quotes tab");
				String QuotesCheckCountText = driver.findElement(CheckTotalCount).getText();
				logg.info("Get Count Of Quotes Tab");
				if (QuotesCheckCountText.contains("0 result matching")) {
					logg.info("Enter in condition here count is 0 in quotes tab");
					driver.findElement(BtnAssets).click();
					TimeUnit.SECONDS.sleep(2);
					logg.info("Navigate to assets tab");
					String AssetsCheckCountText = driver.findElement(CheckTotalCount).getText();
					logg.info("Get Count Of Assets Tab");
					if (AssetsCheckCountText.contains("0 result matching")) {
						logg.info("Enter in condition here count is 0 in assets tab");
						driver.findElement(BtnShipments).click();
						TimeUnit.SECONDS.sleep(2);
						logg.info("Navigate to shipments tab");
						String ShipmentsCheckCountText = driver.findElement(CheckTotalCount).getText();
						logg.info("Get Count Of Shipments Tab");
						if (ShipmentsCheckCountText.contains("0 result matching")) {
							logg.info("Enter in condition here count is 0 in shipments tab");
							TimeUnit.SECONDS.sleep(2);
							logg.info("All Tabs Have 0 record");
						}

						else {
							String ShipmentsLoadBtnClass = driver.findElement(LoadMoreBtn).getAttribute("class");
							if (ShipmentsLoadBtnClass.contains(ShipmentsLoadMoreBtnClass)) {
								driver.findElement(LoadMoreBtn).click();
								TimeUnit.SECONDS.sleep(25);
								logg.info("Click on load more button in shipments tab");
								logg.info(
										"*********************** Track Search Result TestCase Passed ***********************");
							}
						}
					}

					else {
						String AssetsLoadBtnClass = driver.findElement(LoadMoreBtn).getAttribute("class");
						if (AssetsLoadBtnClass.contains(AssetsLoadMoreBtnClass)) {
							driver.findElement(LoadMoreBtn).click();
							TimeUnit.SECONDS.sleep(25);
							logg.info("Click on load more button in assets tab");
							logg.info(
									"*********************** Track Search Result TestCase Passed ***********************");
						}
					}
				}

				else {
					String QuotesLoadBtnClass = driver.findElement(LoadMoreBtn).getAttribute("class");
					if (QuotesLoadBtnClass.contains(QuotesLoadMoreBtnClass)) {
						driver.findElement(LoadMoreBtn).click();
						TimeUnit.SECONDS.sleep(25);
						logg.info("Click on load more button in quotes tab");
						logg.info(
								"*********************** Track Search Result TestCase Passed ***********************");
					}
				}
			}

			else {
				String OrdersLoadBtnClass = driver.findElement(LoadMoreBtn).getAttribute("class");
				if (OrdersLoadBtnClass.contains(OrderLoadMoreBtnClass)) {
					driver.findElement(LoadMoreBtn).click();
					TimeUnit.SECONDS.sleep(25);
					logg.info("Click on load more button in orders tab");
					logg.info("*********************** Track Search Result TestCase Passed ***********************");
				}
			}
		}

		catch (Exception ex) {
			logg.info(
					"POMTrackSearchSearchPage - Exception!!! - There is some issue on Track Search Result Page while click on load more button or may be driver issue "
							+ ex.getMessage());
			Assert.fail("Failed in class - POMTrackSearchResultPage");
		}
	}
}
