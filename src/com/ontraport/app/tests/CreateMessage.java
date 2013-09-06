package com.ontraport.app.tests;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;



import org.junit.Assert;
import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Login;
import com.ontraport.app.pages.Message_CreateEmail;
import com.ontraport.app.pages.Message_CreateSms;
import com.ontraport.app.pages.Message_ListAll;
import com.ontraport.app.pages.Message_TypeSelection;
import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.AbstractTest;
import com.ontraport.app.tools.Common;

public class CreateMessage extends AbstractTest{
	String sendOutName = "Selenium Test";
	String replyToEmail = "selenium@test.com";
	String subject = "Selenium Test";
	String bodyText = "Selenium Test";
	String msgName = "SelMsg" + Calendar.getInstance().getTimeInMillis();
	String mergeField= "Last Name";
	
	@Test
	public String testCreate_EmailMessage() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll()
				.init();
		Message_ListAll msgList = contactListAll.navMessages();
		Message_TypeSelection msgType = msgList.create();
		Message_CreateEmail emailMsg = msgType.emailCreate();
		emailMsg.newEmailMsg(msgName, sendOutName, replyToEmail, subject,
				bodyText);
		msgList.setHundredRecordsPerPage();
		boolean condition= emailMsg.isElementPresent(msgName);
		Assert.assertTrue(condition);
		return msgName;
	}
	
	/*@Test
	public String testCreate_SMSMessage() throws Exception {
		Login login= (Login) new Login().init();
		Common common= new Common();
		login.as(common.prop("USERNAME"), common.prop("PASSWORD"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
		Message_ListAll msgList = contactListAll.navMessages();
		Message_TypeSelection msgType = msgList.create();
		Message_CreateSms smsMsg = msgType.smsCreate();
		smsMsg.newSMSMsg(msgName, bodyText, mergeField);
		msgList.setHundredRecordsPerPage();
		boolean condition= smsMsg.isElementPresent(msgName);
		Assert.assertTrue(condition);
		return msgName;
	}*/
	
	

}
