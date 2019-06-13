package com.w2a.testcases;

import java.util.Hashtable;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.w2a.base.TestBase;
import com.w2a.utilities.TestUtil;

public class AddCustomerTest extends TestBase {   

	@Test(dataProviderClass=TestUtil.class, dataProvider="dp")
	public void addCustomerTest(Hashtable<String, String> data) throws InterruptedException
	{
		if(!(data.get("runmode").equals("Y")))
		{
			throw new SkipException("Skipping the test case as the Run mode for data set is NO");
		}
		click("AddCustBtn_XPATH");
	    type("firstname_XPATH",data.get("firstname"));
	    type("lastname_XPATH",data.get("lastname"));
	    type("postcode_XPATH",data.get("postcode"));
		click("addbtn_XPATH");
		
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		
		
		alert.accept();
		Thread.sleep(2000);
	}

	
	

}
