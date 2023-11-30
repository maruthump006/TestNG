package org.selenium;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

public class NewTest extends BaseClass {
	public static WebDriver driver;
	public String BaseClass ="https://www.google.com/";

	@BeforeMethod
	private void StartDate() {
		Date d = new Date();
		System.out.println("Strat Date and Time : " + d);
	}

	@AfterMethod
	private void EndDate() {
		Date d = new Date();
		System.out.println("End Date and Time : " + d);
	}

	@BeforeClass
	public void launchBrowser1() {
		System.out.println("<-------------LAUNCH BROWSER-------------->");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(BaseClass);
		
	}

	@AfterClass
	private void closeBrower() {
		System.out.println("<--------------CLOSE BROWSER -------------->");
		driver.quit();
	}

	@Test
	private void Filpkart() throws AWTException, IOException {
		driver.findElement(By.id("APjFqb")).sendKeys("filpkart");
		Robot r = new Robot();// to press the virtual keyboard
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		driver.findElement(By.xpath("(//h3[@class='LC20lb MBeuO DKV0Md'])[1]")).click();// to click the FilpKart
		driver.findElement(By.xpath("//span[@role='button']")).click();
		driver.findElement(By.xpath("//input[@class='Pke_EE']")).sendKeys("iphone 14");// click the search bar to enter
																						// the iPhone
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		driver.findElement(By.xpath("//img[@alt='APPLE iPhone 14 (Blue, 128 GB)']")).click();
		Set<String> ChildID = driver.getWindowHandles();
		int i = 1;
		for (String handle : ChildID) {
			if (ChildID.size() == i++) {
				driver.switchTo().window(handle);
			}
		}
		driver.findElement(By.xpath("(//a[@class='_1fGeJ5'])[1]")).click();
		TakesScreenshot ts = (TakesScreenshot) driver;// Take the screenshot
		File screenshotAs = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File("C:\\Users\\MARUTHUMP\\eclipse-workspace\\AutomationGoogle\\screenshot\\filpkart.png");
		FileUtils.copyFile(screenshotAs, destination);
		driver.close();
		driver.switchTo().window(driver.getWindowHandles().iterator().next());
	}
	@Test
	private void faceBook() throws AWTException, IOException {
		driver.get(BaseClass);
		driver.findElement(By.id("APjFqb")).sendKeys("facebook");
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		driver.findElement(By.xpath("(//h3[@class='LC20lb MBeuO DKV0Md'])[1]")).click();
		driver.findElement(By.id("email")).sendKeys("9789173338");
		driver.findElement(By.id("pass")).sendKeys("maruthutheni360");
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		TakesScreenshot ts = (TakesScreenshot) driver;
		File screenshotAs1 = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File("C:\\Users\\MARUTHUMP\\eclipse-workspace\\AutomationGoogle\\screenshot\\faceBook.png");
		FileUtils.copyFile(screenshotAs1, destination);
		
	}

}
