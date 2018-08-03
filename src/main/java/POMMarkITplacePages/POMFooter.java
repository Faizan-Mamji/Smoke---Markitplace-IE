package POMMarkITplacePages;

import static org.testng.Assert.assertEquals;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class POMFooter {

	public static WebDriver driver;
	Logger logg = LogManager.getLogger(POMFooter.class);
	String ProfilePageTitle= "My Profile - MarkITplace";
	String ShippingPageTitle= "Shipping Address - MarkITplace";
	String AllProductsPageTitle = "All Products - MarkITplace";
	String ResourcePageTitle = "Resources - MarkITplace";
	String SpecialOfferPageTitle = "Special Offers - MarkITplace";
	String AboutUsPageTitle = "About MarkITPlace - MarkITplace";
	String ContactUsPageTitle = "Contact Us - MarkITplace";
	String CustomerSupportPageTitle = "Customer Support - MarkITplace";
	String TermsOfSalePageTitle = "Terms of Sale - MarkITplace";
	String PrivacyPolicyPageTitle = "Privacy Policy - MarkITplace";
	String AccessibilityPageTitle = "Accessibility Policy - Connection";
	String HelpPageTitle = "Help - MarkITplace";

	public static void main(String[] args) {
	}

	public POMFooter(WebDriver driver) {

		POMFooter.driver = driver;
	}

	// Declare Footer POM

	By HoverTopMyAccount = By.xpath("//a[@class='clearfix']");
	By MyProfile = By.xpath("(//div[@class='account-menu']//a)[1]");
	By ShippingAddress = By.xpath("(//div[@class='account-menu']//a)[2]");
	By FooterAllproducts = By.xpath("(//div[@class='footer-top-right clearfix']//a)[3]");
	By FooterResources = By.xpath("(//div[@class='footer-top-right clearfix']//a)[4]");
	By FooterSpecialOffers = By.xpath("(//div[@class='footer-top-right clearfix']//a)[5]");
	By FooterAboutUs = By.xpath("(//div[@class='footer-top-right clearfix']//a)[13]");
	By FooterContactUs = By.xpath("(//div[@class='footer-top-right clearfix']//a)[14]");
	By FooterCustomerSupport = By.xpath("(//div[@class='footer-top-right clearfix']//a)[15]");
	By FooterTermsOfSale = By.xpath("(//div[@class='footer-top-right clearfix']//a)[16]");
	By FooterPrivacyPolicy = By.xpath("(//div[@class='footer-top-right clearfix']//a)[17]");
	By FooterAccessibility = By.xpath("(//div[@class='footer-top-right clearfix']//a)[18]");
	By FooterHelp = By.xpath("(//div[@class='footer-top-right clearfix']//a)[19]");

	public void Navigate_Footer() {
		SoftAssert sf =new SoftAssert();
		Actions Ac = new Actions(driver);
		try {
			logg.info("Footer Testcase starts here");
			String Parent_Window = driver.getWindowHandle();
			logg.info("Main Window stores here");
			
			Ac.moveToElement(driver.findElement(HoverTopMyAccount)).perform();
			TimeUnit.SECONDS.sleep(3);
			logg.info("My Account hover opens");
			driver.findElement(MyProfile).click();
			TimeUnit.SECONDS.sleep(6);
			logg.info("My Profile Page Opens Successfully");
			sf.assertEquals(driver.getTitle(),ProfilePageTitle );
			logg.info("My Profile Assertion Verified Successfully");
			
			Ac.moveToElement(driver.findElement(HoverTopMyAccount)).perform();
			TimeUnit.SECONDS.sleep(3);
			logg.info("My Account hover opens");
			driver.findElement(ShippingAddress).click();
			TimeUnit.SECONDS.sleep(3);
			logg.info("Shipping Address Page Opens Successfully");
			sf.assertEquals(driver.getTitle(), ShippingPageTitle);
			logg.info("Shipping Assertion Verified Successfully");
			
			driver.findElement(FooterAllproducts).click();
			TimeUnit.SECONDS.sleep(3);
			logg.info("All Products Page Opens Successfully");
			sf.assertEquals(driver.getTitle(), AllProductsPageTitle);
			logg.info("All Products Assertion Verified Successfully");

			driver.findElement(FooterResources).click();
			TimeUnit.SECONDS.sleep(3);
			logg.info("Resource Page Opens Successfully");
			sf.assertEquals(driver.getTitle(), ResourcePageTitle);
			logg.info("Resource Assertion Verified Successfully");

			driver.findElement(FooterSpecialOffers).click();
			TimeUnit.SECONDS.sleep(3);
			logg.info("SpecialOffers Page Opens Successfully");
			sf.assertEquals(driver.getTitle(), SpecialOfferPageTitle);
			logg.info("Special Offers Assertion Verified Successfully");

			driver.findElement(FooterAboutUs).click();
			TimeUnit.SECONDS.sleep(3);
			logg.info("AboutUs Page Opens Successfully");
			sf.assertEquals(driver.getTitle(), AboutUsPageTitle);
			logg.info("AboutUs Assertion Verified Successfully");

			driver.findElement(FooterContactUs).click();
			TimeUnit.SECONDS.sleep(3);
			logg.info("ContactUs Page Opens Successfully");
			sf.assertEquals(driver.getTitle(), ContactUsPageTitle);
			logg.info("ContactUs Assertion Verified Successfully");

			driver.findElement(FooterCustomerSupport).click();
			TimeUnit.SECONDS.sleep(3);
			logg.info("Customer Support Page Opens Successfully");
			sf.assertEquals(driver.getTitle(), CustomerSupportPageTitle);
			logg.info("Customer Support Assertion Verified Successfully");

			driver.findElement(FooterTermsOfSale).click();
			TimeUnit.SECONDS.sleep(3);
			logg.info("Terms Of Sale Page Opens Successfully");
			sf.assertEquals(driver.getTitle(), TermsOfSalePageTitle);
			logg.info("Terms Of Sale Assertion Verified Successfully");

			driver.findElement(FooterPrivacyPolicy).click();
			TimeUnit.SECONDS.sleep(3);
			logg.info("Privacy Policy Page Opens Successfully");
			sf.assertEquals(driver.getTitle(), PrivacyPolicyPageTitle);
			logg.info("Privacy Policy Assertion Verified Successfully");

			driver.findElement(FooterAccessibility).click();
			TimeUnit.SECONDS.sleep(15);
			logg.info("Accessibility Page Opens Successfully");
			driver.switchTo().window(Parent_Window);
			logg.info("Navigate to parent window again");
			Set<String> AllWindows = driver.getWindowHandles();
			logg.info("Get All windows using getWindowHandles");
			for (String Child : AllWindows) {
				logg.info("Verify conditions here of different tabs");
				if (!Parent_Window.equalsIgnoreCase(Child)) {
					logg.info("Condition passed as child id is different from parent");
					driver.switchTo().window(Child);
					logg.info("Navigate to Child window again");
					sf.assertEquals(driver.getTitle(), AccessibilityPageTitle);
					logg.info("Accessibility assertion verified successfully");
					driver.switchTo().window(Parent_Window);
					logg.info("Navigate to parent window again");
				}
			}

			driver.findElement(FooterHelp).click();
			TimeUnit.SECONDS.sleep(3);
			logg.info("Help Page Opens Successfully");
			sf.assertEquals(driver.getTitle(), HelpPageTitle);
			logg.info("Help assertion verified successfully");
			logg.info("*********************** Footer TestCase Passed ***********************");
		}

		catch (Exception ex) {
			logg.info(
					"POMFooter - Exception!!! - There is some issue while navigating to footers Pages or may be a driver issue "
							+ ex.getMessage());
			Assert.fail("Failed in class - POMFooter");
		}
	}

}
