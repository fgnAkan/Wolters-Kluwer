package utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Driver {
	protected static WebDriver driver;
	protected static WebDriverWait wait;
	protected static BrowserType browserType = BrowserType.chrome;

	public Driver(BrowserType browser) {
		browserType = browser;
	}

	@BeforeClass
	public void getDriver() {
		switch (browserType) {
		case chrome:
			System.setProperty("webdriver.chrome.driver", "src/test/resources/chrome_driver");
			driver = new ChromeDriver();
			break;
		case firefox:
			System.setProperty("webdriver.gecko.driver", "src/test/resources/gecko_driver");
			driver = new FirefoxDriver();
			break;
		default:
			System.setProperty("webdriver.chrome.driver", "src/test/resources/chrome_driver");
			driver = new ChromeDriver();
			break;
		}
		driver.get("https://todomvc.com/examples/angular2/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public void getUrl(String url) {
		driver.get(url);
	}
	
	@AfterClass
	public void closeDriver() {
		driver.quit();
	}

}
