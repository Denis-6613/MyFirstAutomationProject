package newtours;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

//import static driver.Driver.getDriver;

public class Cruises_09_12_2019 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
//		WebDriver driver =  getDriver("chrome");
		driver.get("http://newtours.demoaut.com/");
		
//		driver.findElement(By.linkText("Cruises")).click();
		driver.findElement(By.xpath("(//a)[5]")).click();
		
		String sCurURL=driver.getCurrentUrl();
		String sExpURL="http://newtours.demoaut.com/mercurycruise.php";
		String sCurTitle=driver.getTitle();
		String sExpTitle="Cruises: Mercury Tours";
		
		if (sCurURL.contains(sExpURL)) {
			System.out.println("URL is fine");
		}else {
			System.out.println("URL is wrong");
		}
		
		if (sCurTitle.equals(sExpTitle)) {
			System.out.println("Title is fine");
		}else {
			System.out.println("Title is wrong");
		}
		sleep(2);
		driver.quit();

	}
	
	public static void sleep (int seconds) {
		try {
			Thread.sleep(seconds*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
