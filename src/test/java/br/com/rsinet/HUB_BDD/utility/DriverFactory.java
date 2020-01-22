package br.com.rsinet.HUB_BDD.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverFactory {
	public static WebDriver driver;

	public enum DriverType {
		CHROME, FIREFOX, IE;
	}

	public static WebDriver openBrowser(DriverType tipo, String url) throws Exception {

		switch (tipo) {
		case IE:
			String service = "./drivers/IEDriverServer.exe";
			System.setProperty("webdriver.ie.driver", service);
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
			driver.get(url);
			break;
		case FIREFOX:
			System.setProperty("webdriver.gecko.driver",
					"./drivers/geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get(url);
			break;
		default:
			System.setProperty("webdriver.chromedriver.driver",
					"./drivers/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(url);
			break;

		}

		return driver;
	}

	public static void closeBrowser(WebDriver driver) {

		if (driver != null) {
			driver.close();
			driver.quit();
			driver = null;
		} else {
			driver = null;
		}
	}

}