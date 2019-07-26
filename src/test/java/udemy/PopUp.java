package udemy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PopUp {
	
	///  BE Careful window authentication pop up and javascript alert different 
	
	
	private static WebDriver driver ;

	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "/Users/Selenium/chromedriver");
		driver = new ChromeDriver();
		//driver.get("https://the-internet.herokuapp.com");		//admin:admin@
		driver.get("admin:admin@https://the-internet.herokuapp.com/basic_auth");
	}
	
	@Test
	public void deneme() {
		//driver.findElement(By.linkText("Basic Auth")).click();
		
		
	}
	
	//@AfterClass
	public void tearDown() throws InterruptedException {
			
			Thread.sleep(9000);

			driver.close();
			driver.quit();
		}

}
