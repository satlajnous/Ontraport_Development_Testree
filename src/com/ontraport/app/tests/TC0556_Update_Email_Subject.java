package com.ontraport.app.tests;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.testng.AssertJUnit;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Message_Edit;
import com.ontraport.app.pages.Message_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class TC0556_Update_Email_Subject extends AbstractTest{
	String newSubject= "This is new Email Subject";
	
	@Test
	public void testTC0556_Update_Email_Subject() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
		Message_ListAll msgList = contactListAll.navMessages();
		CreateMessage createMsg= new CreateMessage();
		
		//calling create Email Message method here..... 
		String msgName= createMsg.testCreate_EmailMessage();
	
		Message_Edit editEmail= msgList.editMessage(msgName);
		String subject= editEmail.getSubject();
		msgList= editEmail.editMessageSubject(newSubject);
		msgList.setHundredRecordsPerPage();
		boolean condition= msgList.isElementPresent(msgName);
		AssertJUnit.assertTrue(condition);
		editEmail= msgList.editMessage(msgName);
		String subject1= editEmail.getSubject();
		Assert.assertNotSame(subject, subject1);
	}

}
