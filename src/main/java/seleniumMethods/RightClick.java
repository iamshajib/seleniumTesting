package seleniumMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RightClick {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/slider/#colorpicker");
		driver.manage().window().maximize();
		
		//mouse right click on an iFrame but I can do it on regular content oalso
		WebElement element=driver.findElement(By.xpath("//iframe[@src=\"/resources/demos/slider/colorpicker.html\"]"));
		Thread.sleep(2000);
		driver.switchTo().frame(element);
		Thread.sleep(2000);
		
		//clicking action
		Actions action=new Actions(driver);
		WebElement ele=driver.findElement(By.id("swatch"));
		action.contextClick(ele).perform();
		

	}

}
