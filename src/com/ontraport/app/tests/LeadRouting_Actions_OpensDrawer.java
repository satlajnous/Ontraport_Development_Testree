package com.ontraport.app.tests;

import org.junit.Assert;
import org.junit.Test;

import com.ontraport.app.pages.Contact_Settings;
import com.ontraport.app.pages.LeadRouter_ListAll;
import com.ontraport.app.pages.LeadScoring_Edit;
import com.ontraport.app.parts.SiteMenu;
import com.ontraport.app.tools.AbstractTest;
import com.ontraport.app.tools.Common;

public class LeadRouting_Actions_OpensDrawer extends AbstractTest{
	
	@Test
	public void testTC0505_LeadRouting_Actions_OpensDrawer() throws Exception {
		SiteMenu siteMenu = (SiteMenu) new SiteMenu().init();
		Common.waitForPage(driver, 30);
		siteMenu.contacts();
		siteMenu.contact_Settings();
		
		Contact_Settings contactSettings = (Contact_Settings) new Contact_Settings().init();
		Common.waitForPage(driver, 30);
		LeadRouter_ListAll leadRouter_ListAll = contactSettings.leadRouting();
		leadRouter_ListAll.clickActions();
		boolean condition= leadRouter_ListAll.isElementDisplayed();
		Assert.assertTrue(condition);
		leadRouter_ListAll.clickActions();
		boolean condition1= leadRouter_ListAll.isElementDisplayed();
		Assert.assertFalse(condition1);
	}
}
