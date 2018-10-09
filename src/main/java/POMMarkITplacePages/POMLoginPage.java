package POMMarkITplacePages;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import DriverMainPackage.MainDriverClass;

//import DriverMainPackage.MainDriverClass;

public class POMLoginPage {

	public static WebDriver driver;
	String UrlValReturn;
	static final Logger logg = LogManager.getLogger(POMLoginPage.class);
	String TrackPageTitle = "Track Dashboard - MarkITplace";
	String ShopPageTitle = "Shop - MarkITplace";
	String StandardPageTitle = "Standard Products - MarkITplace";
	String AllProductsPageTitle = "All Products - MarkITplace";
	String FavoritesPageTitle = "Favorites - MarkITplace";
	String CalendarPageTitle = "Calendar Monthly View - MarkITplace";
	String AssetPageTitle = "Assets Report - MarkITplace";
	String DaysToShipPageTitle = "Days To Ship Report - MarkITplace";
	String ExpirationPageTitle = "Expiration Report - MarkITplace";
	String InventoryPageTitle = "Inventory Report - MarkITplace";
	String InvoicesPageTitle = "Invoices Report - MarkITplace";
	String InvoiceLinePageTitle = "Invoice Line Report - MarkITplace";
	String LicensesPageTitle = "Licenses Report - MarkITplace";
	String OrdersPageTitle = "Orders Report - MarkITplace";
	String WarrantiesPageTitle = "Warranties Report - MarkITplace";
	String StandardsPageTitle = "Standards Report - MarkITplace";
	String ShipmentsPageTitle = "Shipments Report - MarkITplace";
	String ReceivingLogPageTitle = "Receiving Log Report - MarkITplace";
	String QuotesPageTitle = "Quotes Report - MarkITplace";
	String OrderLinePageTitle = "Order Line Report - MarkITplace";
	String OrdersListingPageTitle = "Orders - MarkITplace";
	String QuotesListingPageTitle = "Quotes - MarkITplace";
	String PurchaseAnalysisPageTitle = "Purchase Analysis - MarkITplace";
	String SavedReportPageTitle = "Saved Reports - MarkITplace";
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

	public POMLoginPage(WebDriver driver) {
		POMLoginPage.driver = driver;
	}

	By login_email = By.name("username");
	By login_password = By.name("password");
	By submit_login = By.xpath("//input[@type='submit']");

