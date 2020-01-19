package selenium_training;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.lse.qa.utilities.Utils;

public class Chrome_Headless_Browser {

	public static WebDriver driver;

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("window-size=1400,800");
		options.addArguments("headless");

		driver = new ChromeDriver(options);

		//driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Utils.PAGE_LOAD, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Utils.IMPLICIT_WAIT, TimeUnit.SECONDS);

		driver.get("https://www.technofunc.com/");
	}

	@Test
	public void test_01() {
		String pageTitle = driver.getTitle();
		System.out.println("Url is: " + pageTitle);
		Assert.assertEquals("TechnoFunc - TechnoFunc's Process & Industry Domain Skills", pageTitle);

	}

	@After
	public void tearDown() {
		driver.close();
	}

}
