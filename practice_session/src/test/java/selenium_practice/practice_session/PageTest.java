package selenium_practice.practice_session;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PageTest {
	
	WebDriver driver;
	String URL="https://www.google.com/";
	
	@BeforeMethod
	public void setUp() {
		Singleton_Class obj=Singleton_Class.getDriverInstance();
		driver=obj.openBrowser();
	}

	@Test
	public void Test_01() {
		driver.get(URL);
		System.out.println(driver.getTitle());
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
