package seleniumMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Select;

public class DropDown {
	
	//Select by using SELECT class 
	//automatically select the value from the dropdown using selenium
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/shajib/Documents/study/QA/development/java/Exercise/testing/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.globalsqa.com/demo-site/select-dropdown-menu/");
		driver.manage().window().maximize();
		
		
		//create an object of selenium build in select class to use its objects
		//in this select we have to provide the argument as a webelement otherwise get error
		WebElement dropDown = driver.findElement(By.xpath("//*[@id=\"post-2646\"]/div[2]/div/div/div/p/select"));
		Select select = new Select(dropDown);

		//using buildin methods from select class
		select.selectByValue("BGD");
		Thread.sleep(3000);
		select.selectByVisibleText("Algeria");
//		select.selectByIndex(1);
		
		driver.close();
		
	}
	
	

}
