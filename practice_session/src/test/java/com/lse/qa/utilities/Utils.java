package com.lse.qa.utilities;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.lse.qa.base.TestBase;

public class Utils extends TestBase{

	public static int IMPLICIT_WAIT = 15;
	public static int PAGE_LOAD = 20;

	public static void scrollIntoView(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	public static void takeScreenshotATEndOfTest() throws Exception{
		File srcfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String currentDir=System.getProperty("user.dir");
		FileUtils.copyFile(srcfile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".jpeg"));
	}

}
