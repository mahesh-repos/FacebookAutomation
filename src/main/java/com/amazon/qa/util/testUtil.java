package com.amazon.qa.util;

import java.io.File;
import java.io.IOException;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import com.amazon.qa.base.TestBase;

public class testUtil extends TestBase {

	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 10;
	
	public static void takeScreenshotAtEndOfTest() throws IOException{
		
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		
//		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" +System.currentTimeMillis()+ ".png"));

		FileHandler.copy(scrFile, new File(currentDir + "/screenshots/" +System.currentTimeMillis()+ ".png"));
	}
}
