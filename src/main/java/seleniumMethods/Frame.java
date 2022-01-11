package seleniumMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frame {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/selectable/");
		driver.manage().window().maximize();
		
		Thread.sleep(2000);
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src='/resources/demos/selectable/default.html']")));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[ text()='Item 4']")).click();
		Thread.sleep(2000);
		
		driver.switchTo().defaultContent();

	}

}
