package udemy;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Calendar {
	
	private static WebDriver driver ;
	
	
	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "/Users/Selenium/chromedriver");
		driver = new ChromeDriver();
	}
	
	
	@Test
	public void findDate() {
		driver .get("https://www.path2usa.com/travel-companions");
		driver.findElement(By.xpath(".//*[@id='travel_date']")).click();
		
		while(!driver.findElement(By.cssSelector("[class='datepicker-days'] [class='datepicker-switch']")).getText().contains("May"))	
				{
			
			driver.findElement(By.cssSelector("[class='datepicker-days'] th[class='next']")).click();
			
		}
		
		

		List<WebElement> dates = driver.findElements(By.className("day"));
		
		int count =driver.findElements(By.className("day")).size();
		
		for(int i=0; i<count; i++) {
			
			String text = driver.findElements(By.className("day")).get(i).getText();
			//System.out.println(text);
			if(text.equalsIgnoreCase("23")) {
				
				driver.findElements(By.className("day")).get(i).click();
				break;
			}
			
			
			
			
		}
		
	}
	
	


	
	//@AfterClass
	public void tearDown() throws InterruptedException {
		
		Thread.sleep(9000);

		driver.close();
		driver.quit();
	}


}
