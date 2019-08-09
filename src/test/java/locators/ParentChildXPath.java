package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ParentChildXPath {
WebDriver driver ;
	

	
	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "/Users/Selenium/chromedriver");
		driver = new ChromeDriver();
		
		driver .get("https://google.com");
		
	}
	
	@Test
	public void deneme() {
		
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[4]/div[1]/div[1]/a[1]")).click();
		//driver.findElement(By.xpath("//div[@class='FPdoLc VlcLAe']//input[@name='btnK']")).click();
	}

}
