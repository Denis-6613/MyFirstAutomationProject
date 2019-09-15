package test_leaf;

import static driver.Driver.getDriver;
import static common.Common.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Button_09_15_2019 {

	public static void main(String[] args) {
		WebDriver driver = getDriver("chrome");
//		WebDriver driver = getDriver("firefox");
		driver.get("http://testleaf.herokuapp.com/");
		
		driver.findElement(By.linkText("Button")).click();
		
		driver.findElement(By.id("home")).click();
		
		String header = driver.findElement(By.tagName("h1")).getText();
		String headerExp="Locators and Selenium Interactions";
		
		if (header.equals(headerExp)) {
			System.out.println("Header validation status: Pass");
		}else {
			System.out.println("Header validation status: Failed");
		}
//		driver.findElement(By.linkText("Button")).click();
		driver.navigate().back();
		
		int x=driver.findElement(By.id("position")).getLocation().getX();
		int y=driver.findElement(By.id("position")).getLocation().getY();
		System.out.println("Position: ("+x+","+y+")");
		
		String color1 = driver.findElement(By.id("color")).getAttribute("style");
		String color2 = driver.findElement(By.id("color")).getCssValue("background-color");
		System.out.println("color: "+color1);
		System.out.println("color: "+color2);
		
		int height = driver.findElement(By.id("size")).getSize().getHeight();
		int width = driver.findElement(By.id("size")).getSize().getWidth();
		
		System.out.println("Height = "+height+", width = "+width );
		
		sleep(2);
		driver.quit();

	}

}
