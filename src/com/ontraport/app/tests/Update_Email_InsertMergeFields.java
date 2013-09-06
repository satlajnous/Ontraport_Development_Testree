package com.ontraport.app.tests;

import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Message_Edit;
import com.ontraport.app.pages.Message_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class Update_Email_InsertMergeFields extends AbstractTest{
	String newMergeField="First Name";

	
	// Need to check scrolling for this...........	
	/*@Test
	public void testTC0600_Update_Email_InsertMergeFields() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
		Message_ListAll msgList = contactListAll.navMessages();
		CreateMessage createMsg= new CreateMessage();
		
		//calling create Email Message method here..... 
		String msgName= createMsg.testCreate_EmailMessage();
		
		Message_Edit editEmail= msgList.editMessage(msgName);		
		editEmail.editInsertMergeField(newMergeField);
		String textMsg= editEmail.getBodyText();
		boolean condition= textMsg.contains("["+newMergeField+"]");
		Assert.assertTrue(condition);
	}*/
}
