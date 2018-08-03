package POMMarkITplacePages;

import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class POMCalendarsPage {

	public static WebDriver driver;
	String CalendarPageTitle = "Calendar Monthly View - MarkITplace";
	Logger logg = LogManager.getLogger(POMCalendarsPage.class);

	public static void main(String[] args) {

	}

	public POMCalendarsPage(WebDriver driver) {
		POMCalendarsPage.driver = driver;
	}

	// Define Calendars page POM

	By CalendarDetailView = By.xpath("//span[contains(text(),'Detail view')]");
	By CalendarNavClick = By.xpath("(//ul[@class='section-nav-item-container track']//a)[1]");

	public void CalendarPage_Function() {
		SoftAssert sf= new SoftAssert();
		try {
			logg.info("Calendars Page testcase starts here");
			driver.findElement(CalendarNavClick).click();
			logg.info("Calendars Page Open successfully");
			TimeUnit.SECONDS.sleep(4);
			sf.assertEquals(driver.getTitle(), CalendarPageTitle);
			logg.info("Calendars Page Assertion verified");
			Select calyear = new Select(driver.findElement(By.xpath("//select[@id='calendarSelectYearMonthly']")));
			calyear.selectByIndex(5);
			logg.info("Years Dropdown value selected successfully");
			TimeUnit.SECONDS.sleep(8);
			driver.findElement(CalendarDetailView).click();
			logg.info("Details view tab opens successfully");
			TimeUnit.SECONDS.sleep(4);
			logg.info("*********************** Calendars Page TestCase Passed ***********************");
		}

		catch (Exception ex) {
			logg.info("POMCalendarsPage - Exception!!! - Must have issue on calendars page  - CalendarPage_Function  "
					+ ex.getMessage());
			Assert.fail("Failed in class - POMCalendarsPage");
		}
	}
}
