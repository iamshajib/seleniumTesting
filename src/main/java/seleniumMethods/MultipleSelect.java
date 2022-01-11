package seleniumMethods;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MultipleSelect {
	
	public static void main(String[] args) throws InterruptedException {
	WebDriver driver = new ChromeDriver();
	System.setProperty("webdriver.chrome.driver","/Users/shajib/Documents/study/QA/development/java/Exercise/testing/chromedriver");
	driver.manage().window().maximize();
	driver.get("https://www.tutorialspoint.com/selenium/selenium_automation_practice.htm");
	
	//create the object and pass the webelement (xpath) as an argument
	WebElement d = driver.findElement(By.xpath("//select[@name='selenium_commands']"));
	Select s = new Select(d);
	
	//print all the option from the list/dropdown
	List<WebElement> t = s.getOptions();
	System.out.println("Options are: ");
	
	for (WebElement i: t){
        System.out.println(i.getText());
     } 
	Thread.sleep(2000);
	
	//select one by index
	s.selectByIndex(1);
	Thread.sleep(2000);
	
	s.selectByVisibleText("Wait Commands");
    Thread.sleep(1000);
	
	WebElement f = s.getFirstSelectedOption();
	System.out.println("First selected opetion is "+ f.getText());
	
	//deselect
	s.deselectByIndex(1);
	Thread.sleep(2000);
	//deselect all
	s.deselectAll();
	Thread.sleep(3000);
	
	

	driver.close();
	
	}
}
