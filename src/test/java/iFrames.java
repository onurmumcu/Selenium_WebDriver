import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class iFrames {
	
	private static WebDriver driver ;
	
	
	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "/Users/Selenium/chromedriver");
		driver = new ChromeDriver();
	}
	
	
	@Test
	public void actionDemo() {
		driver .get("http://jqueryui.com/droppable/");
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame"))); 
		driver.findElement(By.id("draggable")).click();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	


	
	//@AfterClass
	public void tearDown() throws InterruptedException {
		
		Thread.sleep(5000);

		driver.close();
		driver.quit();
	}

}
