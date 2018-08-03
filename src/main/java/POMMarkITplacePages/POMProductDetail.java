package POMMarkITplacePages;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class POMProductDetail {
	
	public static WebDriver driver;
	static final Logger logg = LogManager.getLogger(POMProductDetail.class);
	String PDPTitle="HP Officejet Pro 8710 All-in-One - Multifunction printer - MarkITplace";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public POMProductDetail(WebDriver driver) 
	{
		POMProductDetail.driver=driver;
	}
	
	//Declare PDP POM of search listing for redirect to PDP 
	
	By productimageclick = By.xpath("(//div[@class='product-list-grid clearfix print-product-list grid']//a[@class='image-link'])[1]");
	By EmailIconClick= By.xpath("(//span[@class='product-list-actions']/a)[1]");
	By EmailAddress = By.id("email_addresses");
	By EmailSendBtn= By.xpath("//button[@class='btn btn-primary']");
	
	public void Navigate_PDP_Page_From_SearchListing() throws InterruptedException 
	{
		SoftAssert sf =new SoftAssert();
		//PropertyConfigurator.configure("log4j.properties");
		try
		{
			TimeUnit.MILLISECONDS.sleep(2000);
			logg.info("PDP TestCase starts here");
			driver.findElement(productimageclick).click();
			TimeUnit.MILLISECONDS.sleep(12000);
			logg.info("Click on product and navigate to PDP");
			sf.assertEquals(PDPTitle, driver.getTitle());
			TimeUnit.MILLISECONDS.sleep(2000);
			logg.info("PDP Assertion verified here");
			logg.info("*********************** PDP TestCase Passed ***********************");
		}
		
		catch (Exception ex)
		{
			logg.info("POMProductDetail - Exception!!! - Must have navigation issue to PDP page "+ex.getMessage());
			
		}
	}
	
	public void PDPEmailFunction() 
	{
		//PropertyConfigurator.configure("log4j.properties");
		try
		{
			TimeUnit.MILLISECONDS.sleep(2000);
			logg.info("PDP Email TestCase starts here");
			driver.findElement(EmailIconClick).click();
			TimeUnit.MILLISECONDS.sleep(5000);
			logg.info("Email POP Up Opens Successfully");
			driver.findElement(EmailAddress).sendKeys("faizan.mamji@arpatech.com");
			TimeUnit.MILLISECONDS.sleep(3000);
			logg.info("Email enters in textbox Successfully");
			driver.findElement(EmailSendBtn).click();
			logg.info("Email Send Button click successfully");
			TimeUnit.MILLISECONDS.sleep(50000);
			logg.info("*********************** PDP Email TestCase Passed ***********************");
		}
		
		catch (Exception ex)
		{
			logg.info("POMProductDetail - Exception!!! - Must have navigation issue to PDP page "+ex.getMessage());
			Assert.fail("Failed in class - POMProductDetail");
		}
	}
}
