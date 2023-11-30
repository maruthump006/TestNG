package org.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass  {
	public static WebDriver driver;// Create a driver

	public static void launchBrowser() { // launch the browse configuration
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	public static void WindowsMinimize() { // windows maximize
		driver.manage().window().maximize();

	}

	public static void LaunchURL(String url) { // get URL
		driver.get(url);

	}

	public static void currenturl() {  //get the current URL
		String currentUrl = driver.getCurrentUrl();
		System.out.println("CURRENT URL : " + currentUrl);
	}

	public static void pageTitle() { // To get the page Title 
		String title = driver.getTitle();
		System.out.println(title);
	}

	public static void closedriver() { // close the drive
		driver.close();
	}

	public static void close() {// close all browser
		driver.quit();
	}

}
