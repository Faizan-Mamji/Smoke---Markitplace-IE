package DriverMainPackage;

import static org.testng.Assert.assertEquals;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import POMMarkITplacePages.POMProductDetail;

public class MainDriverClass {

	public static WebDriver driver;
	private static final Logger logg = LogManager.getLogger(MainDriverClass.class);
	String LoginPageTitle = "Login - MarkITplace";
	String GetURLValue;

	public static void main(String[] args) {
	}

	public WebDriver genericDriver() throws IOException {
		FileInputStream fs = new FileInputStream(".\\ConfigurationFile\\configuration.properties");
		;
		try {
			logg.info("Browser function starts");
			Properties prop = new Properties();
			logg.info("Properties Class initialize here");
			logg.info("FileInputStream function calling and verifying here configuration file path");
			prop.load(fs);
			logg.info("FileInputStream loaded");
			String GetBrowser = prop.getProperty("Browser");
			logg.info("Get value of browser here from configuration file");
			String GetUrl = prop.getProperty("Url");
			logg.info("Get value of Url here from configuration file");
			String PageImplicit = prop.getProperty("implicitlywait");
			logg.info("Get value of implicitwait here from configuration file");
			String PageLoadTime = prop.getProperty("pageloadwait");
			logg.info("Get value of pageloadwait here from configuration file");

			if (GetBrowser.equalsIgnoreCase("InternetExplorer")) {
				logg.info("Enters in IE Browser Condition");
				System.setProperty("webdriver.ie.driver",
						".\\src\\main\\resources\\IEDriver_Win32\\IEDriverServer.exe");
				logg.info("Browser system property path Verified");
				driver = new InternetExplorerDriver();
				logg.info("IE Browser opens successfully");
				driver.navigate().to(GetUrl);
				logg.info("Url Opened successfully in browser");
				driver.manage().window().maximize();
				assertEquals(LoginPageTitle, driver.getTitle());
				logg.info("Login assertion verified");
				driver.manage().timeouts().implicitlyWait(Long.parseLong(PageImplicit), TimeUnit.SECONDS);
				logg.info("ImplicitTime Defined In browser function");
				driver.manage().timeouts().pageLoadTimeout(Long.parseLong(PageLoadTime), TimeUnit.SECONDS);
				logg.info("Page Load time Defined In browser function");
				logg.info("*********************** Driver Function Passed ***********************");
			}
		}

		catch (IOException ex) {
			logg.info("Must have some browser opening issue or some path issue " + ex.getMessage());
		} catch (NullPointerException ex) {
			logg.info("Must have some browser opening issue or some path issue " + ex.getMessage());
		} finally {
			fs.close();
		}
		return driver;
	}

	public String getConfigValue(String passConfigurationKey) {
		Properties prop = new Properties();
		try {
			logg.info("Get Configuration Value Test Here");
			FileInputStream fs = new FileInputStream(".\\ConfigurationFile\\configuration.properties");
			logg.info("FileInputStream function calling and verifying here configuration file path");
			prop.load(fs);
			GetURLValue = prop.getProperty(passConfigurationKey);
			logg.info("URL value stored in parameter");
		}

		catch (Exception ex) {
			logg.info("MainDriverClass - There is an issue in : getConfigValue " + ex.getMessage());
		}

		return GetURLValue;
	}

}
