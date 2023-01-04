package com.nuvolarworks.testbase;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.nuvolarworks.configuration.ReportRuntimeListener;
import com.nuvolarworks.stepdefinition.AddProductToCartStep;
import com.nuvolarworks.utils.TestUtils;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;

public class TestBase extends TestUtils{

	public static WebElement getElement(String locator) throws Exception {
		String locatortype, locatorvalue;
		String[] split = locator.split("==");
		locatortype = split[0];
		locatorvalue = split[1];

		switch (locatortype) {
		case "id":
			return driver.findElement(By.id(locatorvalue));
		case "xpath":
			return driver.findElement(By.xpath(locatorvalue));
		default:
			return driver.findElement(By.xpath(locatorvalue));
		}
	}

	public static List<WebElement> getElements(String locator) throws Exception {
		String locatortype, locatorvalue;
		String[] split = locator.split("==");
		locatortype = split[0];
		locatorvalue = split[1];

		switch (locatortype) {
		case "id":
			return driver.findElements(By.id(locatorvalue));
		case "xpath":
			return driver.findElements(By.xpath(locatorvalue));
		default:
			return driver.findElements(By.xpath(locatorvalue));
		}
	}
	public static By getElementBy(String locator) throws IOException  {
		String locatortype, locatorvalue;
		String[] split = locator.split("==");
		locatortype = split[0];
		locatorvalue = split[1];

		switch (locatortype) {
		case "id":
			return By.id(locatorvalue);
		case "xpath":
			return By.xpath(locatorvalue);
		default:
			return By.xpath(locatorvalue);
		}
	}
	
	public static void sendKeystoElement(String locator,String Value) throws Throwable {
		getElement(locator).clear();
		getElement(locator).sendKeys(Value);
	}
	
	public static void clickelement(String locator) throws Throwable {
		getElement(locator).click();
	}
	
	public void explicitwaitclickable(String locator) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 200);
		wait.until(ExpectedConditions.elementToBeClickable(getElement(locator)));
	}

	public void explicitwaitpresence(String locator) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 200);
		wait.until(ExpectedConditions.presenceOfElementLocated(getElementBy(locator)));
	}
	
	public void explicitwaitvisible(String locator) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 200);
		wait.until(ExpectedConditions.visibilityOf(getElement(locator)));
	}
	public void explicitwaitvisibletolocate(String locator) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 200);
		wait.until(ExpectedConditions.visibilityOfElementLocated((By) getElement(locator)));
	}
	public void explicitwaitelementclickable(String locator) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 150);
		wait.until(ExpectedConditions.elementToBeClickable(getElement(locator)));
	}

	// Thread.sleep method for 8 seconds
	public void driverwait(int ms) throws InterruptedException {
		Thread.sleep(ms);
	}

	// Thread.sleep method for seconds
	public void sleepForSeconds(int seconds) throws InterruptedException {
		try {
			Thread.sleep(seconds * 1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void dropdowncountry(String locator,String searchText) throws Exception {
        
        List<WebElement> p = getElements(locator);
                  //iterate through list
                  for( WebElement i: p){
                   i.getText();
                     }
                  
                  for( WebElement i: p){
                         if (i.getText().equalsIgnoreCase(searchText))
                            {
                                i.click(); // click the desired option
                                break;
                            }
                         }
                  }
	

	public static void scroll() {
	JavascriptExecutor j = (JavascriptExecutor)driver;
	j.executeScript("window.scrollBy(0,200)");
	}
	
	// select the DropDown By Value
	public void selectDropDownBy(String locator,String dropDownValue) throws Exception {
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(dropDownValue);
	}

	public static void windowId(int val) {
		 String windowHandle = driver.getWindowHandle();
		 Set<String> windowHandles = driver.getWindowHandles();
		 List<String> li=new ArrayList();
		 li.addAll( windowHandles );
		 driver.switchTo().window(li.get(val));
	}
	
	public void close() {
		driver.quit();
	}
	
	 public static WebDriver getDriver() {
	        return driver;
	    }

	public static String captureScreenshot() throws IOException {

		File srcFiler = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		byte[] encoded;
		try {
			encoded = Base64.encodeBase64(FileUtils.readFileToByteArray(srcFiler));
			String s = new String(encoded, StandardCharsets.US_ASCII);
			return s;

		} catch (IOException e) {
			e.printStackTrace();

		}
		return null;
	}
	
}
