package udemy;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AutoSuggestive {
	
	
private static WebDriver driver ;

@BeforeClass
public void setUp() {
	System.setProperty("webdriver.chrome.driver", "/Users/Selenium/chromedriver");
	driver = new ChromeDriver();
	driver.get("https://www.ksrtc.in");
	
}

@Test
public void dropDown() {
	driver.findElement(By.id("fromPlaceName")).sendKeys("BEN");
	driver.findElement(By.id("fromPlaceName")).sendKeys(Keys.DOWN);
	//driver.findElement(By.id("fromPlaceName")).sendKeys(Keys.DOWN);
   //System.out.println(driver.findElement(By.id("fromPlaceName")).getText());	
	
	JavascriptExecutor js = (JavascriptExecutor)driver;
	
	String script = "return document.getElementById(\"fromPlaceName\").value;";
    String text = (String) js.executeScript(script);
//System.out.println(text);

    int i = 1;

while(!text.equalsIgnoreCase("BENGALURU INTERNATION AIRPORT")) {
      i++;

	js = (JavascriptExecutor)driver;
	
    text = (String) js.executeScript(script);
    //System.out.println(text);

	
	driver.findElement(By.id("fromPlaceName")).sendKeys(Keys.DOWN);
	
	if(i>10) {
		break;
	}
	
}

if(i>10) {
	System.out.println("maalesef bulamadim");
}
else {
	System.out.println("elementi buldum");
	System.out.println(text);
}



}




@AfterClass
public void tearDown() throws InterruptedException {
		
		Thread.sleep(9000);

		driver.close();
		driver.quit();
	}

}
