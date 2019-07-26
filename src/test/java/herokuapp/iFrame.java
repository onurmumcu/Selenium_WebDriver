package herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class iFrame {
	private static WebDriver driver ;

	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "/Users/Selenium/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/iframe");		
	}
	
	@Test
	public void deneme() {
		int iFrameSayisi = driver.findElements(By.tagName("iframe")).size();
		System.out.println(iFrameSayisi);
		
		driver.switchTo().frame(0);
		driver.findElement(By.id("tinymce")).clear();
		
		
		
		
	}
	
	@AfterClass
	public void tearDown() throws InterruptedException {
			
			Thread.sleep(9000);

			driver.close();
			driver.quit();
		}
}
