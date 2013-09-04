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
import com.ontraport.app.tools.Common;

public class EmailMessageEdit extends AbstractTest {
	String newMsgName = "NewMsg" + Calendar.getInstance().getTimeInMillis();
	String newSendOutName = "New Selenium";
	String newReplyToEmail = "testSelenium@gmail.com";
	String newSubject = "This is new Email Subject";
	String newBodyText = "This is a new Text Message";

	@Test
	public void testTC0552_Update_Email_Name() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll()
				.init();
		Message_ListAll msgList = contactListAll.navMessages();
		CreateMessage createMsg = new CreateMessage();

		// calling create Email Message method here.....
		String msgName = createMsg.testCreate_EmailMessage();

		Message_Edit editEmail = msgList.editEmailMessage(msgName);
		msgList = editEmail.editMessageName(newMsgName);
		msgList.setHundredRecordsPerPage();
		boolean condition = msgList.isElementPresent(newMsgName);
		AssertJUnit.assertTrue(condition);
		Assert.assertNotEquals(msgName, newMsgName);
		// msgList.logout();
	}

	@Test
	public void testTC0553_Update_Email_SendOutName() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll()
				.init();
		Message_ListAll msgList = contactListAll.navMessages();
		CreateMessage createMsg = new CreateMessage();

		// calling create Email Message method here.....
		String msgName = createMsg.testCreate_EmailMessage();

		Message_Edit editEmail = msgList.editEmailMessage(msgName);
		String sendOutName = editEmail.getSendOutName();
		msgList = editEmail.editMessageSendOutName(newSendOutName);
		msgList.setHundredRecordsPerPage();
		boolean condition = msgList.isElementPresent(msgName);
		AssertJUnit.assertTrue(condition);
		editEmail = msgList.editEmailMessage(msgName);
		String sendOutName1 = editEmail.getSendOutName();
		Assert.assertNotSame(sendOutName, sendOutName1);
	}

	@Test
	public void testTC0554_Update_Email_ReplyToEmail() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll()
				.init();
		Message_ListAll msgList = contactListAll.navMessages();
		CreateMessage createMsg = new CreateMessage();

		// calling create Email Message method here.....
		String msgName = createMsg.testCreate_EmailMessage();

		Message_Edit editEmail = msgList.editEmailMessage(msgName);
		Common.waitForPage(driver, 30);
		String replyToEmail = editEmail.getReplyToEmail();
		msgList = editEmail.editMessageReplyToEmail(newReplyToEmail);
		msgList.setHundredRecordsPerPage();
		boolean condition = msgList.isElementPresent(msgName);
		AssertJUnit.assertTrue(condition);
		editEmail = msgList.editEmailMessage(msgName);
		String replyToEmail1 = editEmail.getReplyToEmail();
		Assert.assertNotSame(replyToEmail, replyToEmail1);
		Thread.sleep(2000);
	}

	@Test
	public void testTC0556_Update_Email_Subject() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll()
				.init();
		Message_ListAll msgList = contactListAll.navMessages();
		CreateMessage createMsg = new CreateMessage();

		// calling create Email Message method here.....
		String msgName = createMsg.testCreate_EmailMessage();

		Message_Edit editEmail = msgList.editEmailMessage(msgName);
		String subject = editEmail.getSubject();
		msgList = editEmail.editMessageSubject(newSubject);
		msgList.setHundredRecordsPerPage();
		boolean condition = msgList.isElementPresent(msgName);
		AssertJUnit.assertTrue(condition);
		editEmail = msgList.editEmailMessage(msgName);
		String subject1 = editEmail.getSubject();
		Assert.assertNotSame(subject, subject1);
	}

	@Test
	public void testTC0557_Update_Email_WriteOutText() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll()
				.init();
		Message_ListAll msgList = contactListAll.navMessages();
		CreateMessage createMsg = new CreateMessage();

		// calling create Email Message method here.....
		String msgName = createMsg.testCreate_EmailMessage();

		Message_Edit editEmail = msgList.editEmailMessage(msgName);
		String bodyText = editEmail.getTextFromFrame();
		msgList = editEmail.editMessageBody(newBodyText);
		msgList.setHundredRecordsPerPage();
		boolean condition = msgList.isElementPresent(msgName);
		AssertJUnit.assertTrue(condition);
		editEmail = msgList.editEmailMessage(msgName);
		String bodyText1 = editEmail.getTextFromFrame();
		Assert.assertNotSame(bodyText, bodyText1);
	}

}
