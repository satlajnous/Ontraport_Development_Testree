package com.ontraport.app.tests;

import org.junit.Assert;
import org.junit.Test;

import com.ontraport.app.pages.Contact_Settings;
import com.ontraport.app.pages.LeadScoring_Edit;
import com.ontraport.app.parts.SiteMenu;
import com.ontraport.app.tools.AbstractTest;
import com.ontraport.app.tools.Common;

public class LeadScoring_TC0477 extends AbstractTest {
	
	@Test
	public void testLeadScoring_IsSubscribedToAProduct() throws Exception {
		LeadScoring_Edit leadScoringEditPgObj = navigateToLeadScoringPage ();
	
		leadScoringEditPgObj = leadScoringEditPgObj.clearAllFields();
		leadScoringEditPgObj.clickSaveButton();
		Common.waitForPage(driver, 3);
			
		leadScoringEditPgObj = navigateToLeadScoringPage ();
		leadScoringEditPgObj = leadScoringEditPgObj.clickAddNewCondition();	
		
		String[] placeHolders = {"Select Condition", "Select Subscription Product"};
		String[] selectOptions = {"Is subscribed to product", "Any Subscription Product"};
				
		leadScoringEditPgObj = leadScoringEditPgObj.selectDropDownsBasedOnConditions (placeHolders, selectOptions);
				
		leadScoringEditPgObj = leadScoringEditPgObj.assignLeadScoringvalue("11");
		leadScoringEditPgObj.clickSaveButton();
		Common.waitForPage(driver, 3);
			
		leadScoringEditPgObj = navigateToLeadScoringPage ();
		
		boolean b1 = leadScoringEditPgObj.verifyTheValueInDropDownBasedOnPlaceHolder ("Select Subscription Product", "Any Subscription Product");	
		boolean b3 = leadScoringEditPgObj.verifyScoreValue("11");
		
		System.out.println(b1);
		System.out.println(b3);
		
		
		Assert.assertTrue ("Subscription Product", b1);
		Assert.assertTrue ("Score value", b3);
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
