package work;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchEngine {
	public static void main(String[] args) throws InterruptedException {
		
		//open the browser 
		WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver",
				"/Users/shajib/Documents/study/QA/development/java/Exercise/Shajib/chromedriver");
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		Thread.sleep(1000);
		
		//search the keyword on Google 
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Amex");
		Thread.sleep(1000);
		
		//iterating through the list and click on the desired one
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
		
		//clicking on the first content from the search result not the ad. 
		//is using this class as xPath ok? Will Google change it in near future?
		driver.findElement(By.xpath("//h3[@class='LC20lb MBeuO DKV0Md']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//get page title and page URL
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		
		//print how many links are available on this page and their titles
		List<WebElement> links = driver.findElements(By.tagName("a"));
		int linksCount = links.size();
		
		System.out.println("Total number of links in this page is " + linksCount);
		
		for(int i = 1; i < linksCount; i++) {
			WebElement storage = links.get(i);
			String linksText = storage.getText();
			System.out.println(linksText);
		}

		//print all the broken links available on the web page
		//yet to do
		
		//closing the browser after the action is done
		driver.quit();
	
		
	}

	
	

}
