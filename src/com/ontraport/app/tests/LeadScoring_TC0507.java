package com.ontraport.app.tests;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Contact_Settings;
import com.ontraport.app.pages.LeadScoring_Edit;
import com.ontraport.app.parts.SiteMenu;
import com.ontraport.app.tools.AbstractTest;
import com.ontraport.app.tools.Common;

public class LeadScoring_TC0507 extends AbstractTest{
	
	@Test
	public void testTC0507_Action_LeadScoring_CancelButton() throws Exception {
		Contact_ListAll contactListAll= (Contact_ListAll) new Contact_ListAll();
		LeadScoring_Edit leadScoringEditPgObj = navigateToLeadScoringPage ();
		contactListAll=leadScoringEditPgObj.clickCancel();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		String pageHeading= contactListAll.getTextHomePage();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		Assert.assertEquals("Contacts", pageHeading);
	}
	
	public LeadScoring_Edit navigateToLeadScoringPage () throws Exception{
		SiteMenu siteMenu = (SiteMenu) new SiteMenu().init();
		Common.waitForPage(driver, 30);
		siteMenu.contacts();
		siteMenu.contact_Settings();
		
		Contact_Settings contactSettings = (Contact_Settings) new Contact_Settings().init();
		Common.waitForPage(driver, 30);
		LeadScoring_Edit leadScoringEditPgObj = contactSettings.leadScoring();
		Common.waitForPage(driver, 30);
		return leadScoringEditPgObj;
	}
}

