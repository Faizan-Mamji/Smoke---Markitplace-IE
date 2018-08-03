package POMMarkITplacePages;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class POMQuotesPage {

	public static WebDriver driver;
	Logger logg = LogManager.getLogger(POMQuotesPage.class);
	String QuotesPageTitle = "Quotes - MarkITplace";
	String EmptyPageText = "No Result Found";

	public static void main(String[] args) {
	}

	public POMQuotesPage(WebDriver driver) 
	{
		POMQuotesPage.driver=driver;
	}
	
	// Declare POM

	By QuotesNavClick = By.xpath("(//ul[@class='section-nav-item-container track']//a)[4]");
	By BtnLoadMore = By.id("load-more-link");
	By QuotesTimePeriod = By.xpath("//select[@title='Select Time Period']");

	public void QuotesPage_Functionality() {
		SoftAssert sf =new SoftAssert();
		try {
			logg.info("Quotes testcase starts here");
			driver.findElement(QuotesNavClick).click();
			TimeUnit.SECONDS.sleep(10);
			sf.assertEquals(QuotesPageTitle, driver.getTitle());
			logg.info("Quotes Page assertion verified Successfully");
			logg.info("Quotes Page opened Successfully");
			Select DrpOrdersTimePeriod = new Select(driver.findElement(QuotesTimePeriod));
			DrpOrdersTimePeriod.selectByIndex(4);
			TimeUnit.SECONDS.sleep(20);
			logg.info("Dropdown value changed");
			String GetBtnClass = driver.findElement(BtnLoadMore).getAttribute("class");
			String CheckOrderData = driver.getPageSource();
			if (CheckOrderData.contains(EmptyPageText)) {
				logg.info("There is no data on Quotes page");
				logg.info("*********************** Quotes Page TestCase Passed ***********************");
			}

			else {

				if (GetBtnClass.contains("btn disabled")) {
					logg.info("Load More button is disabled as the count is less than 8!");
					logg.info("*********************** Quotes TestCase Passed ***********************");
				}

				else {
					logg.info("Button found enabled!");
					logg.info("Click on loadmore button");
					driver.findElement(BtnLoadMore).click();
					TimeUnit.SECONDS.sleep(25);
					logg.info("Load More button clicks successfully and data loads");
					logg.info("*********************** Quotes TestCase Passed ***********************");
				}
			}
		}

		catch (Exception ex) {
			logg.info(
					"POMQuotesPage - Exception!!! - Must have issue on Quotes page while click to loadmore button - QuotesPage_Functionality "
							+ ex.getMessage());
			
			Assert.fail("Failed in class - POMQuotesPage");
		}
	}
}
