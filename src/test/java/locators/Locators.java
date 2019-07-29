package locators;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/Selenium/chromedriver"); 
		WebDriver driver= new ChromeDriver();
		driver.get("https://login.salesforce.com/");
		driver.findElement(By.xpath("//*[@id='username']")).sendKeys("hello");
		driver.findElement(By.xpath("//*[@id=\'password\']")).sendKeys("123456");
		driver.findElement(By.xpath("//*[@id=\'Login\']")).click();
	
		

	}

}
