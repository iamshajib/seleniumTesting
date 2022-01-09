package testNGTesting;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleSearchTestNG {
	
	static WebDriver driver;
	
	
	//browser open method
	@BeforeMethod
	public void browserOpen() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"/Users/shajib/Documents/study/QA/development/java/Exercise/Shajib/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}

	//1st case | search keyword
	@Test
	public void search() throws InterruptedException {
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Amex");
		Thread.sleep(3000);
	}
	
	//2nd case | click from the dropdown
	@Test
	public void clickOnResult() throws InterruptedException {
		List<WebElement> searchResults = driver.findElements(By.xpath("//ul[@role='listbox']//li/descendant::div[@class='wM6W7d']"));
		System.out.println(searchResults.size());
		
		for(int i = 0; i < searchResults.size(); i++) {
			String searchIteams = searchResults.get(i).getText();
			if(searchIteams.contains("AmEx")) {
				searchResults.get(i).click();
				break;
			}
		}
		Thread.sleep(1000);
	}

	
	//browser close
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}

}
