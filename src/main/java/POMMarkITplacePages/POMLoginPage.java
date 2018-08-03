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

			if (pagetext.equalsIgnoreCase("Track Dashboard - MarkITplace")) {
				logg.info("Track Dashboard Opens after login to the application");
				logg.info("*********************** Login TestCase Passed ***********************");
			}

			else if (pagetext.equalsIgnoreCase("Shop - MarkITplace")) {
				logg.info("Shop page Opens after login to the application");
				logg.info("*********************** Login TestCase Passed ***********************");
			}

			else if (pagetext.equalsIgnoreCase("Standard Products - MarkITplace"))

			{
				logg.info("Standard Listing page Opens after login to the application");
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
