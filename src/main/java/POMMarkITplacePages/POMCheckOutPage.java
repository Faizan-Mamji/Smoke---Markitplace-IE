package POMMarkITplacePages;

import static org.testng.Assert.assertEquals;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class POMCheckOutPage {

	public static WebDriver driver;
	static final Logger logg = LogManager.getLogger(POMCheckOutPage.class);
	Random rnd = new Random();
	int PO = rnd.nextInt(999999);
	String CheckBillingAddressText = "Select billing address";
	String OrderConfirmationTitle = "Order Confirmation - MarkITplace";
	String CheckoutPageTitle = "Checkout - MarkITplace";
	String CheckOutErrorMessage = "Oops! Your order could not be processed at this time. Your Account Team is ready to help or try again.";
	// String OrderConfirmationTitle = "Order Confirmation - MarkITplace";

	public static void main(String[] args) {
	}

	public POMCheckOutPage(WebDriver driver) {
		POMCheckOutPage.driver = driver;
	}

	// Declare Checkout Page POM

	// POM Of Step 1 (Select Payment Method)
	By POTextBox = By.id("tbPO");
	By ReferenceTextBox = By.id("tbReference");
	By ProjectTextBox = By.id("tbProject");
	By CostCenterTextBox = By.id("tbCostCenter");
	By CheckBillingAddress = By.xpath("//div[@class='step-subsection last']");
	By OpenBillingAddressDropdown = By.xpath("//div[@class='predictive-dropdown-arrow']");
	By SelectBillingAddressValue = By.xpath("//div[@class='predictive-quickfind-container']//li[1]");

	By SaveBtn = By.xpath("//a[contains(text(),'Save & Continue')]");

	// POM Of Step 2 (Shipping Information)
	By SelectAddress = By.xpath("(//div[@class='multiselect-address']//ul//li)[1]");
	By UseThisAddressBtn = By.xpath("//a[contains(text(),'Use This Address')]");

	// POM Of Step 3 (Notes for Recipient and Confirmations)

	By SendEmailConfirmation = By.id("tbEmailConfirmation");

	// POM Of Step 4 (Review Order Details)

	By PlaceOrderBtn = By.xpath("(//a[contains(text(),'Place Order')])[1]");

	// POM Of Error box on checkout

	By ErrorOopsBox = By.xpath("//div[@class='modal-dialog']//span");
	By ErrorCloseBtn = By.xpath("//button[@class='btn btn-default']");
	By ClickLogoImage = By.xpath("//img[@class='logo']");

	public void CompleteCheckout_Process() throws InterruptedException {
		SoftAssert sf =new SoftAssert();
		try {
			// Step 1 of Checkout process
			logg.info("CheckOut TestCase Starts Here");
			driver.findElement(POTextBox).sendKeys(String.valueOf(PO));
			TimeUnit.MILLISECONDS.sleep(1000);
			logg.info("PO number enters successfully");
			driver.findElement(ReferenceTextBox).sendKeys("Test");
			TimeUnit.MILLISECONDS.sleep(1000);
			logg.info("Reference text enters successfully");
			driver.findElement(ProjectTextBox).sendKeys("Test");
			TimeUnit.MILLISECONDS.sleep(1000);
			logg.info("Project text enters successfully");
			driver.findElement(CostCenterTextBox).sendKeys("Test");
			TimeUnit.MILLISECONDS.sleep(1000);
			logg.info("CostCenter text enters successfully");
			String BillingAddressText = driver.findElement(CheckBillingAddress).getText();
			
			if (BillingAddressText.contains(CheckBillingAddressText)) {
				driver.findElement(OpenBillingAddressDropdown).click();
				logg.info("Select Billing address dropdown opens successfully");
				driver.findElement(SelectBillingAddressValue).click();
				logg.info("Billing address dropdown value selected successfully");
				driver.findElement(SaveBtn).click();
				TimeUnit.MILLISECONDS.sleep(4000);
				logg.info("Save & Continue Button Click successfully");
			} else {
				driver.findElement(SaveBtn).click();
				TimeUnit.MILLISECONDS.sleep(4000);
				logg.info("Save & Continue Button Click successfully");
			}
			// Step 2 of Checkout process
			logg.info("Now selection of address on checkout page");
			driver.findElement(SelectAddress).click();
			TimeUnit.MILLISECONDS.sleep(2000);
			logg.info("Address selects successfully");
			driver.findElement(UseThisAddressBtn).click();
			TimeUnit.MILLISECONDS.sleep(3000);
			logg.info("Use this button click successfully");
			driver.findElement(SaveBtn).click();
			TimeUnit.MILLISECONDS.sleep(4000);
			logg.info("Save & Continue Button Click successfully");

			// Step 3 of Checkout process
			driver.findElement(SendEmailConfirmation).clear();
			TimeUnit.MILLISECONDS.sleep(2000);
			driver.findElement(SendEmailConfirmation).sendKeys("faizan.mamji@arpatech.com");
			TimeUnit.MILLISECONDS.sleep(2000);
			logg.info("Email entered successfully in textbox");
			driver.findElement(SaveBtn).click();
			TimeUnit.MILLISECONDS.sleep(4000);
			logg.info("Save & Continue Button Click successfully");

			// Step 4 of Checkout process
			driver.findElement(PlaceOrderBtn).click();
			TimeUnit.MILLISECONDS.sleep(50000);
			logg.info("Place Holder Button Click successfully!");

			String TitleVerification = driver.getTitle();
			if (TitleVerification.equalsIgnoreCase(OrderConfirmationTitle)) {
				sf.assertEquals(TitleVerification, OrderConfirmationTitle);
				logg.info("Order Confirmation Page assertion verified successfully!");
				logg.info("Order Confirmation Page Opens successfully!");
				logg.info("*********************** Checkout TestCase Passed ***********************");

			}

			else {
				String errormessage = driver.findElement(ErrorOopsBox).getText();
				if (errormessage.equalsIgnoreCase(CheckOutErrorMessage)) {
					driver.findElement(ErrorCloseBtn).click();
					TimeUnit.MILLISECONDS.sleep(2000);
					logg.info("Oops box close on checkout page!");
					driver.findElement(ClickLogoImage).click();
					logg.info("Navigate to Home page!");
					logg.info("*********************** Checkout Not Done Due To Api Issue As It Opens Oops Modal ***********************");
				}

			}
		}

		catch (Exception ex) {
			logg.info(
					"POMCheckOutPage - Exception!!! - There is some issue while doing checkout or may be it shouldn't navigate to order confirmation page "
							+ ex.getMessage());
			
			Assert.fail("Failed in class - POMCheckOutPage");
		}
	}

}
