import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class HTTPS {
	public static void main(String[] args) {
		
		
		DesiredCapabilities dc=DesiredCapabilities.chrome();
		
		// 1. yol
		//dc.acceptInsecureCerts();
		
		// 2.yol
		dc.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		dc.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

		ChromeOptions c =new ChromeOptions();
		c.merge(dc);
		
		
		
		System.setProperty("webdriver.chrome.driver", "/Users/Selenium/chromedriver");
		WebDriver driver =new ChromeDriver(c);
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("http://www.cricbuzz.com/live-cricket-scorecard/18970/pak-vs-sl-2nd-t20i-pakistan-v-sri-lanka-in-uae-2017");
		
	
	
	}

}
