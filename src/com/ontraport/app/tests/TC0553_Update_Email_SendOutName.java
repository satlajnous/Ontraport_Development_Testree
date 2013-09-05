package com.ontraport.app.tests;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.testng.AssertJUnit;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Message_Edit;
import com.ontraport.app.pages.Message_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class TC0553_Update_Email_SendOutName extends AbstractTest {
	String newSendOutName="New Selenium";
	@Test
	public void testTC0553_Update_Email_SendOutName() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
		Message_ListAll msgList = contactListAll.navMessages();
		CreateMessage createMsg= new CreateMessage();
		
		//calling create Email Message method here..... 
		String msgName= createMsg.testCreate_EmailMessage();
	
		Message_Edit editEmail= msgList.editMessage(msgName);
		String sendOutName= editEmail.getSendOutName();
		msgList= editEmail.editMessageSendOutName(newSendOutName);
		msgList.setHundredRecordsPerPage();
		boolean condition= msgList.isElementPresent(msgName);
		AssertJUnit.assertTrue(condition);
		editEmail= msgList.editMessage(msgName);
		String sendOutName1= editEmail.getSendOutName();
		Assert.assertNotSame(sendOutName, sendOutName1);
	}
}
