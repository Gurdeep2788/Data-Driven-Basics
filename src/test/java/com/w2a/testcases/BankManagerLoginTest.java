package com.w2a.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.w2a.base.TestBase;

public class BankManagerLoginTest extends TestBase {

	@Test
	public void loginAsBankManager() throws InterruptedException, IOException
	{	
		
		//TestBase.verifyEquals("abc", "xyz");
		log.debug("Inside Login Test");
		Thread.sleep(2000);
		driver.findElement(By.xpath(OR.getProperty("bmlBtn_XPATH"))).click();
		
		Assert.assertTrue(isElementPresent(By.xpath(OR.getProperty("AddCustBtn_XPATH"))),"Login not successful");
			
		log.debug("Login Successfully executed !!!"); 
		//Assert.fail("Login not successful");
	}

}
