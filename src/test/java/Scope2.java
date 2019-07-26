import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//Section 11  Real Time Exercises (end to end Programming)

public class Scope2 {
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		driver.get("http://qaclickacademy.com/practice.php");
		int tagSayisi = driver.findElements(By.tagName("a")).size();
		System.out.println(tagSayisi);
		
		WebElement footer = driver.findElement(By.id("gf-BIG"));
		
		int footerTagSayisi = footer.findElements(By.tagName("a")).size();
		
		System.out.println(footerTagSayisi);
		
		
		
		Thread.sleep(5000);
		driver.close();
	}
	

}
