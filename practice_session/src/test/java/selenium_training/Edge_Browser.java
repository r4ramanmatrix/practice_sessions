package selenium_training;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Edge_Browser {
	public static WebDriver driver;

	@BeforeClass
	public void setUp() {

		System.setProperty("webdriver.edge.driver", 
				"src/drivers/MicrosoftWebDriver.exe");
		driver = new EdgeDriver();
		driver.get("https://google.com");

	}

	@Test
	public void test_01() {

	}

	@AfterClass
	public void tearDown() {

	}

}
