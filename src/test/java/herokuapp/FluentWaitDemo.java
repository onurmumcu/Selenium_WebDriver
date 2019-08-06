package herokuapp;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FluentWaitDemo {
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

Wait<WebDriver> wait= new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);

WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
	
	public WebElement apply(WebDriver driver) {
		
		if(driver.findElement(By.cssSelector("[id='finish'] h4")).isDisplayed()) {
		
		return driver.findElement(By.cssSelector("[id='finish'] h4"));
		
		}else {
			return null;
		}
	}
	
});

System.out.println(driver.findElement(By.cssSelector("[id='finish'] h4")).isDisplayed());
	}
	
	@AfterClass
	public void tearDown() throws InterruptedException {
			
			Thread.sleep(1000);

			driver.close();
			driver.quit();
		}

}
