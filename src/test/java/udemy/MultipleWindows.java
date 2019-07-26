package udemy;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MultipleWindows {
	

	// https://www.softwaretestinghelp.com/selenium-webdriver-commands-selenium-tutorial-17/
	
	
	//getWindowHandles()
	

	
	private static WebDriver driver ;
	
	
	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "/Users/Selenium/chromedriver");
		driver = new ChromeDriver();
	}
	
	
	@Test
	public void switchFrame() {
		driver .get("https://accounts.google.com/signin");
		driver.findElement(By.linkText("Help")).click();
		System.out.println("Birinci Title ------> "+ driver.getTitle());
		
		Set<String> windowsId = driver.getWindowHandles();
		
	Iterator<String> it = windowsId.iterator();
	String firstWindow= it.next();
	String secondWindow = it.next();
	
	driver.switchTo().window(secondWindow);
	
	System.out.println("Ikinci Title ------> "+ driver.getTitle());
	
	driver.switchTo().window(firstWindow);
	
	System.out.println("Tekrar Birinci Title ------> "+ driver.getTitle());

		
	}
	
	
	
	
	
	
	
	
    //@AfterClass
	public void tearDown() throws InterruptedException {
		
		Thread.sleep(5000);

		driver.close();
		driver.quit();
	}


}
