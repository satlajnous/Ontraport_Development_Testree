package com.ontraport.app.tests;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.testng.AssertJUnit;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Message_Edit;
import com.ontraport.app.pages.Message_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class TC0557_Update_Email_WriteOutText extends AbstractTest {
	
	String newBodyText="This is a new Text Message";
	@Test
	public void testTC0557_Update_Email_WriteOutText() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
		Message_ListAll msgList = contactListAll.navMessages();
		CreateMessage createMsg= new CreateMessage();
		
		//calling create Email Message method here..... 
		String msgName= createMsg.testCreate_EmailMessage();
	
		Message_Edit editEmail= msgList.editEmailMessage(msgName);
		String bodyText= editEmail.getTextFromFrame();
		msgList= editEmail.editMessageBody(newBodyText);
		msgList.setHundredRecordsPerPage();
		boolean condition= msgList.isElementPresent(msgName);
		AssertJUnit.assertTrue(condition);
		editEmail= msgList.editEmailMessage(msgName);
		String bodyText1= editEmail.getTextFromFrame();
		Assert.assertNotSame(bodyText, bodyText1);
	}
	
}
