package SeleniumCommands;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebBrowserCommands {
	public static void main(String[] args) throws InterruptedException {
		String driverExecutablePath = ".\\resources\\executables\\chromedriver.exe";
		
		System.setProperty("webdriver.chrome.driver", driverExecutablePath);
		// Create a new instance of the FireFox driver
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(1000);
		// Storing the Application Url in the String variable
		//String url = "http://www.shop.demoqa.com";
		String url = "https://www.toolsqa.com/automation-practice-form/";		
		
		// Launch the ToolsQA WebSite
		driver.get(url);
		
		// Find Accept button on cookie
		WebElement acceptButtonEle = driver.findElement(By.xpath("//*[@id=\"cookie_action_close_header\"]"));
		
		// Click Accept button
		acceptButtonEle.click();
		
		// Wait a second
		Thread.sleep(1000);
		
		// Find Simple Button on the page
		WebElement simpleButtonEle = driver.findElement(By.tagName("button"));
		
		// Get location of Simple Button Element
		Point locationOfSimpleButtonEle = simpleButtonEle.getLocation();
		
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("window.scrollBy(0," + (locationOfSimpleButtonEle.getY() - 70 ) + ")");
		Thread.sleep(2000);
		simpleButtonEle.click();
		Thread.sleep(4000);

		driver.close();

	}
	
}
