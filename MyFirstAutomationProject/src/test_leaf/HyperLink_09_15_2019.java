package test_leaf;
/**
 * @author Denis
 * Sep 15, 2019
 */

import static driver.Driver.getDriver;
import static common.Common.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HyperLink_09_15_2019 {

	public static void main(String[] args) {
		WebDriver driver = getDriver("chrome");
//		WebDriver driver = getDriver("firefox");
		driver.get("http://testleaf.herokuapp.com/");
		sleep(1);
		driver.findElement(By.linkText("HyperLink")).click();
		sleep(1);
		driver.findElement(By.xpath("(//a[text()='Go to Home Page'])[1]")).click();
		
		String header = driver.findElement(By.tagName("h1")).getText();
		String headerExp="Locators and Selenium Interactions";
		
		if (header.equals(headerExp)) {
			System.out.println("Header validation status: Pass");
		}else {
			System.out.println("Header validation status: Failed");
		}
//		driver.findElement(By.linkText("Button")).click();
		driver.navigate().back();
		sleep(1);

		String link=driver.findElement(By.xpath("//a[text()='Find where am supposed to go without clicking me?']"))
				.getAttribute("href");
		System.out.println("Find where am supposed to go without clicking me? - "+link);
		
//		int x=driver.findElement(By.id("position")).getLocation().getX();
//		int y=driver.findElement(By.id("position")).getLocation().getY();
//		System.out.println("Position: ("+x+","+y+")");
//		
//		String color1 = driver.findElement(By.id("color")).getAttribute("style");
//		String color2 = driver.findElement(By.id("color")).getCssValue("background-color");
//		System.out.println("color: "+color1);
//		System.out.println("color: "+color2);
//		
//		int height = driver.findElement(By.id("size")).getSize().getHeight();
//		int width = driver.findElement(By.id("size")).getSize().getWidth();
//		
//		System.out.println("Height = "+height+", width = "+width );
		
		sleep(1);
		driver.quit();

	}

}
