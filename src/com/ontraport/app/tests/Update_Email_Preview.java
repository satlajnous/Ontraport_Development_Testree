package com.ontraport.app.tests;

import java.util.concurrent.TimeUnit;



import org.junit.Assert;
import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Message_Edit;
import com.ontraport.app.pages.Message_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class Update_Email_Preview extends AbstractTest{
	
	@Test
	public void testTC0607_Update_Email_Preview() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
		Message_ListAll msgList = contactListAll.navMessages();
		CreateMessage createMsg= new CreateMessage();
		
		//calling create Email Message method here..... 
		String msgName= createMsg.testCreate_EmailMessage();
		
		Message_Edit editEmail= msgList.editEmailMessage(msgName);
		String originalTextMsg= editEmail.getTextFromFrame();
		String newWindowTextMsg= editEmail.windowHandle();
		boolean condition= originalTextMsg.equals(newWindowTextMsg);
		Assert.assertTrue(condition);
	}
}
