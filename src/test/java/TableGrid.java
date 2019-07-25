import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TableGrid {
	
	private static WebDriver driver ;

	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "/Users/Selenium/chromedriver");
		driver = new ChromeDriver();
		driver.get("http://www.cricbuzz.com/live-cricket-scorecard/18970/pak-vs-sl-2nd-t20i-pakistan-v-sri-lanka-in-uae-2017");
			
	}
	
	@Test
	public void tableBul() {
		int sum =0;
		WebElement table = driver.findElement(By.cssSelector("div[class='cb-col cb-col-100 cb-ltst-wgt-hdr']"));
		int rowCount= table.findElements(By.cssSelector("cb-col cb-col-100 cb-scrd-itms")).size();
		int count= table.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)")).size();

		//System.out.println(count);
		for(int i=0; i<count-2; i++) {
			String value = table.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)")).get(i).getText();
			int valueInt = Integer.parseInt(value);
			sum = sum+valueInt;
			
		}
		String extras=driver.findElement(By.xpath("//div[text()='Extras']/following-sibling::div")).getText();
		int extrasInt = Integer.parseInt(extras);
		
	    int totalSumValue = extrasInt + sum;
		System.out.println(totalSumValue);
		
		String actualTotal = driver.findElement(By.xpath("//div[text()='Total']/following-sibling::div")).getText();
		int actualTotalValue = Integer.parseInt(actualTotal);
		if(totalSumValue==actualTotalValue) {
			
			System.out.println("islem dogru :) ");
			
		}else {
			System.out.println("islem yanlis :(  ");
		}
		
	}
	
	
	
	@AfterClass
	public void tearDown() throws InterruptedException {
			
			Thread.sleep(9000);

			driver.close();
			driver.quit();
		}

}
