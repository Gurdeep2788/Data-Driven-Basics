package com.w2a.listners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.SkipException;

import com.relevantcodes.extentreports.LogStatus;
import com.w2a.base.TestBase;
import com.w2a.utilities.TestUtil;

public class CustomListeners extends TestBase implements ITestListener{

	public void onTestStart(ITestResult result) {
		
		test=rep.startTest(result.getName().toUpperCase());		
		
		
	}

	public void onTestSuccess(ITestResult result) {
		
		test.log(LogStatus.PASS, result.getName().toUpperCase()+" PASS");
		rep.endTest(test);
		rep.flush();
				
	}

	public void onTestFailure(ITestResult result) {
		
		try {
			TestUtil.captureScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		test.log(LogStatus.FAIL, result.getName().toUpperCase()+" Failed with Exception : "+result.getThrowable());
		test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));
		rep.endTest(test);
		rep.flush();
		
		
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		//Reporter.log("<br>"+"Capturing Screenshot");
		Reporter.log("<br>"+"<br>"+"Login Successfully executed !!!");
		//Reporter.log("<a target= \"_blank\" href="+TestUtil.screenshotName+">Screenshot</a> ");
		Reporter.log("<br>");
		
		Reporter.log("<a target= \"_blank\" href="+TestUtil.screenshotName+"><img src ="+TestUtil.screenshotName+" height=100 width=100\"></img></a> ");
		
		
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
