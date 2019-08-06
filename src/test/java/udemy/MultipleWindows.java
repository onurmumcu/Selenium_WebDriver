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
	

	
	//private static WebDriver driver ;
	WebDriver driver ;
	

	
	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "/Users/Selenium/chromedriver");
		driver = new ChromeDriver();
		
		driver .get("https://accounts.google.com/signin");
		driver.findElement(By.linkText("Help")).click();
	}
	
	public void switchToWindowByTitle(String title) {
		Set<String> windows = driver.getWindowHandles();
		//System.out.println("Amount of windows that are currently present :: "+windows.size());
		for(String window: windows) {
			driver.switchTo().window(window);
			if(driver.getTitle().startsWith(title)||driver.getTitle().equalsIgnoreCase(title)){
				break;
			}else {
				continue;
			}
		}
	}
	
	@Test
	public void deneme() {
		switchToWindowByTitle("Sign");
		System.out.println(driver.getTitle());
		
		switchToWindowByTitle("Google");
		System.out.println(driver.getTitle());
		
		switchToWindowByTitle("Sign");
		System.out.println(driver.getTitle());
		
	}
	
	
	
//	@Test
//	public void switchFrame() {
//		driver .get("https://accounts.google.com/signin");
//		driver.findElement(By.linkText("Help")).click();
//		System.out.println("Birinci Title ------> "+ driver.getTitle());
//		
//		Set<String> windowsId = driver.getWindowHandles();
//		
//	Iterator<String> it = windowsId.iterator();
//	String firstWindow= it.next();
//	String secondWindow = it.next();
//	
//	driver.switchTo().window(secondWindow);
//	
//	System.out.println("Ikinci Title ------> "+ driver.getTitle());
//	
//	driver.switchTo().window(firstWindow);
//	
//	System.out.println("Tekrar Birinci Title ------> "+ driver.getTitle());
//
//		
//	}
	
	
	
	
	
	
	
	
    //@AfterClass
	public void tearDown() throws InterruptedException {
		
		Thread.sleep(5000);

		driver.close();
		driver.quit();
	}


}
