package selenium_training;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.lse.qa.utilities.Utils;

public class Handling_Window {

	public WebDriver driver;

	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.virtusa.com/");
	}

	@Test
	public void test_01() {
		System.out.println(driver.getTitle());
		List<WebElement> socialLinks = driver
				.findElements(By.xpath("//div[starts-with(@class,'col-md-6 col-sm')]/ul/li/a"));
		
		Utils.scrollIntoView(socialLinks.get(1), driver);
		
		WebDriverWait waiting=new WebDriverWait(driver, 20);
		waiting.until(ExpectedConditions.visibilityOf(socialLinks.get(1)));
		
		System.out.println(socialLinks.size());

		String parentWindow = driver.getWindowHandle();
		
		System.out.println("Parent Window Id: " + parentWindow);
		
		for(int i=0;i<socialLinks.size();i++) {
			System.out.println(socialLinks.get(i).getAttribute("href"));
			socialLinks.get(i).click();
		}

		
		  Set<String> handles = driver.getWindowHandles();
		  
		  String[] individuals = new String[handles.size()];
		  System.out.println(individuals.length); 
		  Iterator<String> itr =handles.iterator(); 
		  int i = 0;
		  
		  while (itr.hasNext()) 
		  { 
			  individuals[i] = itr.next(); 
			  i++; 
			  
		  }
		  
		  driver.switchTo().window(individuals[3]);
		  System.out.println(driver.getTitle());
		  driver.switchTo().window(parentWindow);
		 

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
