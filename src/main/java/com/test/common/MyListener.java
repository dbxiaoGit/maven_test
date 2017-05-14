package com.test.common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.test.m2test.NewTest;

public class MyListener extends TestListenerAdapter {

	@Override  
    public void onTestFailure(ITestResult itr) {  
		super.onTestFailure(itr);  
		TakesScreenshot ts = (TakesScreenshot)NewTest.driver;
		try {
			FileInputStream fis = new FileInputStream(ts.getScreenshotAs(OutputType.FILE));
			FileOutputStream fos = new FileOutputStream("d:/" + System.currentTimeMillis() + ".png");
			int b = 0;
			
			while((b = fis.read()) != -1) {
				fos.write(b);
				//System.out.println(b);
			}
			//System.out.println(b);
			fis.close();
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }  
}