	public void loginpage_function(String loginuname, String loginpassword) {
		MainDriverClass objdriver = new MainDriverClass();

		try {
			UrlValReturn = objdriver.getConfigValue("MainUrl");
			logg.info("Get the Value of UrlValReturn = " + UrlValReturn);
			driver.findElement(login_email).sendKeys(loginuname);
			logg.info("UserEmail enters in email textbox");
			driver.findElement(login_password).sendKeys(loginpassword);
			logg.info("UserPassword enters in password textbox");
			driver.findElement(submit_login).click();
			logg.info("Submit button click successfully and navigate to default landing page");
			String pagetext = driver.getTitle();

			if (pagetext.equalsIgnoreCase(TrackPageTitle)) {
				logg.info("Track Dashboard Opens after login to the application");
				logg.info("*********************** Login TestCase Passed ***********************");
			}

			else if (pagetext.equalsIgnoreCase(ShopPageTitle)) {
				logg.info("Shop page Opens after login to the application");
				logg.info("*********************** Login TestCase Passed ***********************");
			}

			else if (pagetext.equalsIgnoreCase(StandardPageTitle))

			{
				logg.info("Standard Listing page Opens after login to the application");
				logg.info("*********************** Login TestCase Passed ***********************");
			}

			else if (pagetext.equalsIgnoreCase(AllProductsPageTitle))

			{
				logg.info("All Products page Opens after login to the application");
				logg.info("*********************** Login TestCase Passed ***********************");
			}

			else if (pagetext.equalsIgnoreCase(FavoritesPageTitle))

			{
				logg.info("Favorites page Opens after login to the application");
				logg.info("*********************** Login TestCase Passed ***********************");
			}

			else if (pagetext.equalsIgnoreCase(CalendarPageTitle))

			{
				logg.info("Calendars page Opens after login to the application");
				logg.info("*********************** Login TestCase Passed ***********************");
			}

			else if (pagetext.equalsIgnoreCase(AssetPageTitle))

			{
				logg.info("Asset Report Opens after login to the application");
				logg.info("*********************** Login TestCase Passed ***********************");
			}

			else if (pagetext.equalsIgnoreCase(DaysToShipPageTitle))

			{
				logg.info("Days To Ship Report Opens after login to the application");
				logg.info("*********************** Login TestCase Passed ***********************");
			}

			else if (pagetext.equalsIgnoreCase(ExpirationPageTitle))

			{
				logg.info("Expiration Report Opens after login to the application");
				logg.info("*********************** Login TestCase Passed ***********************");
			}

			else if (pagetext.equalsIgnoreCase(InventoryPageTitle))

			{
				logg.info("Inventory Report Opens after login to the application");
				logg.info("*********************** Login TestCase Passed ***********************");
			}

			else if (pagetext.equalsIgnoreCase(InvoicesPageTitle))

			{
				logg.info("Invoices Report Opens after login to the application");
				logg.info("*********************** Login TestCase Passed ***********************");
			}

			else if (pagetext.equalsIgnoreCase(InvoiceLinePageTitle))

			{
				logg.info("Invoice Line Report Opens after login to the application");
				logg.info("*********************** Login TestCase Passed ***********************");
			}

			else if (pagetext.equalsIgnoreCase(LicensesPageTitle))

			{
				logg.info("Licenses Report Opens after login to the application");
				logg.info("*********************** Login TestCase Passed ***********************");
			}

			else if (pagetext.equalsIgnoreCase(OrdersPageTitle))

			{
				logg.info("Orders Report Opens after login to the application");
				logg.info("*********************** Login TestCase Passed ***********************");
			}

			else if (pagetext.equalsIgnoreCase(WarrantiesPageTitle))

			{
				logg.info("Warranties Report Opens after login to the application");
				logg.info("*********************** Login TestCase Passed ***********************");
			}

			else if (pagetext.equalsIgnoreCase(StandardsPageTitle))

			{
				logg.info("Standards Report Opens after login to the application");
				logg.info("*********************** Login TestCase Passed ***********************");
			}

			else if (pagetext.equalsIgnoreCase(ShipmentsPageTitle))

			{
				logg.info("Shipments Report Opens after login to the application");
				logg.info("*********************** Login TestCase Passed ***********************");
			}
			
			else if (pagetext.equalsIgnoreCase(ReceivingLogPageTitle))

			{
				logg.info("Receiving Log Report Opens after login to the application");
				logg.info("*********************** Login TestCase Passed ***********************");
			}
			
			else if (pagetext.equalsIgnoreCase(QuotesPageTitle))

			{
				logg.info("Quotes Report Opens after login to the application");
				logg.info("*********************** Login TestCase Passed ***********************");
			}
			
			else if (pagetext.equalsIgnoreCase(OrderLinePageTitle))

			{
				logg.info("Order Line Report Opens after login to the application");
				logg.info("*********************** Login TestCase Passed ***********************");
			}
			
			else if (pagetext.equalsIgnoreCase(OrdersListingPageTitle))

			{
				logg.info("Order Listing Page Opens after login to the application");
				logg.info("*********************** Login TestCase Passed ***********************");
			}
			
			else if (pagetext.equalsIgnoreCase(QuotesListingPageTitle))

			{
				logg.info("Quotes Listing Page Opens after login to the application");
				logg.info("*********************** Login TestCase Passed ***********************");
			}
			
			else if (pagetext.equalsIgnoreCase(PurchaseAnalysisPageTitle))

			{
				logg.info("PA Listing Page Opens after login to the application");
				logg.info("*********************** Login TestCase Passed ***********************");
			}
			
			else if (pagetext.equalsIgnoreCase(SavedReportPageTitle))

			{
				logg.info("Saved Report Opens after login to the application");
				logg.info("*********************** Login TestCase Passed ***********************");
			}
			

			else {
				logg.info("Some other/irrelevant page found during login the application");
			}
		}

		catch (Exception ex) {
			logg.info("POMLoginPage - Exception!!! - There must be driver issue or login issue " + ex.getMessage());
			Assert.fail("Failed in class - POMLoginPage");
		}
	}
}
