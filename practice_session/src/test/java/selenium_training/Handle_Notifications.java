package selenium_training;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Handle_Notifications {

	public WebDriver driver;

	@BeforeClass
	public void setUp() {

		/*
		 * ChromeOptions options = new ChromeOptions();
		 * options.addArguments("--disable-notifications");
		 * System.setProperty("webdriver.chrome.driver",
		 * "src/drivers/chromedriver.exe"); driver=new ChromeDriver(options); driver
		 * driver.get("https://www.londonstockexchange.com/home/homepage.htm");
		 */
	}

	@Test
	public void test_01() {

	}

	@AfterClass
	public void tearDown() {

	}

}
