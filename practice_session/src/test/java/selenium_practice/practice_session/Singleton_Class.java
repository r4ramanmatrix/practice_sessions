package selenium_practice.practice_session;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public final class Singleton_Class {

	private static Singleton_Class driverInstance=null;
	private WebDriver driver;
	
	private Singleton_Class() {
		
	}
	
	public WebDriver openBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\tool_s\\My_Space\\practice_session\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		return driver;
	}
	
	public static Singleton_Class getDriverInstance() {
		if(driverInstance==null) {
			driverInstance=new Singleton_Class();
		}
		return driverInstance;
	}
	
}
