package Register.Register;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Register {
	public String baseUrl = "http://demo.guru99.com/test/newtours";
	String driverPath = "C:\\Program Files\\Java\\chromedriver.exe";
	public WebDriver driver;
	@BeforeSuite
	  public void launchBrowser()
	  {
		 System.out.println("Launching Chrome Browser");
		  System.setProperty("webdriver.chrome.driver",driverPath);
		  driver = new ChromeDriver();
		  driver.get(baseUrl);
	  }
	@BeforeTest
	public void gotoregister()
		{
		System.out.println("Go to Register ");
		driver.findElement(By.linkText("REGISTER")).click();
	    }
	@Test
	public void putdata() throws InterruptedException
	{
		   driver.findElement(By.xpath("//input[@name=\"firstName\"]")).sendKeys("Rinku");
		   driver.findElement(By.xpath("//input[@name=\"lastName\"]")).sendKeys("Jangid");
		   driver.findElement(By.xpath("//input[@name=\"phone\"]")).sendKeys("8850924815");
		   driver.findElement(By.xpath("//input[@name=\"userName\"]")).sendKeys("RinkuJangid");
		   driver.findElement(By.xpath("//input[@name=\"address1\"]")).sendKeys("Khar");
		   driver.findElement(By.xpath("//input[@name=\"city\"]")).sendKeys("Mumbai");
		   driver.findElement(By.xpath("//input[@name=\"state\"]")).sendKeys("Maharashtra");
		   driver.findElement(By.xpath("//input[@name=\"postalCode\"]")).sendKeys("400051");
		   Select config = new Select(driver.findElement(By.xpath("//select[@name=\"country\"]")));
		   config.selectByVisibleText("ALBANIA"); //or we can use selectByIndex() i.e start from  0 or selectByValue()
		   driver.findElement(By.xpath("//input[@name=\"email\"]")).sendKeys("RinkuJangid");
		   driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("rinku");
		   driver.findElement(By.xpath("//input[@name=\"confirmPassword\"]")).sendKeys("rinku");
		   
		   Thread.sleep(2000);
	}
	@AfterTest
	public void submit()
	{
		driver.findElement(By.xpath("//input[@name=\"submit\"]")).click();
	}
	@AfterSuite
	public void close() 
	{
	driver.quit();
    }
}
