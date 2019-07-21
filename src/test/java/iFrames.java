import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


//dragAndDrop()
//switchTo()
//switchTo().defaultContent()



public class iFrames {
	
	private static WebDriver driver ;
	
	
	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "/Users/Selenium/chromedriver");
		driver = new ChromeDriver();
	}
	
	
	@Test
	public void dragAndDrop() {
		driver .get("http://jqueryui.com/droppable/");
		
		System.out.println("Toplam iFrame sayisi = "+ driver.findElements(By.tagName("iframe")).size());
		
		
		//driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame"))); 
		//driver.findElement(By.id("draggable")).click();
		
		
		driver.switchTo().frame(0);
	

		
		
		
		Actions a = new Actions(driver);
	WebElement source = driver.findElement(By.id("draggable"));
	WebElement target = driver.findElement(By.id("droppable"));
		
		a.dragAndDrop(source, target).build().perform();

		
		driver.switchTo().defaultContent();
		
			
	}
	
	


	
	@AfterClass
	public void tearDown() throws InterruptedException {
		
		Thread.sleep(9000);

		driver.close();
		driver.quit();
	}

}
