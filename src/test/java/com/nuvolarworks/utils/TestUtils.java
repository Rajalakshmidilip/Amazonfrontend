package com.nuvolarworks.utils;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.nuvolarworks.configuration.ReportRuntimeListener;
import io.github.bonigarcia.wdm.WebDriverManager;


public class TestUtils extends ReportRuntimeListener{
	
	public static WebDriver driver;
	public WebDriver selectBrowser(String url) throws Throwable
	{
		String browser = "chrome";
		System.out.println("Inside Select Browser");
		
		if (browser.equalsIgnoreCase("chrome")) {
			System.out.println("selecting chrome test");
			WebDriverManager.chromedriver().setup();
		    driver = new ChromeDriver();
		    driver.get(url);
		    driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		    driver.manage().window().maximize();
			return driver;
		}
		
		else if (browser.equalsIgnoreCase("firefox")) {
			System.out.println("Test Firefox method");
			WebDriverManager.firefoxdriver().setup();
		    driver = new FirefoxDriver();
		    driver.get(url);
		    driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		    driver.manage().window().maximize();
			return driver;
		}
		return null;
		

	}
}
