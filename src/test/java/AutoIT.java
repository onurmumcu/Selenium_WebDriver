import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AutoIT {
	private static WebDriver driver ;
	
	
	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test
	public void deneme() throws IOException, InterruptedException {
		String downloadPath = System.getProperty("user.dir");
		System.out.println(downloadPath);
		driver.get("https://altoconvertpdftojpg.com/");
		driver.findElement(By.cssSelector("[class*='btn--choose']")).click();
		Thread.sleep(3000);
		Runtime.getRuntime().exec("C:\\Users\\Onur\\Desktop\\deneme.exe");
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[class*='medium']")));
		
		driver.findElement(By.cssSelector("button[class*='medium']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Download Now")));
		driver.findElement(By.linkText("Download Now")).click();
		
		File f =new File("C:\\Users\\Onur\\Downloads\\Converted.zip");
		if(f.exists()) {
			System.out.println("Dosya yuklenmis   :) ");
		}else {
			System.out.println("Dosya yuklenmemis :(  ");
		}
	}
	
	

	@AfterClass
	public void tearDown() throws InterruptedException {
		
		Thread.sleep(9000);

		driver.close();
		driver.quit();
	}
	
	
}
