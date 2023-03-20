package com.SeleniumProject1;

import java.awt.AWTException;
import java.awt.RenderingHints.Key;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Selenium_Project_ONE {

	public static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException, IOException, AWTException {
		// browser launched
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Javed\\eclipse-workspace\\Selenium_Automation_Tool\\Driver\\chromedriver.exe");
		// Incognito
		ChromeOptions options = new ChromeOptions();
		options.addArguments("Incognito");
		// Upcasting
		driver = new ChromeDriver(options);
		// WebDriver methods
		driver.get("https://adactinhotelapp.com/");
		//page load timeout
		driver.manage().window().maximize();
		String title = driver.getTitle();
		System.out.println("title:" + title);
		String currentUrl = driver.getCurrentUrl();
		System.out.println("CurrentUrl:" + currentUrl);
		
		// WebElements and its methods
		// single element = findelement using (abstract class=By) and
		// Locators(class,ID,X-paths)
		
		// Register and Login
		WebElement register = driver.findElement(By.xpath("//a[text()='New User Register Here']"));
		register.click();
		// register
		Thread.sleep(8000);
		//I used thread for 6 seconds to hold up the loading page to fill the captcha
		WebElement username = driver.findElement(By.xpath("//input[@id='username']"));
		username.sendKeys("MOJAGhost910");
		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		password.sendKeys("JAVED98765432!");
		WebElement Re_enter_password = driver.findElement(By.xpath("//input[@id='re_password']"));
		Re_enter_password.sendKeys("JAVED98765432!");
		WebElement name = driver.findElement(By.xpath("//input[@name='full_name']"));
		name.sendKeys("Mohammed Javed");
		WebElement email = driver.findElement(By.xpath("//input[@name='email_add']"));
		email.sendKeys("itsmojaved@gmail.com");
		
		
				
		WebElement checkbox = driver.findElement(By.xpath("//input[@type='checkbox']"));
		checkbox.click();
		// here I used thread because Captcha cant be done by selenium
		// manually I entered the displayed captcha
		//Screenshot
		WebElement registerBtn = driver.findElement(By.xpath("//input[@value='Register']"));
		registerBtn.click();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3000));
		WebElement login = driver.findElement(By.xpath("//a[.='Click here to login']"));
		login.click();

		TakesScreenshot ts0 = (TakesScreenshot) driver;
		File source0 = ts0.getScreenshotAs(OutputType.FILE);
		File destination0 = new File("C:\\Users\\Javed\\eclipse-workspace\\Selenium_Automation_Tool\\project_Screenshot\\login.png");
		FileUtils.copyFile(source0, destination0);

		WebElement Username = driver.findElement(By.xpath("//input[@name='username']"));
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].value='MOJAGhost10'",Username);

		WebElement Loginpassword = driver.findElement(By.xpath("//input[@id='password']"));
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("arguments[0].value='JAVED98765432!'",Loginpassword);
		
		Thread.sleep(15000);
		//I am going to verify my email Id Thats why I use here thread for 20 seconds

		WebElement loginbtn = driver.findElement(By.xpath("//input[@value='Login']"));
		loginbtn.click();

		TakesScreenshot ts2 = (TakesScreenshot) driver;
		File source2 = ts2.getScreenshotAs(OutputType.FILE);
		File destination2 = new File("C:\\Users\\Javed\\eclipse-workspace\\Selenium_Automation_Tool\\project_Screenshot\\afterlogin.png");
		FileUtils.copyFile(source2, destination2);
		
		//DropDown
		WebElement Location = driver.findElement(By.xpath("//select[@id='location']"));
		Location.click();
		Select s = new Select(Location);
		s.selectByValue("New York");
		boolean displayed = Location.isDisplayed();
		System.out.println("displayed:"+displayed);
		
		WebElement hotel = driver.findElement(By.xpath("//select[@id='hotels']"));
		hotel.click();
		Select s1 = new Select(hotel);
		s1.selectByValue("Hotel Hervey");
		
		WebElement roomtype = driver.findElement(By.xpath("//select[@name='room_type']"));
		roomtype.click();
		Select s2 = new Select(roomtype);
		s2.selectByVisibleText("Super Deluxe");
		
		WebElement numberofRooms = driver.findElement(By.xpath("//select[@name='room_nos']"));
		numberofRooms.click();
		Select s3 = new Select(numberofRooms);
		s3.selectByValue("2");
		
		WebElement checkin = driver.findElement(By.xpath("//input[@name='datepick_in']"));
		checkin.clear();
		checkin.sendKeys("30/11/2022");
		
		WebElement checkout = driver.findElement(By.xpath("//input[@id='datepick_out']"));
		checkout.clear();
		checkout.sendKeys("02/12/2022");
		
		WebElement adults = driver.findElement(By.xpath("//select[@name='adult_room']"));
		adults.click();
		Select s4 = new Select(adults);
		s4.selectByValue("2");
		
		WebElement children = driver.findElement(By.xpath("//select[@name='child_room']"));
		children.click();
		Select s5 = new Select(children);
		s5.selectByVisibleText("4 - Four");

		TakesScreenshot ts3 = (TakesScreenshot) driver;
		File source3 = ts3.getScreenshotAs(OutputType.FILE);
		File destination3 = new File("C:\\Users\\Javed\\eclipse-workspace\\Selenium_Automation_Tool\\project_Screenshot\\afterlogin.png");
		FileUtils.copyFile(source3, destination3);
		
		WebElement submit_btn = driver.findElement(By.xpath("//input[contains(@id,'Submit')]"));
		submit_btn.click();
		
		WebElement radiobtn = driver.findElement(By.xpath("//input[@type='radio']"));
		radiobtn.click();
		
		WebElement continueBtn = driver.findElement(By.xpath("//input[@id='continue']"));
		continueBtn.click();
		
		WebElement firstname = driver.findElement(By.xpath("//input[contains(@name,'first_name')]"));
		firstname.sendKeys("Mohammed");
		
		WebElement lastname = driver.findElement(By.xpath("//input[@id='last_name']"));
		lastname.sendKeys("Javed");
		
		WebElement address = driver.findElement(By.xpath("//textarea[@name='address']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value='NO 6 Vivenkandar Theru, Dubai kuruku sandhu, dubai main road dubai'", address);
		
		WebElement creditcardNO = driver.findElement(By.xpath("//input[@id='cc_num']"));
		creditcardNO.sendKeys("2039480123812325");
		
		WebElement CCtype = driver.findElement(By.xpath("//select[@id='cc_type']"));
		CCtype.click();
		Select s6 = new Select(CCtype);
		s6.selectByVisibleText("VISA");
		
		WebElement CCexpirydatefrom = driver.findElement(By.xpath("//select[@name='cc_exp_month']"));
		CCexpirydatefrom.click();
		Select s7 = new Select(CCexpirydatefrom);
		s7.selectByValue("12");
		
		WebElement CCEXPyear = driver.findElement(By.xpath("//select[@id='cc_exp_year']"));
		CCEXPyear.click();
		Select s8 = new Select(CCEXPyear);
		s8.selectByVisibleText("2022");
		
		WebElement cvv = driver.findElement(By.xpath("//input[@name='cc_cvv']"));
		cvv.sendKeys("940");
		
		WebElement booknow = driver.findElement(By.xpath("//input[@name='book_now']"));
		booknow.click();
		
		Thread.sleep(3000);
		WebElement bookitenary = driver.findElement(By.xpath("//a[contains(text(),'Booked Itinerary')]"));
		bookitenary.click();
		
		
		WebElement checkboxcancel = driver.findElement(By.xpath("//input[@type='checkbox']"));
		checkboxcancel.click();
		
		WebElement cancelBooking = driver.findElement(By.xpath("//input[@name='cancelall']"));
		cancelBooking.click();
		
		//alert concept
		Alert alert = driver.switchTo().alert();
		Thread.sleep(4000);
		alert.accept();
		
		TakesScreenshot ts4 = (TakesScreenshot) driver;
		File source4 = ts4.getScreenshotAs(OutputType.FILE);
		File destination4 = new File("C:\\Users\\Javed\\eclipse-workspace\\Selenium_Automation_Tool\\project_Screenshot\\logout.png");
		FileUtils.copyFile(source4, destination4);
		
		WebElement logout = driver.findElement(By.xpath("//input[@name='logout']"));
		logout.click();
		
		TakesScreenshot ts5 = (TakesScreenshot) driver;
		File source5 = ts5.getScreenshotAs(OutputType.FILE);
		File destination5 = new File("C:\\Users\\Javed\\eclipse-workspace\\Selenium_Automation_Tool\\project_Screenshot\\logout.png");
		FileUtils.copyFile(source5, destination5);
		
		WebElement loginagain = driver.findElement(By.xpath("//a[.='Click here to login again']"));
		//Actions
		Actions a = new Actions(driver);
		a.contextClick(loginagain).build().perform();
		//robot
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
		
		WebElement download = driver.findElement(By.xpath("(//a[text()='DOWNLOAD'])[1]"));
		
		Actions a2 = new Actions(driver);
		a2.contextClick(download).build().perform();
		//robot
		Robot r2 = new Robot();
		r2.keyPress(KeyEvent.VK_DOWN);
		r2.keyRelease(KeyEvent.VK_DOWN);
		
		r2.keyPress(KeyEvent.VK_ENTER);
		r2.keyRelease(KeyEvent.VK_ENTER);
		
		
		String current_ID = driver.getWindowHandle();
		System.out.println("Current_ID:"+ current_ID);
		
		String Url ="https://adactinhotelapp.com/resources/AdactinHotelApp_SetupGuide.pdf";
		Set<String> all_ID = driver.getWindowHandles();
		//set- doesnt allow the duplicate value and it is unique
		for (String eachID : all_ID) {
			
			if (driver.switchTo().window(eachID).equals(Url)) {
				
				break;
				
			}
		}
		
		String title1 = driver.getTitle();
		System.out.println(title1);
		
		driver.manage().window().fullscreen();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
}
