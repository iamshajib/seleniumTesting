package seleniumMethods;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButton {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver","/Users/shajib/Documents/study/QA/development/java/Exercise/testing/chromedriver");
		driver.manage().window().maximize();

		driver.get(" http://seleniumpractise.blogspot.com/2016/08/how-to-automate-radio-button-in.html");
		driver.manage().window().maximize();

		List<WebElement> radio = driver.findElements(By.xpath("//input[@name='lang' and @type='radio']"));

		for(int i=0; i<radio.size(); i++) {
			WebElement local_radio=radio.get(i);
			String value=local_radio.getAttribute("value");
			System.out.println("Values from radio buttons are "+value);

			if(value.equalsIgnoreCase("Ruby")) {
				local_radio.click();
			}
		}


	}
}


