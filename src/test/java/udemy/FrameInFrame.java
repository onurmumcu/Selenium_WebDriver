package udemy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FrameInFrame {
	
private static WebDriver driver ;

@BeforeClass
public void setUp() {
	System.setProperty("webdriver.chrome.driver", "/Users/Selenium/chromedriver");
	driver = new ChromeDriver();
	driver.get("http://qaclickacademy.com/practice.php");
	
}




public int findFrameNumber (WebDriver driver, By by) {     //By.className("container"
	
	int i ;
	
	int frameCount = driver.findElements(By.tagName("iframe")).size();
	System.out.println("iframe sayisi --> "+frameCount);
	
	
	
	for( i=0; i<frameCount; i++) {     // iterate through the loop 
		driver.switchTo().frame(i) ;    // to find iframe
		
		int count = driver.findElements(by).size();
		
		if(count>0) {        // to check if the element is displayed
			//driver.findElement(by).click();
			System.out.println("iframe "+(i+1)+"'in icinde buldum ");
			break;
		}
		else {
			
			System.out.println("continue looping");
			
		}
		
	}
	driver.switchTo().defaultContent();
	return i;
	
	
}
	

	
	

	
	
	@Test
	public void linksOnFrames() throws InterruptedException {
		
		int number = findFrameNumber(driver, By.xpath("//*[@id=\'homepage\']/header/div[2]/div/nav/ul/li[2]/a"));
		//System.out.println("Sayiyi veriyorum "+number);
		
//		WebDriverWait b = new WebDriverWait(driver, 5);	
		driver.switchTo().frame(number);
	
		driver.findElement(By.xpath("//*[@id=\'homepage\']/header/div[2]/div/nav/ul/li[2]/a")).click();
	

		
		int number2 = findFrameNumber(driver, By.xpath("//*[@id=\'links\']/nav/ul/li[1]/a"));
		//System.out.println("Sayiyi veriyorum "+number);
		driver.switchTo().frame(number2);
		driver.findElement(By.xpath("//*[@id=\'links\']/nav/ul/li[1]/a")).click();
		
		

		
	}
	
	
	
	
	
	
	
	
	
	 @AfterClass
	 public void tearDown() throws InterruptedException {
			
			Thread.sleep(5000);

			driver.close();
			driver.quit();
		}

}
