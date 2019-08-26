package thuynt3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Exercise_Day_07 {
	WebDriver driver;
	String url = "https://www.toolsqa.com/automation-practice-form";
	String firstName = "Nguyen";
	String lastName = "Thuy";
	

	@BeforeClass
	public void beforeClass() {

//			System.setProperty("webdriver.chrome.driver", "D:\\Workspace\\BasicSelenium\\src\\test\\resources\\executables\\chromedriver.exe");
//			driver = new ChromeDriver();

		System.setProperty("webdriver.gecko.driver",
				"D:\\Workspace\\BasicSelenium\\src\\test\\resources\\executables\\geckodriver.exe");
		driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);
	}

	@Test
	public void Exercise_01() {
		String pageTitle = driver.getTitle();
		int pageLength = pageTitle.length();
		System.out.println("Page title is: " + pageTitle);
		System.out.println("Page length is: " + pageLength);

		String pageUrl = driver.getCurrentUrl();
		Assert.assertEquals(pageUrl, url);

		String pageSource = driver.getPageSource();
		int psLength = pageSource.length();
		System.out.println("Page source is: " + pageSource.toString());
		System.out.println("Page source length is: " + psLength);
	}

	@Test
	public void Exercise_02() {
		driver.findElement(By.xpath("//a[text()='ACCEPT']")).click();
		
		WebElement partialLinkText = driver.findElement(By.partialLinkText("Partial Link Test"));
		partialLinkText.click();
		partialLinkText.getText();
		
		WebElement linkText = driver.findElement(By.linkText("Link Test"));
		linkText.click();
		linkText.getText();
		
		WebElement firstNameTextbox = driver.findElement(By.name("firstname"));
		firstNameTextbox.clear();
		firstNameTextbox.sendKeys(firstName);
		
		WebElement lastNameTextbox = driver.findElement(By.id("lastname"));
		lastNameTextbox.clear();
		lastNameTextbox.sendKeys(lastName);
		
		WebElement simpleBtn = driver.findElement(By.xpath("//button[@id = 'buttonwithclass']"));
		simpleBtn.click();
		simpleBtn.getText();
		
	}
	
	@Test
	public void Exercise_03() {
//		Launch a new Chrome browser.
//		Open https://www.toolsqa.com/automation-practice-form
//		Select Male and Female
//		Select Year of Experience from 1 to 7
		
		
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}

}
