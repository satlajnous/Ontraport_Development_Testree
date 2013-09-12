package com.ontraport.app.tests;

import org.junit.Assert;
import org.junit.Test;

import com.ontraport.app.pages.Contact_Settings;
import com.ontraport.app.pages.LeadScoring_Edit;
import com.ontraport.app.parts.SiteMenu;
import com.ontraport.app.tools.AbstractTest;
import com.ontraport.app.tools.Common;

public class LeadScoring_TC0508 extends AbstractTest {
	
	@Test
	public void testLeadScoring_Degradation_TryWholeNumbers() throws Exception {
		LeadScoring_Edit leadScoringEditPgObj = navigateToLeadScoringPage ();
	
		leadScoringEditPgObj = leadScoringEditPgObj.clearScoreDegradation();
		leadScoringEditPgObj.clickSaveButton();
		Common.waitForPage(driver, 3);
			
		leadScoringEditPgObj = navigateToLeadScoringPage ();
				
		leadScoringEditPgObj = leadScoringEditPgObj.assignScoreDegradationValue("10");
		leadScoringEditPgObj.clickSaveButton();
		Common.waitForPage(driver, 3);
			
		leadScoringEditPgObj = navigateToLeadScoringPage ();
			
		boolean b1 = leadScoringEditPgObj.verifyScoreDegradationValue("10");	
		System.out.println(b1);
		Assert.assertTrue ("Score value", b1);
	}
	
	
	public LeadScoring_Edit navigateToLeadScoringPage () throws Exception{
		SiteMenu siteMenu = (SiteMenu) new SiteMenu().init();
		Common.waitForPage(driver, 3);
		siteMenu.contacts();
		siteMenu.contact_Settings();
		
		Contact_Settings contactSettings = (Contact_Settings) new Contact_Settings().init();
		Common.waitForPage(driver,3);
		LeadScoring_Edit leadScoringEditPgObj = contactSettings.leadScoring();
		Common.waitForPage(driver,3);
		return leadScoringEditPgObj;
	}

}
