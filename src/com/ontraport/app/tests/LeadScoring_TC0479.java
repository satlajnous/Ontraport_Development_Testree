package com.ontraport.app.tests;

import org.junit.Assert;
import org.junit.Test;

import com.ontraport.app.pages.Contact_Settings;
import com.ontraport.app.pages.LeadScoring_Edit;
import com.ontraport.app.parts.SiteMenu;
import com.ontraport.app.tools.AbstractTest;
import com.ontraport.app.tools.Common;

public class LeadScoring_TC0479 extends AbstractTest {
	
	@Test
	public void testLeadScoring_IfContactSubscribedFulfillmentList() throws Exception {
		LeadScoring_Edit leadScoringEditPgObj = navigateToLeadScoringPage ();
		
		
		leadScoringEditPgObj = leadScoringEditPgObj.clearAllConditions();
		leadScoringEditPgObj.clickSaveButton();
		Common.waitForPage(driver, 60);
			
		leadScoringEditPgObj = navigateToLeadScoringPage ();
		leadScoringEditPgObj = leadScoringEditPgObj.clickAddNewCondition();	
		
		String[] placeHolders = {"Select Condition", "Select Fulfillment List"};
		String[] selectOptions = {"If Contact is subscribed to Fulfillment List", "Any Fulfillment List"};
				
		leadScoringEditPgObj = leadScoringEditPgObj.selectDropDownsBasedOnConditions (placeHolders, selectOptions);
				
		leadScoringEditPgObj = leadScoringEditPgObj.assignLeadScoringvalue("11");
		leadScoringEditPgObj.clickSaveButton();
		Common.waitForPage(driver, 60);
			
		leadScoringEditPgObj = navigateToLeadScoringPage ();
		
		boolean b1 = leadScoringEditPgObj.verifyTheValueInDropDownBasedOnPlaceHolder ("Select Fulfillment List", "Any Fulfillment List");	
		boolean b3 = leadScoringEditPgObj.verifyScoreValue("11");
		
		System.out.println(b1);
		System.out.println(b3);
		
		
		Assert.assertTrue ("Fulfillment List", b1);
		Assert.assertTrue ("Score value", b3);
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
