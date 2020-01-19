package selenium_training;

import java.util.concurrent.TimeUnit;

import javax.lang.model.element.Element;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.lse.qa.utilities.Utils;

public class Highlight_WebElement {

	public static WebDriver driver;

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Utils.PAGE_LOAD, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Utils.IMPLICIT_WAIT, TimeUnit.SECONDS);

		driver.get("https://www.technofunc.com/");
	}

	public static void flash(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String bgColor = element.getCssValue("backgroundColor");
		for (int i = 0; i < 10; i++) {
			changeColor("rgb(0,200,0)", element, driver);
			changeColor(bgColor, element, driver);
		}
	}

	public static void changeColor(String color, WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.backgroundColor= '" + color + "'", element);
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test_01() {
		String pageTitle = driver.getTitle();
		System.out.println("Title is: " + pageTitle);
		Assert.assertEquals("TechnoFunc - TechnoFunc's Process & Industry Domain Skills", pageTitle);
		WebElement industryKnowledge = driver
				.findElement(By.xpath("//div[starts-with(@class,'uk-navbar uk-position')]/child::nav/ul/li[3]/a"));
		Actions act = new Actions(driver);
		act.moveToElement(industryKnowledge).perform();

		WebElement fDomainLink = driver.findElement(By.xpath(
				"//div[starts-with(@class,'uk-grid uk-dropdown-grid')]/child::div[2]/ul/li[2]/a[contains(text(),'Finance Domain')]"));

		flash(fDomainLink, driver);
		
		fDomainLink.click();

	}

	@After
	public void tearDown() {
		driver.close();
	}

}
//div[starts-with(@class,'uk-navbar uk-position')]

//a[contains(text(),'Finance Domain')]
