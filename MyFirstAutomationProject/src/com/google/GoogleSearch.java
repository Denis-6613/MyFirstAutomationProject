package com.google;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * 
 * @author Denis
 * Simple Google Search
 */
public class GoogleSearch {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver.exe");
		ChromeDriver chromeDriver = new ChromeDriver();
		chromeDriver.get("https://www.google.com/");
		chromeDriver.findElement(By.name("q")).sendKeys("Java tutorials");
		
	}

}
