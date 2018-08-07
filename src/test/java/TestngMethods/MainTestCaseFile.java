package TestngMethods;

import org.testng.annotations.Test;
import DriverMainPackage.MainDriverClass;
import POMMarkITplacePages.POMCalendarsPage;
import POMMarkITplacePages.POMCartPage;
import POMMarkITplacePages.POMCheckOutPage;
import POMMarkITplacePages.POMFavoritesPage;
import POMMarkITplacePages.POMFooter;
import POMMarkITplacePages.POMLoginPage;
import POMMarkITplacePages.POMOrdersPage;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import POMMarkITplacePages.POMProductDetail;
import POMMarkITplacePages.POMPurchaseAnalysisPage;
import POMMarkITplacePages.POMQuotesPage;
import POMMarkITplacePages.POMReportsPage;
import POMMarkITplacePages.POMSavedReportsPage;
import POMMarkITplacePages.POMSearchListing;
import POMMarkITplacePages.POMStandardDetail;
import POMMarkITplacePages.POMStandardListing;
import POMMarkITplacePages.POMTrackPage;
import POMMarkITplacePages.POMTrackSearchResultPage;
import POMMarkITplacePages.TestExecutionEmail;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class MainTestCaseFile extends MainDriverClass {

	// Username: arpatech_bus034@connection.com
	// Password: 7QMGcA9u
	// arpatech1@connection.com
	// Arp@tech5
	// gcarrasco@netflix.com
	// Arp@tech1

	// Just to check for push..

	public static WebDriver maindriver;
	String Login_UserName = "arpatech_bus034@connection.com";
	String Login_Password = "7QMGcA9u";
	static final Logger logg = LogManager.getLogger(MainTestCaseFile.class);

	@BeforeTest
	public void beforeTest() throws IOException {
		maindriver = genericDriver();
	}

	@Test(priority = 0)
	public void TestCase1_LoginPage() {

		try {
			POMLoginPage ObjLogin = new POMLoginPage(maindriver);
			ObjLogin.loginpage_function(Login_UserName, Login_Password);
		}

		catch (Exception ex) {
			logg.info("TestngMethods - Exception!!! - There is some issue on TestCase1_LoginPage() " + ex.getMessage());
		}

	}
	
	@Test(priority = 1)
	public void TestCase2_SearchListingPage() {

		try {
			POMSearchListing ObjListing = new POMSearchListing(maindriver);
			ObjListing.OpenSearchPage_AddToCart_And_Verifyproducts_On_FavoritesPage();
		}

		catch (Exception ex) {
			logg.info("TestngMethods - Exception!!! - There is some issue on TestCase2_SearchListingPage() "
					+ ex.getMessage());
		}
	}

		@Test(priority = 2)
	public void TestCase3_PDPTestCase() {

		try {
			POMProductDetail ObjPDP = new POMProductDetail(maindriver);
			ObjPDP.Navigate_PDP_Page_From_SearchListing();
			ObjPDP.PDPEmailFunction();
		}

		catch (Exception ex) {
			logg.info("TestngMethods - Exception!!! - There is some issue on TestCase3_FavoritesAddSelectedToCart() "
					+ ex.getMessage());
		}
	}
		
	@Test(priority = 3)
	public void TestCase4_FavoritesAddSelectedToCart() {

		try {
			POMFavoritesPage ObjFavorites = new POMFavoritesPage(maindriver);
			ObjFavorites.Favorites_Page_TestFunctionality();
		}

		catch (Exception ex) {
			logg.info("TestngMethods - Exception!!! - There is some issue on TestCase3_FavoritesAddSelectedToCart() "
					+ ex.getMessage());
		}
	}

	@Test(priority = 4)
	public void TestCase5_StandardListing() {

		try {
			POMStandardListing ObjStandard = new POMStandardListing(maindriver);
			ObjStandard.Navigate_Standard_Listing_Verify_Left_Navigation_AddToCart();
		}

		catch (Exception ex) {
			logg.info("TestngMethods - Exception!!! - There is some issue on TestCase5_StandardListing() "
					+ ex.getMessage());
		}
	}

	@Test(priority = 5)
	public void TestCase6_StandardDetail() {

		try {
			POMStandardDetail ObjStandardDetail = new POMStandardDetail(maindriver);
			ObjStandardDetail.Navigate_SDP_From_StandardListing();
		}

		catch (Exception ex) {
			logg.info("TestngMethods - Exception!!! - There is some issue on TestCase6_StandardDetail() "
					+ ex.getMessage());
		}
	}

	@Test(priority = 6)
	public void TestCase7_CartPage() {

		try {
			POMCartPage ObjCart = new POMCartPage(maindriver);
			ObjCart.Navigate_Cart_Page_Check_Functionality();
		}

		catch (Exception ex) {
			logg.info("TestngMethods - Exception!!! - There is some issue on TestCase7_CartPage() " + ex.getMessage());
		}
	}

	@Test(priority = 7)
	public void TestCase8_CheckoutProcess() {

		try {
			POMCheckOutPage ObjCheckout = new POMCheckOutPage(maindriver);
			ObjCheckout.CompleteCheckout_Process();
		}

		catch (Exception ex) {
			logg.info("TestngMethods - Exception!!! - There is some issue on TestCase8_CheckoutProcess() "
					+ ex.getMessage());
		}
	}

	@Test(priority = 8)
	public void TestCase9_TrackPage() {

		try {
			POMTrackPage ObjTrack = new POMTrackPage(maindriver);
			ObjTrack.TrackPageFunction_BuyItemsAgain();
			ObjTrack.TrackPageFunction_QuickSearch();
		}

		catch (Exception ex) {
			logg.info("TestngMethods - Exception!!! - There is some issue on TestCase9_TrackPage " + ex.getMessage());
		}
	}

	@Test(priority = 9)
	public void TestCase10_TrackPage() {

		try {
			POMTrackSearchResultPage ObjTrackSearch = new POMTrackSearchResultPage(maindriver);
			ObjTrackSearch.TrackSearchResultPage_Function();

		}

		catch (Exception ex) {
			logg.info(
					"TestngMethods - Exception!!! - There is some issue on TestCase10_TrackPage() " + ex.getMessage());
		}
	}

	@Test(priority = 10)
	public void TestCase11_CalendarsPage() {

		try {
			POMCalendarsPage ObjCalendars = new POMCalendarsPage(maindriver);
			ObjCalendars.CalendarPage_Function();
		}

		catch (Exception ex) {
			logg.info("TestngMethods - Exception!!! - There is some issue on TestCase11_CalendarsPage() "
					+ ex.getMessage());
		}
	}

	@Test(priority = 11)
	public void TestCase12_PuchaseAnalysis() {

		try {
			POMPurchaseAnalysisPage ObjPurchase = new POMPurchaseAnalysisPage(maindriver);
			ObjPurchase.OpenPurchase_Analysis_Email();
		}

		catch (Exception ex) {
			logg.info("TestngMethods - Exception!!! - There is some issue on TestCase12_PuchaseAnalysis() "
					+ ex.getMessage());
		}
	}

	@Test(priority = 12)
	public void TestCase13_SavedReports() {

		try {
			POMSavedReportsPage ObjSavedReport = new POMSavedReportsPage(maindriver);
			ObjSavedReport.OpenSavedReport_ScheduleModal();
		}

		catch (Exception ex) {
			logg.info("TestngMethods - Exception!!! - There is some issue on TestCase13_SavedReports() "
					+ ex.getMessage());
		}
	}

	@Test(priority = 13)
	public void TestCase14_TrackOrders() {

		try {
			POMOrdersPage ObjOrders = new POMOrdersPage(maindriver);
			ObjOrders.OrdersPage_Functionality();
		}

		catch (Exception ex) {
			logg.info("TestngMethods - Exception!!! - There is some issue on TestCase14_TrackOrders() "
					+ ex.getMessage());
		}
	}

	@Test(priority = 14)
	public void TestCase15_TrackQuotes() {

		try {
			POMQuotesPage ObjQuotes = new POMQuotesPage(maindriver);
			ObjQuotes.QuotesPage_Functionality();
		}

		catch (Exception ex) {
			logg.info("TestngMethods - Exception!!! - There is some issue on TestCase15_TrackQuotes() "
					+ ex.getMessage());
		}
	}

	@Test(priority = 15)
	public void TestCase16_MainReports() {

		try {
			POMReportsPage	 ObjReports = new POMReportsPage(maindriver);
			ObjReports.AssetPage_Functionality();
			ObjReports.AllReportsPage_Functionality();
		}

		catch (Exception ex) {
			logg.info("TestngMethods - Exception!!! - There is some issue on TestCase16_AssetsReport() "
					+ ex.getMessage());
		}
	}

	@Test(priority = 16)
	public void TestCase17_FooterPageOpens() {

		try {
			POMFooter ObjFooter = new POMFooter(maindriver);
			ObjFooter.Navigate_Footer();
		}

		catch (Exception ex) {
			logg.info("TestngMethods - Exception!!! - There is some issue on TestCase17_FooterPageOpens() "
					+ ex.getMessage());
		}
	}
	

	@AfterTest
	public void afterTest() throws Exception {
		//TestExecutionEmail ObjEmail= new TestExecutionEmail(maindriver);
		maindriver.quit();
		/*TimeUnit.SECONDS.sleep(30);
		ObjEmail.EmailFunction();*/
	}
}
