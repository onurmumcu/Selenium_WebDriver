package udemy;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MouseInteraction{
	
	// https://www.softwaretestinghelp.com/selenium-webdriver-commands-selenium-tutorial-17/
	
	//Actions class
	//click()
	//keyDown(Keys.SHIFT)
	//sendKeys()
	//build()
	//perform()
	//doubleClick() 
	//contextClick()
	
	
	
	private static WebDriver driver ;
	
	
	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "/Users/Selenium/chromedriver");
		driver = new ChromeDriver();
	}
	
	
	@Test
	public void actionDemo() {
		driver .get("https://amazon.com");
		Actions a = new Actions(driver);
		
		
		WebElement move = driver.findElement(By.cssSelector("a[id='nav-link-accountList']"));  
		
		a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("hello").build().perform(); // When use Actions, after locate the elements you need to use build and perform method
		
		
		a.moveToElement(move).contextClick().build().perform();    
	}
	
	
	
	
	
	
	
	
    @AfterClass
	public void tearDown() throws InterruptedException {
		
		Thread.sleep(5000);

		driver.close();
		driver.quit();
	}

}
