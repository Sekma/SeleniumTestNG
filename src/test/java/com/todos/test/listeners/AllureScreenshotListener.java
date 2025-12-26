package com.todos.test.listeners;

import java.io.ByteArrayInputStream;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.todos.utils.BasePage; 
import io.qameta.allure.Allure;

public class AllureScreenshotListener implements ITestListener {

	@Override
    public void onTestSuccess(ITestResult result) {
        attach(result, "PASS");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        attach(result, "FAIL");
    }

    private void attach(ITestResult result, String status) {
    	
        WebDriver driver = BasePage.driver; 

        if (driver == null) return;

        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        
      
        Allure.addAttachment("Screenshot [" + status + "] - " + result.getName(),
                new ByteArrayInputStream(screenshot));

       
        Allure.addAttachment("Page Source [" + status + "] - " + result.getName(),
                "text/html", driver.getPageSource(), ".html");
    }

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
} 
