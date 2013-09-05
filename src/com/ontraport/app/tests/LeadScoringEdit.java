package com.ontraport.app.tests;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Contact_Settings;
import com.ontraport.app.pages.LeadScoring_Edit;
import com.ontraport.app.parts.SiteMenu;
import com.ontraport.app.tools.AbstractTest;
import com.ontraport.app.tools.Common;

public class LeadScoringEdit extends AbstractTest{
	
	@Test
	public void testLeadScoring_VisitedLandingPageCertainNoTimes() throws Exception {
		SiteMenu siteMenu = (SiteMenu) new SiteMenu().init();
		Common.waitForPage(driver, 30);
		siteMenu.contacts();
		siteMenu.contact_Settings();
		
		Contact_Settings contact_Settings = (Contact_Settings) new Contact_Settings().init();
		Common.waitForPage(driver, 30);
		LeadScoring_Edit leadScoring= contact_Settings.leadScoring();
		Common.waitForPage(driver, 30);
		String condition="Has visited a landing page a certain number of times";
		Contact_ListAll contact_ListAll= leadScoring.selectCondition_VisitLandingPage(condition /*,"Select Condition","Select Landing Page","Select..."*/);
		Common.waitForPage(driver, 30);
		contact_Settings= siteMenu.contact_Settings();
		Common.waitForPage(driver, 30);
		leadScoring=contact_Settings.leadScoring();
		Common.waitForPage(driver, 30);
		contact_ListAll=leadScoring.clearFields();
	//	Common.waitForPage(driver, 30);
	//	contact_ListAll.logout();
	}
	
	@Test
	public void testLeadScoring_FieldIsThisValue() throws Exception {
		SiteMenu siteMenu = (SiteMenu) new SiteMenu().init();
		Common.waitForPage(driver, 30);
		siteMenu.contacts();
		siteMenu.contact_Settings();
		
		Contact_Settings contactSettings = (Contact_Settings) new Contact_Settings().init();
		Common.waitForPage(driver, 30);
		LeadScoring_Edit leadScoring= contactSettings.leadScoring();
		Common.waitForPage(driver, 30);
		String condition="Field is this value";
		Contact_ListAll contact_ListAll= leadScoring.selectCondition_FieldIsThisValue(condition);
		Common.waitForPage(driver, 30);
		contactSettings= siteMenu.contact_Settings();
		Common.waitForPage(driver, 30);
		leadScoring=contactSettings.leadScoring();
		Common.waitForPage(driver, 30);
		contact_ListAll=leadScoring.clearFields();
	//	Common.waitForPage(driver, 30);
	//	contact_ListAll.logout();
	}
	
	@Test
	public void testLeadScoring_SubscriptionToSeqPaused() throws Exception {
		SiteMenu siteMenu = (SiteMenu) new SiteMenu().init();
		Common.waitForPage(driver, 30);
		siteMenu.contacts();
		siteMenu.contact_Settings();
		
		Contact_Settings contactSettings = (Contact_Settings) new Contact_Settings().init();
		Common.waitForPage(driver, 30);
		LeadScoring_Edit leadScoring= contactSettings.leadScoring();
		Common.waitForPage(driver, 30);
		String condition="Subscription to a sequence is paused";
		Contact_ListAll contactListAll= leadScoring.selectCondition_Sequences(condition);
		Common.waitForPage(driver, 30);
		contactSettings= siteMenu.contact_Settings();
		Common.waitForPage(driver, 30);
		leadScoring=contactSettings.leadScoring();
		Common.waitForPage(driver, 30);
		contactListAll=leadScoring.clearFields();
	//	Common.waitForPage(driver, 30);
	//	contact_ListAll.logout();
	}

}
