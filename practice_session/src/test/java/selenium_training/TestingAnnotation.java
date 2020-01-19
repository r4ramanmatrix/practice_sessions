package selenium_training;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestingAnnotation {
	
	public WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://google.com");
	}
	
	@BeforeClass
	public void setUp2() {
		System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://google.com");
	}
	
	@Test
	public void test_01() {
		System.out.println(driver.getTitle());
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}
	
	@AfterClass
	public void tearDown2() {
		driver.close();
	}

}
