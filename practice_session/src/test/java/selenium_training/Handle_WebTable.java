package selenium_training;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.lse.qa.utilities.Utils;

public class Handle_WebTable {

	public static WebDriver driver;

	@BeforeMethod
	public void setUp() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
		driver = new ChromeDriver(options);

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Utils.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(Utils.PAGE_LOAD, TimeUnit.SECONDS);
		driver.get(
				"https://www.londonstockexchange.com/exchange/prices-and-markets/stocks/prices-search/stock-prices-search.html");
	}

	@Test
	public void test_01() {

		String row = "//div[@class='paging']/following::table/child::tbody/tr";
		int rowNumber = driver.findElements(By.xpath(row)).size();
		System.out.println("Number of rows are: " + rowNumber);

		String col = "//div[@class='paging']/following::table/child::tbody/tr[1]/td";
		int colNumber = driver.findElements(By.xpath(col)).size();
		System.out.println("Number of columns are: " + colNumber);

		String firstPart = "//div[@class='paging']/following::table/child::tbody/tr[";

		String secondPart = "]/td[";

		String thirdPart = "]";

		for (int i = 1; i < rowNumber; i++) {
			for (int j = 1; j < colNumber; j++) {
				String finalPart = firstPart + i + secondPart + j + thirdPart;
				// System.out.println(finalPart);
				String textData = driver.findElement(By.xpath(finalPart)).getText();
				System.out.print(textData + " | ");
			}
			System.out.println();
		}

	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
