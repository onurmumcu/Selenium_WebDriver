package utilities;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



	
	public class Driver {
		

		
		private Driver() {}
		
		private static WebDriver driver;

		public static WebDriver getDriver(String os) {
			
			
				switch (os) {
				case "win":
					
					System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
					driver = new ChromeDriver();
					break;

				case "mac":
					
					System.setProperty("webdriver.chrome.driver", "/Users/Selenium/chromedriver");
					driver = new ChromeDriver();
					break;
					
					
			
			}
			return driver;
		}

		
	}


