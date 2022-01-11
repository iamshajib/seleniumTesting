package seleniumMethods;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultipleWindow {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.salesforce.com/au/");
		driver.findElement(By.xpath("//a[@href='/au/form/signup/freetrial-sales/?d=jumbo1-btn-ft']")).click();
		
		Thread.sleep(2000);
		
		Set<String> window_handles=driver.getWindowHandles();//in list you can have duplicate elements but in set you can't have duplicate elements
		System.out.println(window_handles);
		
		
		Iterator<String> iterator=window_handles.iterator();
		String parentwindow=iterator.next();
		
		String childwindow=iterator.next();
		driver.switchTo().window(childwindow);
		Thread.sleep(4000);
		driver.findElement(By.name("UserFirstName")).sendKeys("Mohammad");
		driver.findElement(By.name("UserLastName")).sendKeys("Shajib");
		Thread.sleep(3000);
		driver.switchTo().window(parentwindow);

	}

}
