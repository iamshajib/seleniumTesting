package testNGTesting;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Cvs {
	
	static WebDriver driver;
	String browser = "chorme";
	
	
	//Browser open
	@BeforeMethod
	public void browserOpen() {
		
		if(browser.equals("chorme")) {
			System.setProperty("webdriver.chrome.driver", "/Users/shajib/Documents/study/QA/development/java/Exercise/testing/chromedriver");
			driver = new ChromeDriver();
		}
		else if(browser.equals("firefox")) {
			System.setProperty("webdriver.geckodriver.driver", "/Users/shajib/Documents/study/QA/development/java/Exercise/testing/geckodriver");
			driver = new FirefoxDriver();
		}
		else {
			System.out.println("Browser not supported");
		}

		driver.get("https://www.cvs.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
	}
	
	//1st case | Click Shop button
	@Test
	public void shopNav() {
		driver.findElement(By.xpath("//ul[@class='main-nav']//a[contains(text(), 'Shop')]")).click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}
	
	//2nd case | 
	@Test
	public void householdNav() {
		//tried to do find the xpath in different way by myself but always ending up 1 of 2. Had to use ChroPath
		//div[@class='row hidden-for-table-mobile']//a[contains(text(), 'Household')]
		
		//Case is failing. Unable to locate ChroPath generated link is also. Tried Rel & Abs both
		driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/main[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/nav[1]/div[1]/ul[1]/li[4]")).click();
		
	}
	
	
	
	@AfterMethod
	public void browserClose() {
		driver.close();
	}
	

}
