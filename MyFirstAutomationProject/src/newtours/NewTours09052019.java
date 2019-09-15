package newtours;
/**
 * @author Denis
 * New Tours automation demo
 */

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class NewTours09052019 {
	
	private static String generateRandomString(int length) {

		final String lowerCase = "abcdefghijklmnopqrstuvwxyz";// created by method "generateASCIIString"
		final String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";// created by method "generateASCIIString"
		final String numbers = "0123456789";// created by method "generateASCIIString"
		final String specChars = "!#$%&'*+-/=?^_`{|}~";
		String permissibleChars = lowerCase + upperCase + numbers + specChars;

		String str = "";
		for (int i = 0; i < length; i++) {
			int index=(int) (Math.random() *permissibleChars.length());
			char ch = permissibleChars.charAt(index);
			str += ch;
		}
		return str;
	}

	private static String generateRandomEmail(int length) {

		final String[] domainArr = { "aol.com", "att.net", "bellsouth.net", "bigpond.com", "charter.net", 
				"comcast.net", "cox.net", "facebook.com", "gmail.com", "gmx.de", "hotmail.com", 
				"laposte.net", "libero.it", "live.com", "mail.ru", "msn.com", "orange.fr", "outlook.com", 
				"rambler.ru", "rediffmail.com", "rocketmail.com", "sbcglobal.net", "shaw.ca", "sky.com", 
				"verizon.net", "wanadoo.fr", "web.de", "yahoo.com", "yandex.ru","ymail.com" };

		String email = generateRandomString(length);
		email += "@" + domainArr[(int) (domainArr.length * Math.random())];
		return email;
	}
	private static String genNormalEmail(String fName, String lName) {
		StringBuilder stringBuilder=new StringBuilder();
		stringBuilder.append(fName).append('.').append(lName).append("@gmail.com");
		return stringBuilder.toString().toLowerCase();
	}
	
	private static String genUsername(String fName, String lName) {
		StringBuilder stringBuilder=new StringBuilder();
		stringBuilder.append(fName).append('.').append(lName);
		return stringBuilder.toString().toLowerCase();
	}
	
	private static String genPassword(String fName, String lName) {
		StringBuilder stringBuilder=new StringBuilder();
		stringBuilder.append(fName).append('.').append(lName).append("123");
		return stringBuilder.toString().toLowerCase();
		
	}
	

	public static void main(String[] args) throws InterruptedException {
		Scanner keyboard = new Scanner(System.in);
//		int emaillength=(int) (1+Math.random()*12);
//		String email=generateRandomEmail(emaillength);
//		System.out.println(email);
		
		//Scanner
		
//		System.out.println("Please enter your first name");
//		String fname=keyboard.nextLine();
//		System.out.println("Please enter your last name");
//		String lname=keyboard.nextLine();
//		System.out.println("Please enter your phone");
//		String phone=keyboard.nextLine();
//		String email=genNormalEmail(fname, lname);
//		System.out.println("Please enter your Address 1");
//		String address1=keyboard.nextLine();
//		System.out.println("Please enter your Address 2");
//		String address2=keyboard.nextLine();
//		System.out.println("Please enter your city");
//		String city=keyboard.nextLine();
//		System.out.println("Please enter your state");
//		String state=keyboard.nextLine();
//		System.out.println("Please enter your postal code");
//		String postalCode=keyboard.nextLine();
//		System.out.println("Please enter your country");
//		String country=keyboard.nextLine().toUpperCase();
		
		//no typing
		
		String fname="Denis";
		String lname="Oleynik";
		String phone="919-807-9170";
		String email=genNormalEmail(fname, lname);
		String address1="1134 Preston Grove Ave";
		String address2="";
		String city="Cary";
		String state="North Carolina";
		String postalCode="27513";
		String country="Russia".toUpperCase();
		
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://newtours.demoaut.com/");
//		chromeDriver.findElement(By.name("q")).sendKeys("Java tutorials");
//		driver.findElement(By.name("userName")).sendKeys("in");
//		driver.findElement(By.name("password")).sendKeys("password");
//		driver.findElement(By.name("login")).click();
		
		driver.findElement(By.linkText("REGISTER")).click();
		
//		driver.findElement(By.name("firstName")).sendKeys("Isaac");
//		driver.findElement(By.name("lastName")).sendKeys("Newton");
//		driver.findElement(By.name("phone")).sendKeys("919-555-55-55");
//		driver.findElement(By.name("userName")).sendKeys("IsaacNewton@trin.cam.ac.uk");
		
		//Contact Information
		driver.findElement(By.name("firstName")).sendKeys(fname);
		driver.findElement(By.name("lastName")).sendKeys(lname);
		driver.findElement(By.name("phone")).sendKeys(phone);
		driver.findElement(By.name("userName")).sendKeys(email);
		//Mailing Information
		driver.findElement(By.name("address1")).sendKeys(address1);
		driver.findElement(By.name("address2")).sendKeys(address2);
		driver.findElement(By.name("city")).sendKeys(city);
		driver.findElement(By.name("state")).sendKeys(state);
		driver.findElement(By.name("postalCode")).sendKeys(postalCode);
		//dropdown		
		WebElement countryDropdown = driver.findElement(By.name("country"));
		Select select=new Select(countryDropdown);
		select.selectByVisibleText(country);
		//User Information
		String username=genUsername(fname, lname);
		driver.findElement(By.name("email")).sendKeys(username);
		String password = genPassword(fname,lname);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("confirmPassword")).sendKeys(password);
		//Submit
		driver.findElement(By.name("register")).click();
		
//		Thread.sleep(2000);

		//confirmation 1		
		String actualConfirmationText=driver.findElement(By.tagName("b")).getText();
		String expectedConfirmationText="Dear "+fname+" "+lname+",";
		if (actualConfirmationText.equals(expectedConfirmationText)) {
			System.out.println("You are registered at Mercury");
		}else {
			System.out.println("Something went wrong...");
		}
		
		//confirmation 2
		
		String actualConfirmationText2=driver.findElement(By.xpath("(//b)[2]")).getText();
		String expectedConfirmationText2="Note: Your user name is "+username+".";
		if (actualConfirmationText.equals(expectedConfirmationText)) {
			System.out.println("Confirmation 2 - all is fine");
		}else {
			System.out.println("Something went wrong... (Conf 2)");
		}
		
		
		
		keyboard.close();
//		driver.quit();
		

	}

}

