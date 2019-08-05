package udemy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RadioButtons {
	
	private static WebDriver driver;

	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "/Users/Selenium/chromedriver");
		driver = new ChromeDriver();
		driver.get("http://www.echoecho.com/htmlforms10.htm");
		driver.manage().window().maximize();
	
	}
	
	@Test
	public void deneme() throws InterruptedException {
		
		Thread.sleep(2000);

		//driver.findElement(By.cssSelector("input[value='Milk']")).click();
		driver.findElement(By.xpath("//input[contains(@value,'Milk')]")).click();
	}
	
	@AfterClass
	public void tearDown() throws InterruptedException {

		Thread.sleep(5000);

		driver.close();
		driver.quit();
	}

}
