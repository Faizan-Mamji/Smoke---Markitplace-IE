package POMMarkITplacePages;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class POMReportsPage {

	public static WebDriver driver;
	Logger logg = LogManager.getLogger(POMReportsPage.class);
	String AssetPageTitle = "Assets Report - MarkITplace";
	String EmptyPageText = "Records not found";

	public static void main(String[] args) {
	}

	public POMReportsPage(WebDriver driver) {
		POMReportsPage.driver= driver;
	}
	
	// Declare POM

	By ReportsNav = By.xpath("(//ul[@class='section-nav-item-container track']//a)[2]");
	By AssetsNavLink = By.linkText("Assets");
	By EmailIconClick = By.xpath("(//span[@class='product-list-actions']//a)[1]");
	By EmailAddress = By.id("email_addresses");
	By EmailSendBtn = By.xpath("(//div[@class='modal-content']//button)[17]");

	public void AssetPage_Functionality() {
		
		Actions Ac = new Actions(driver);
		SoftAssert sf =new SoftAssert();
		try {
			logg.info("Reports testcase starts here");
			Ac.moveToElement(driver.findElement(ReportsNav)).perform();
			logg.info("Reports hover opens successfully");
			driver.findElement(AssetsNavLink).click();
			//TimeUnit.SECONDS.sleep(6);
			sf.assertEquals(AssetPageTitle, driver.getTitle());
			logg.info("Assets Report Assertion Verified successfully");
			logg.info("Assets Report page opens successfully");
			WebElement ColumnFrom = driver.findElement(By.xpath("(//label[@class='drag-handle sort-arrow none'])[2]"));
			WebElement ColumnTo = driver.findElement(By.xpath("(//label[@class='drag-handle sort-arrow none'])[5]"));
			TimeUnit.SECONDS.sleep(2);
			driver.findElement(EmailIconClick).click();
			logg.info("Email Modal opens successfully");
			TimeUnit.SECONDS.sleep(2);
			driver.findElement(EmailAddress).sendKeys("faizan.mamji@arpatech.com");
			logg.info("Email address entered successfully in textbox");
			TimeUnit.SECONDS.sleep(2);
			driver.findElement(EmailSendBtn).click();
			TimeUnit.SECONDS.sleep(50);
			logg.info("Email sent successfully on a given emailaddress");
			//Ac.dragAndDrop(ColumnFrom, ColumnTo).build().perform();
			//Ac.clickAndHold(ColumnFrom).moveToElement(ColumnTo).release(ColumnTo).build().perform();;
			//Action dragcolumn = Ac.dragAndDrop(ColumnFrom, ColumnTo).build();
			//logg.info("Column Drag & Drop successfully!!");
			logg.info("*********************** Reports TestCase Passed ***********************");
		}

		catch (Exception ex) {
			logg.info(
					"POMReportsPage - Exception!!! - Must have issue on Assets Report page while email or opens the page - AssetPage_Functionality "
							+ ex.getMessage());
			Assert.fail("Failed in class - POMReportsPage");
		}
	}
}
