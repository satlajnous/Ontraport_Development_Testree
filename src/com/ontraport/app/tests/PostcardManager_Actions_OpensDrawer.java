package com.ontraport.app.tests;

import org.junit.Assert;
import org.junit.Test;

import com.ontraport.app.pages.Contact_Settings;
import com.ontraport.app.pages.PendingMail_ListAll;
import com.ontraport.app.parts.SiteMenu;
import com.ontraport.app.tools.AbstractTest;
import com.ontraport.app.tools.Common;

public class PostcardManager_Actions_OpensDrawer extends AbstractTest{
	
	@Test
	public void testTC0511_PostcardManager_Actions_OpensDrawer() throws Exception {
		SiteMenu siteMenu = (SiteMenu) new SiteMenu().init();
		Common.waitForPage(driver, 30);
		siteMenu.contacts();
		siteMenu.contact_Settings();
		
		Contact_Settings contact_Settings = (Contact_Settings) new Contact_Settings().init();
		Common.waitForPage(driver, 30);
		PendingMail_ListAll pendingMail_ListAll= contact_Settings.pendingPostcards();
		pendingMail_ListAll.clickActions();
		boolean condition= pendingMail_ListAll.isElementDisplayed();
		Assert.assertTrue(condition);
		pendingMail_ListAll.clickActions();
		boolean condition1= pendingMail_ListAll.isElementDisplayed();
		Assert.assertFalse(condition1);
	}
}
