package com.amazon.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.amazon.qa.util.WebEventListener;
import com.amazon.qa.util.testUtil;

public class TestBase {

	static String projectPath = System.getProperty("user.dir");
	public 	static WebDriver driver;
	public	static Properties prop;
	static ChromeOptions options;
	
	public static EventFiringWebDriver e_driver;  
	public static WebEventListener eventListener;

	public TestBase() {	

		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("G:\\Selenium\\AmazonTest\\src\\main\\java\\com\\amazon\\qa\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}

	public static void initialization() {
		
		options = new ChromeOptions();
		String browserName =	prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", projectPath + "\\drivers\\chrome\\chromedriver.exe");
			driver = new ChromeDriver();
		}else if (browserName.equals("ff")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\drivers\\gecko\\geckodriver.exe");
			driver = new FirefoxDriver();
		}else if (browserName.equals("ie")) {
			System.setProperty("webdriver.ie.driver", projectPath + "\\drivers\\IE\\IEdriverServer.exe");
			driver = new InternetExplorerDriver();
		}

		e_driver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(testUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(testUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		options.addArguments("enable-automation");
		options.addArguments("--headless");
		options.addArguments("--window-size=1920,1080");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-extensions");
		options.addArguments("--dns-prefetch-disable");
		options.addArguments("--disable-gpu");
		options.setPageLoadStrategy(PageLoadStrategy.NORMAL);    

		driver.get(prop.getProperty("url"));

	}
}
