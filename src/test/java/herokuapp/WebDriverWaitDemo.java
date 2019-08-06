package herokuapp;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WebDriverWaitDemo {
	private static WebDriver driver ;

	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");		
	}
	
	@Test
	public void deneme() {
driver.findElement(By.xpath("//*[@id=\'start\']/button")).click();

WebDriverWait wait = new WebDriverWait(driver, 10);
wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("[id='finish'] h4"))));

System.out.println(driver.findElement(By.cssSelector("[id='finish'] h4")).isDisplayed());
	}
	
	@AfterClass
	public void tearDown() throws InterruptedException {
			
			Thread.sleep(1000);

			driver.close();
			driver.quit();
		}

}


