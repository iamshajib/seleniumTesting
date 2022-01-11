package seleniumMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		
		
		
		
		Thread.sleep(2000);
		WebElement frame=driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(frame);
		Thread.sleep(2000);
		
		Actions action=new Actions(driver);
		
		WebElement drag=driver.findElement(By.xpath("//p[text()='Drag me to my target']"));
		WebElement drop=driver.findElement(By.xpath("//p[text()='Drop here']"));
		
		action.dragAndDrop(drag, drop).perform();
		

	}

}
