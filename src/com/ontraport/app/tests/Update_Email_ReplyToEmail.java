package com.ontraport.app.tests;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.testng.AssertJUnit;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Message_Edit;
import com.ontraport.app.pages.Message_ListAll;
import com.ontraport.app.tools.AbstractTest;
import com.ontraport.app.tools.Common;

public class Update_Email_ReplyToEmail extends AbstractTest {
	String newReplyToEmail="testSelenium@gmail.com";
	
	@Test
	public void testTC0554_Update_Email_ReplyToEmail() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
		Message_ListAll msgList = contactListAll.navMessages();
		CreateMessage createMsg= new CreateMessage();
		
		//calling create Email Message method here..... 
		String msgName= createMsg.testCreate_EmailMessage();
	
		Message_Edit editEmail= msgList.editMessage(msgName);
		Common.waitForPage(driver, 30);
		String replyToEmail= editEmail.getReplyToEmail();
		msgList= editEmail.editMessageReplyToEmail(newReplyToEmail);
		msgList.setHundredRecordsPerPage();
		boolean condition= msgList.isElementPresent(msgName);
		AssertJUnit.assertTrue(condition);
		editEmail= msgList.editMessage(msgName);
		String replyToEmail1= editEmail.getReplyToEmail();
		Assert.assertNotSame(replyToEmail, replyToEmail1);
		Thread.sleep(2000);
	}
}
