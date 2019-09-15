package newtours;
/**
 * @author Denis
 * New Tours automation demo
 */

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewTours {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://newtours.demoaut.com/");
//		chromeDriver.findElement(By.name("q")).sendKeys("Java tutorials");
		driver.findElement(By.name("userName")).sendKeys("in");
		driver.findElement(By.name("password")).sendKeys("password");
		driver.findElement(By.name("login")).click();
		
		Thread.sleep(3000);
		driver.quit();

	}

}
