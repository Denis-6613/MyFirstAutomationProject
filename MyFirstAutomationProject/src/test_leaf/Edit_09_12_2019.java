package test_leaf;

import static driver.Driver.*;
import static common.Common.*;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Edit_09_12_2019 {

	public static void main(String[] args) {
		String email="some_email@gmail.com";
		
//		WebDriver driver = getDriver("chrome");
		WebDriver driver = getDriver("firefox");
		driver.get("http://testleaf.herokuapp.com/");
		
//		driver.findElementByXPath("(//a)[2]").click();
		driver.findElement(By.linkText("Edit")).click();
		
		String header = driver.findElement(By.tagName("h1")).getText();
		String headerExp="Work with Edit Fields";
		
//		System.out.println(header);
		
		if (header.equals(headerExp)) {
			System.out.println("Header validation is passed");
		}else {
			System.out.println("Header validation is failed");
		}
		
		String sCurTitle=driver.getTitle();
		String sExpTitle="TestLeaf - Interact with Edit Fields";
		
		if (sCurTitle.equals(sExpTitle)) {
			System.out.println("Title is fine");
		}else {
			System.out.println("Title is wrong");
		}
		sleep(2);
		driver.findElement(By.id("email")).sendKeys(email);
		sleep(2);
		driver.findElement(By.cssSelector("[value='Append ']")).sendKeys(" appending text");
		sleep(2);
		System.out.println(driver.findElement(By.name("username")).getAttribute("value"));
		driver.findElement(By.xpath("(//input[@name='username'])[2]")).clear();
		sleep(2);
		boolean isDisabled = !driver.findElement(By.cssSelector("[disabled='true']")).isEnabled();
		System.out.println("Input is disabled: "+isDisabled);
//		driver.findElement(By.xpath("(//input[@type='text'])[5]")).getAttribute("disable");
		
//		(//input[@name='username'])[2]
//		(//input[@type='text'])[5]
//		System.out.println(driver.findElement(By.cssSelector("[value='Append ']")).getAttribute("value"));
		
		
		sleep(2);
		driver.quit();
	}

}
