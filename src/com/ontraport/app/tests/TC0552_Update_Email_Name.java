package com.ontraport.app.tests;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.testng.AssertJUnit;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Message_Edit;
import com.ontraport.app.pages.Message_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class TC0552_Update_Email_Name extends AbstractTest{
	String newMsgName= "NewMsg"+Calendar.getInstance().getTimeInMillis();
	@Test
	public void testTC0552_Update_Email_Name() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
		Message_ListAll msgList = contactListAll.navMessages();
		CreateMessage createMsg= new CreateMessage();
		
		//calling create Email Message method here..... 
		String msgName= createMsg.testCreate_EmailMessage();
		
		Message_Edit editEmail= msgList.editMessage(msgName);
		msgList= editEmail.editMessageName(newMsgName);
		msgList.setHundredRecordsPerPage();
		boolean condition= msgList.isElementPresent(newMsgName);
		AssertJUnit.assertTrue(condition);
		Assert.assertNotEquals(msgName, newMsgName);
		//msgList.logout();
	}
}
