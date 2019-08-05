package miscellaneous;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TableSort {
	private static WebDriver driver;

	@BeforeClass
	public void setUp() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/Selenium/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		Thread.sleep(1500);
		
		
	}

	@Test
	public void sortColumn() throws InterruptedException {

		driver.findElement(By.cssSelector("tr th:nth-child(2)")).click();
		Thread.sleep(1500);
		driver.findElement(By.cssSelector("tr th:nth-child(2)")).click();

		List<WebElement> firstCoList = driver.findElements(By.cssSelector("tr td:nth-child(2)"));

		ArrayList<String> original = new ArrayList<String>();

		for (int i = 0; i < firstCoList.size(); i++) {
			original.add(firstCoList.get(i).getText());
		}

		ArrayList<String> copied = new ArrayList<>();
		for (int i = 0; i < original.size(); i++) {
			copied.add(original.get(i));
		}

		System.out.println("===============   Original list    ===============");
		for (String s : original) {
			System.out.println(s);
		}

		Collections.sort(copied);
//Collections.reverse(copied);
		System.out.println("=================== copied list  ==================");
		for (String s : copied) {
			System.out.println(s);
		}

//Assert.assertTrue(original.equals(copied));

	}

	@AfterClass
	public void tearDown() throws InterruptedException {

		Thread.sleep(5000);

		driver.close();
		driver.quit();
	}

}
