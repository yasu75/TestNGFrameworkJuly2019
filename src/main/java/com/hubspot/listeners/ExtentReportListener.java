package com.hubspot.listeners;


import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.hubspot.base.BasePage;



public class ExtentReportListener implements ITestListener {
   
	BasePage basePage = new BasePage();

	public void onFinish(ITestContext context) {
		//hey i am done
		Reporter.log("Completed executing test "+ context.getName(), true);
	}

	public void onStart(ITestContext context) {
		//System.out.println(context.getName());
		Reporter.log("About to begin executing test "+ context.getName(), true);
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	//When test case get failed, this method is called
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
		System.out.println("The name of the test case failed is: "+result.getName());
		//screenshot
		try {
			basePage.getScreenshot(result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//When test case get skipped, this method is called
	public void onTestSkipped(ITestResult result) {
		System.out.println("The name of the test case skipped is: "+result.getName());
		
	}
	//When test case get started, this method is called
	public void onTestStart(ITestResult result) {
		System.out.println("Extent Report Results");
		System.out.println(result.getName()+" test case is started");
		
	}
	//When test case get passed, this method is called
	public void onTestSuccess(ITestResult result) {
		System.out.println(result.getName()+" test case passed");		
	}

}

	
