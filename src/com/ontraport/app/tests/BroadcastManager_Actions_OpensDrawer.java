package com.ontraport.app.tests;



import org.junit.Assert;
import org.junit.Test;

import com.ontraport.app.pages.Contact_Settings;
import com.ontraport.app.pages.LeadScoring_Edit;
import com.ontraport.app.pages.QueuedMessage_ListAll;
import com.ontraport.app.parts.SiteMenu;
import com.ontraport.app.tools.AbstractTest;
import com.ontraport.app.tools.Common;

public class BroadcastManager_Actions_OpensDrawer extends AbstractTest{
	
	@Test
	public void testTC0509_BroadcastManager_Actions_OpensDrawer() throws Exception {
		SiteMenu siteMenu = (SiteMenu) new SiteMenu().init();
		Common.waitForPage(driver, 30);
		siteMenu.contacts();
		siteMenu.contact_Settings();
		
		Contact_Settings contact_Settings = (Contact_Settings) new Contact_Settings().init();
		Common.waitForPage(driver, 30);
		QueuedMessage_ListAll queuedMsg_ListAll= contact_Settings.scheduledBroadcast();
		queuedMsg_ListAll.clickActions();
		boolean condition= queuedMsg_ListAll.isElementDisplayed();
		Assert.assertTrue(condition);
		queuedMsg_ListAll.clickActions();
		boolean condition1= queuedMsg_ListAll.isElementDisplayed();
		Assert.assertFalse(condition1);
	}
}
