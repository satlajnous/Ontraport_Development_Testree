package com.ontraport.app.tests;

import java.util.concurrent.TimeUnit;



import org.junit.Assert;
import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Message_Edit;
import com.ontraport.app.pages.Message_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class Update_Email_Cancel extends AbstractTest{
	String newTextMessage= "This is just a test";
	@Test
	public void testEdit_EmailMessage_Cancel() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
		Message_ListAll msgList = contactListAll.navMessages();
		CreateMessage createMsg= new CreateMessage();
		
		//calling create Email Message method here..... 
		String msgName= createMsg.testCreate_EmailMessage();
		
		Message_Edit editEmail= msgList.editMessage(msgName);
		String originalTextMsg= editEmail.getTextFromFrame();
		editEmail.enterTextMessage(newTextMessage);
		String latestTextMsg= editEmail.getTextFromFrame();
		editEmail.clickCancel();
		editEmail= msgList.editMessage(msgName);
		String textMessage= editEmail.getTextFromFrame();
		Assert.assertTrue(originalTextMsg.equals(textMessage));
		Assert.assertFalse(textMessage.equals(latestTextMsg));
	}

}
