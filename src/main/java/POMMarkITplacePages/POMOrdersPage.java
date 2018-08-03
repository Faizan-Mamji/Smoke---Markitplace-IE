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

public class POMOrdersPage {

	public static WebDriver driver;
	Logger logg = LogManager.getLogger(POMOrdersPage.class);
	String OrderPageTitle = "Orders - MarkITplace";
	String EmptyPageText = "No Result Found";

	public static void main(String[] args) {
	}

	public POMOrdersPage(WebDriver driver) {
		POMOrdersPage.driver = driver;
	}

	// Declare POM

	By OrdersNavClick = By.xpath("(//ul[@class='section-nav-item-container track']//a)[3]");
	By BtnLoadMore = By.id("load-more-link");
	By OrderBuyItemAgain = By.xpath("(//a[contains(text(),'Buy Item(s) Again')])[1]");
	By CartModalClose = By.xpath("(//div[@class='modal-content']/button[@title='Close (Esc)'])[1]");
	By OrdersTimePeriod = By.xpath("//select[@title='Select Time Period']");

	public void OrdersPage_Functionality() {
		SoftAssert sf =new SoftAssert();
		try {
			logg.info("Orders testcase starts here");
			driver.findElement(OrdersNavClick).click();
			TimeUnit.SECONDS.sleep(10);
			sf.assertEquals(OrderPageTitle, driver.getTitle());
			logg.info("Orders Page assertion verified Successfully");
			logg.info("Orders Page opened Successfully");
			logg.info("Click On Buy items again button");
			driver.findElement(OrderBuyItemAgain).click();
			TimeUnit.SECONDS.sleep(25);
			logg.info("Buy items again modal opens Successfully");
			driver.findElement(CartModalClose).click();
			TimeUnit.SECONDS.sleep(3);
			logg.info("Buy items again modal Close Successfully");
			Select DrpOrdersTimePeriod = new Select(driver.findElement(OrdersTimePeriod));
			DrpOrdersTimePeriod.selectByIndex(5);
			TimeUnit.SECONDS.sleep(20);
			logg.info("Dropdown value changed");
			String GetBtnClass = driver.findElement(BtnLoadMore).getAttribute("class");
			String CheckOrderData = driver.getPageSource();
			if (CheckOrderData.contains(EmptyPageText)) {
				logg.info("There is no data on orders page");
				logg.info("*********************** Orders Page TestCase Passed ***********************");
			}

			else {

				if (GetBtnClass.contains("btn disabled")) {
					logg.info("Disabled class found!!");
					logg.info("Load More button is disabled as the count is less than 8!");
					logg.info("*********************** Orders TestCase Passed ***********************");
				}

				else {
					logg.info("Button found enabled!");
					logg.info("Click on loadmore button");
					driver.findElement(BtnLoadMore).click();
					TimeUnit.SECONDS.sleep(20);
					logg.info("Load More button clicks successfully and data loads");
					logg.info("*********************** Orders TestCase Passed ***********************");
				}
			}
		}

		catch (Exception ex) {
			logg.info(
					"POMOrdersPage - Exception!!! - Must have issue on Orders page while doing add to cart or click to loadmore button - OrdersPage_Functionality "
							+ ex.getMessage());
			
			Assert.fail("Failed in class - POMOrdersPage");
		}
	}
}
