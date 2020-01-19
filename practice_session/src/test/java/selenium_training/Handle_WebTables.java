package selenium_training;

import java.io.File;
import java.io.FileOutputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Handle_WebTables {

	public WebDriver driver;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");

		driver = new ChromeDriver();
		driver.get(
				"https://www.londonstockexchange.com/exchange/prices-and-markets/stocks/prices-search/stock-prices-search.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
	}

	@Test
	public void test_01() {
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);

		File file = new File("C:\\tool_s\\My_Space\\practice_session\\src\\test\\java\\testData\\WriteData.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sh = wb.createSheet("tableData");
		sh.createRow(0).createCell(0).setCellValue("abcd");

		int headRow = driver.findElements(By.xpath("//table[@class='table_dati']/child::thead/tr/th")).size();
		System.out.println(headRow);

		String firstHeadRow = "//table[@class='table_dati']/child::thead/tr/th[";
		String secondHeadRow = "]";

		for (int i = 1; i < headRow; i++) {
			String finalPath = firstHeadRow + i + secondHeadRow;
			String textData = driver.findElement(By.xpath(finalPath)).getText();
			System.out.print(textData + " | ");
		}
		System.out.println();

		int rowNumber = driver.findElements(By.xpath("//table[@class='table_dati']/child::tbody/tr")).size();
		int colNumber = driver.findElements(By.xpath("//table[@class='table_dati']/child::tbody/tr[1]/td")).size();

		String firstXpath = "//table[@class='table_dati']/child::tbody/tr[";
		String secondXpath = "]/td[";
		String thirdXpath = "]";

		for (int i = 1; i < rowNumber; i++) {
			sh.createRow(i);
			for (int j = 1; j < colNumber; j++) {
				String finalXpath = firstXpath + i + secondXpath + j + thirdXpath;
				String textData = driver.findElement(By.xpath(finalXpath)).getText();
				System.out.println();
				sh.getRow(i).createCell(j-1).setCellValue(textData);
			}
			System.out.println();
		}
		try {
			FileOutputStream fos=new FileOutputStream(file);
			wb.write(fos);
			wb.close();
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
