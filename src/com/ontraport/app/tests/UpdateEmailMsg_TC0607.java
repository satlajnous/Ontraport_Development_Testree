package com.ontraport.app.tests;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;



import org.junit.Assert;
import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Message_CreateEmail;
import com.ontraport.app.pages.Message_Edit;
import com.ontraport.app.pages.Message_ListAll;
import com.ontraport.app.pages.Message_TypeSelection;
import com.ontraport.app.parts.SiteMenu;
import com.ontraport.app.tools.AbstractTest;

public class UpdateEmailMsg_TC0607 extends AbstractTest{
	String msgName = "SelMsg" + Calendar.getInstance().getTimeInMillis();
	String sendOutName = "Selenium test";
	String replyToEmail = "selenium@gmail.com";
	String subject = "Selenium Test";
	String bodyText = "Selenium Testing";
	@Test
	public void testUpdate_Email_Preview() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		SiteMenu siteMenu= (SiteMenu) new SiteMenu().init();
		Contact_ListAll contactListAll = siteMenu.contacts();
		Message_ListAll msgList = contactListAll.navMessages();
		createEmailMsg(msgName, sendOutName, replyToEmail, subject, bodyText);	
		
		Message_Edit editEmail= msgList.editMessage(msgName);
		String originalTextMsg= editEmail.getTextFromFrame();
		String newWindowTextMsg= editEmail.windowHandle();
		boolean condition= originalTextMsg.equals(newWindowTextMsg);
		Assert.assertTrue(condition);
	}
	
	public void createEmailMsg(String msgName, String sendOutName, String replyToEmail, String subject, String bodyText ) throws Exception{
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
	}
}
