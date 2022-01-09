package testNGTesting;

import java.util.List;
import java.util.concurrent.TimeUnit;

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
	
	//3rd case | click on the first content from the search result not the AD
	
	/* FAILING: <NoSuchElementException: no such element: Unable to locate element:
	 * {"method":"xpath","selector":"//h3[@class='LC20lb MBeuO DKV0Md']> 
	 * This locator works if I "run as" Java without TestNG. After creating it a separate 
	 * test case the xpath is not working*/
	
	@Test
	public void clickOnLink() throws InterruptedException {
		driver.findElement(By.xpath("//h3[@class='LC20lb MBeuO DKV0Md']")).click();
		Thread.sleep(1000);
	}

	//4th case | get page title and page URL
	@Test
	public void getTitleUrl() {
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
	}
	
	//5th case | print how many links are available on this page and print their titles
	@Test
	public void linkSizeAndTitle() {
		List<WebElement> links = driver.findElements(By.tagName("a"));
		int linksCount = links.size();
		
		System.out.println("Total number of links in this page is " + linksCount);
		
		for(int i = 1; i < linksCount; i++) {
			WebElement storage = links.get(i);
			String linksText = storage.getText();
			System.out.println(linksText);
		}
	}
	
	//browser close
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}

}
