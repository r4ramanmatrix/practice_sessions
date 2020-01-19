package selenium_training;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Handling_Window_01 {

	public WebDriver driver;
	public static String url = "https://demoqa.com/";

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
	}

	@Test
	public void test_01() {
		driver.findElement(By.xpath("//a[contains(text(),'Automation Practice Switch Windows')]")).click();
		WebElement parentLink = driver.findElement(By.xpath("//button[@id='button1']"));
		String parentWindow = driver.getWindowHandle();
		System.out.println("parent window: " + parentWindow);
		
		for (int i = 0; i < 3; i++) {
			parentLink.click();		
		}
		Set windows = driver.getWindowHandles();
		String[] individuals=new String[windows.size()];
		
		System.out.println(individuals.length);
		Iterator<String> itr=windows.iterator();
		int i=0;
		while(itr.hasNext()) {
			individuals[i]=(String)itr.next();
			i++;
		}
		String child1title=driver.switchTo().window(individuals[1]).getTitle();
		System.out.println(child1title);
		driver.switchTo().window(individuals[1]).close();
		
		driver.switchTo().window(parentWindow);
		driver.switchTo().window(individuals[2]).close();
		driver.switchTo().window(parentWindow);
		driver.switchTo().window(individuals[3]).close();
		driver.switchTo().window(parentWindow);
		System.out.println(driver.getTitle());
		
		driver.findElement(By.xpath("//button[contains(text(),'New Message Window')]")).click();
		Set<String> handles=driver.getWindowHandles();
		String[] windowsIndi=new String[handles.size()];
		System.out.println(windowsIndi.length);
		Iterator<String> itr2=handles.iterator();
		int j=0;
		while(itr2.hasNext()) {
			windowsIndi[j]=(String)itr2.next();
			j++;
		}
		/*String childTitle2=driver.switchTo().window(windowsIndi[1]).getTitle();
		System.out.println(childTitle2);*/
		driver.switchTo().window(windowsIndi[1]).close();
		driver.switchTo().window(parentWindow);
	}

	@AfterMethod
	public void tearDown() {

	}
}
