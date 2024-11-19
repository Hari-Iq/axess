package org.BaseClass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class SuperClass {
	
	public static WebDriver driver;
	
	public static void toGetChrome() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	public static void fireboxBrowser() {
		driver = new FirefoxDriver();
	}
		
	public static void close() {
		driver.close();
	}
	
	public static void launchUrl(String url) {
		driver.get(url);
	}
	
	public static void fillTextBox(WebElement ele, String st) {
		ele.sendKeys(st);
	}
	public static void click(WebElement ele) {
		ele.click();
	}
	
	public static void implicityWait(long time) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
	}
	
	public static void toGetDate() {
		Date d = new Date();
		System.out.println(d);
	}
	
	public static void navigateTo(String url) {
		driver.navigate().to(url);
	}
	public static void getScrnShot(String name) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		
		File screenshotAs = ts.getScreenshotAs(OutputType.FILE);
		File file = new File("C:\\Users\\Hari\\eclipse-workspace\\axt\\Screenshot"+name+".png");
		FileUtils.copyFile(screenshotAs, file);
	}
	
	public static void clickElementWithJS(WebElement element) {
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].click();", element);
	}

	public static void sendKeysJs(WebElement element,String name) {
		JavascriptExecutor keys = (JavascriptExecutor)driver;
		keys.executeScript("arguments[0].value='"+name+"';", element);
	}
	public static void pressEnter() throws AWTException {
	    Robot ro = new Robot();
	    ro.keyPress(KeyEvent.VK_ENTER);
	    ro.keyRelease(KeyEvent.VK_ENTER);
	}
	public static void dragDrop(WebElement ele1,WebElement ele2) {
		Actions acc = new Actions(driver);
		acc.dragAndDrop(ele1, ele2);
	}
	
	public static void  movetoElement(WebElement menu) {
		Actions hover = new Actions(driver);
		hover.moveToElement(menu);
		hover.perform();
	}
	
		
	
	}


