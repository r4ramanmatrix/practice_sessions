package selenium_training;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionClass_Concept {

	public static WebDriver driver;
	public static String url = "https://demoqa.com/";

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Test
	public void test_01() throws Exception {
		Assert.assertEquals(driver.getTitle(),
				"ToolsQA – Demo Website to Practice Automation – Demo Website to Practice Automation");
		driver.findElement(By.xpath("//a[contains(text(),'Droppable')]")).click();
		Actions act = new Actions(driver);
		WebElement dragLink = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement dropLink = driver.findElement(By.xpath("//div[@id='droppable']"));
		act.dragAndDrop(dragLink, dropLink).perform();
		Thread.sleep(5000);

		driver.navigate().to(url);

		driver.findElement(By.xpath("//a[contains(text(),'Menu')]")).click();

		List<WebElement> menuItems = driver.findElements(By.xpath("//div[@role='menuitem']"));
		System.out.println(menuItems.size());
		for (int i = 0; i < menuItems.size(); i++) {
			String menuItemsText = menuItems.get(i).getText();
			if (menuItemsText.contains("Electronics")) {
				act.moveToElement(menuItems.get(i)).perform();
			}
		}
		driver.findElement(By.xpath("//div[contains(text(),'Utilities')]")).click();
		Thread.sleep(5000);
		driver.navigate().to(url);
		driver.findElement(By.xpath(
				"//div[starts-with(@class,'menu-top')]/ul/child::li/a[contains(text(),'Tooltip and Double click')]"))
				.click();
		WebElement doubleClickLink = driver.findElement(By.xpath("//button[@id='doubleClickBtn']"));
		act.doubleClick(doubleClickLink).perform();
		Thread.sleep(5000);
		driver.switchTo().alert().accept();
		
		WebElement rightClickLink=driver.findElement(By.xpath("//button[@id='rightClickBtn']"));
		act.contextClick(rightClickLink).perform();
		List<WebElement> rightCLickLinks=driver.findElements(By.xpath("//div[@id='rightclickItem']/child::div"));
		for(int i=0;i<rightCLickLinks.size();i++) {
			String itemsText=rightCLickLinks.get(i).getText();
			if(itemsText.contains("Edit this")) {
				rightCLickLinks.get(i).click();
				Thread.sleep(2000);
				driver.switchTo().alert().accept();
			}
		}
		System.out.println(driver.getTitle());
		
		
	}

	@AfterMethod
	public void tearDown() {
		// driver.close();
	}

}
