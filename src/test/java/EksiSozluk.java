import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
	
	
	//*[@id="partial-index"]/div[1]/h2
	
	@Test
	public void gundemListesi() throws InterruptedException {
		driver .get("https://eksisozluk.com");
		
		WebElement gundemFooter = driver.findElement(By.id("index-section"));
		System.out.println("Toplam Gundem Sayisi --> "+gundemFooter.findElements(By.tagName("a")).size());

		int gundemLinkSayisi =gundemFooter.findElements(By.tagName("a")).size();
		
		List<WebElement> linkler = gundemFooter.findElements(By.tagName("a"));
		
		
		for(int i=0; i<gundemLinkSayisi; i++) {
		
			
     		WebElement link1 = linkler.get(i);
			System.out.println((i+1)+". "+link1.getText());
			
//			WebDriverWait d=new WebDriverWait(driver,20);
//			d.until(ExpectedConditions.elementToBeClickable(By.id("index-section")));
//			
//			
//			System.out.println(linkler.get(i).getTagName());
//			
//			//System.out.println((i+1)+". defa Yuklendi ve beklendi");
//			
//			//gundemFooter.findElements(By.tagName("a")).get(i).	click();
//			
//			//Thread.sleep(4000);
//			//System.out.println(gundemFooter.findElements(By.tagName("a")).get(i).getText());
//			
//			
//			
//		
//			//Thread.sleep(5000L);
//
//			//driver.findElement(By.xpath("//div[@id='resultsContainer']/section/article[1]")).click();
//			   
//			
//			
	}
		}
	
	
	
	
	
	
	
	
	//AfterClass
	public void tearDown() throws InterruptedException {
		
		Thread.sleep(5000);

		driver.close();
		driver.quit();
	}

}
