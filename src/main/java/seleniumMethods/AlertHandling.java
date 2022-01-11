package seleniumMethods;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertHandling {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver","/Users/shajib/Documents/study/QA/development/java/Exercise/testing/chromedriver");
		driver.manage().window().maximize();
		// Alert Message handling
		
        driver.get("http://demo.guru99.com/test/delete_customer.php");			
                            		
     	      	
        driver.findElement(By.name("cusid")).sendKeys("53920");					
        driver.findElement(By.name("submit")).submit();			
        		
        // Switching to Alert        
        Alert alert = driver.switchTo().alert();		
        		
        // Capturing alert message.    
        String alertMessage= driver.switchTo().alert().getText();		
        		
        // Displaying alert message		
        System.out.println(alertMessage);	
        Thread.sleep(2000);
        
        //click ok
//        driver.switchTo().alert().accept();
        
        //click on cancle button
        driver.switchTo().alert().dismiss();
        		
        // Accepting alert		
        alert.accept();	
        
    	}	
	}

