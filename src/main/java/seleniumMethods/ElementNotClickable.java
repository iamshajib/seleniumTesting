package seleniumMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementNotClickable {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://ksrtc.in/oprs-web/");
		//just maximize the window
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[@class='btn btn-primary btn-lg btn-block btn-booking']")).click();

	}

}
