import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class EksiSozluk {
	
	//Actions class
	//click(), keyDown(Keys.SHIFT)
	//sendKeys()
	//build()
	//perform()
	
	
	
	private static WebDriver driver ;
	
	
	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "/Users/Selenium/chromedriver");
		driver = new ChromeDriver();
	}
	
	
	@Test
	public void gundemListesi() {
		driver .get("https://eksisozluk.com");
		
		WebElement list = driver.findElement(By.id("partial-index"));
		System.out.println(list.findElements(By.tagName("a")).size());
		int listeSayisi =list.findElements(By.tagName("a")).size();
		
		for(int i=1; i<listeSayisi; i++) {
			
		}
		

		Actions a = new Actions(driver);
		
		
		}
	
	
	
	
	
	
	
	
	@AfterClass
	public void tearDown() throws InterruptedException {
		
		Thread.sleep(5000);

		driver.close();
		driver.quit();
	}

}
