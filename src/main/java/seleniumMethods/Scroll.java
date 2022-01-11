package seleniumMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scroll {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.cvs.com");
		driver.manage().window().maximize();

		//use javascript executor
		JavascriptExecutor jse= (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0, 3000)", "");

		//scrolling page till we find element
		WebElement scroll=driver.findElement(By.xpath("//a[text()='Shop now']"));
		jse.executeScript("arguments[0].scrollIntoView();",scroll);

		//scroll page till bottom 
		//js.executeScript("window.scrollTo(0,document.body.scrollHeight)");

	}

}
