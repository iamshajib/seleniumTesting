package seleniumMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WithoutSendKey {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		
		//create an interface called JavaScript Executor
		//do type casting
		WebElement key=driver.findElement(By.xpath("//input[@name=\"q\"]"));
		
		JavascriptExecutor jse= (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].value='amazon'", key);
		

	}

}
