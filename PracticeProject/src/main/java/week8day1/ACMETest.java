package week8day1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ACMETest {
	@Test
public void getACMETextCountry() {
	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	ChromeDriver driver= new ChromeDriver();
	driver.get("https://acme-test.uipath.com/account/login");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.findElementById("email").sendKeys("kumar.testleaf@gmail.com",Keys.TAB);
	driver.findElementById("password").sendKeys("leaf@12");
	driver.findElementById("buttonLogin").click();
	WebElement vendor = driver.findElementByXPath("(//button[contains(@class,'btn-default')]/i)[5]");
	Actions builder=new Actions(driver);
	builder.moveToElement(vendor).clickAndHold().perform();
	driver.findElementByLinkText("Search for Vendor").click();
	driver.findElementById("vendorName").sendKeys("Blue Lagoon");
	driver.findElementById("buttonSearch").click();
	
	//Finding the Country for the searched Vendor  
	WebElement table = driver.findElementByXPath("//table[@class='table']");
	List<WebElement> allrows = table.findElements(By.tagName("tr"));
	WebElement fetchRow = allrows.get(1);
	List<WebElement> fetchCols = fetchRow.findElements(By.tagName("td"));
	int colsSize = fetchCols.size();
	System.out.println(fetchCols.get(colsSize-1).getText());
	driver.findElementByLinkText("Log Out").click();
	driver.close();
}
}
