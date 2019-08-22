package thuynt3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Exercise_Day_07 {
	WebDriver driver;
	String url = "https://www.toolsqa.com/automation-practice-form";

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

	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}

}
