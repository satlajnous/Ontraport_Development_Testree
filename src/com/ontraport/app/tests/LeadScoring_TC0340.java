package com.ontraport.app.tests;

import org.junit.Assert;
import org.junit.Test;

//import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Contact_Settings;
import com.ontraport.app.pages.LeadScoring_Edit;
import com.ontraport.app.parts.SiteMenu;
import com.ontraport.app.tools.AbstractTest;
import com.ontraport.app.tools.Common;

public class LeadScoring_TC0340 extends AbstractTest{
	

	
	
	@Test
	public void testLeadScoring_AfieldMeetsAgivenCriteriaState() throws Exception {
		LeadScoring_Edit leadScoringEditPgObj = navigateToLeadScoringPage ();
		
		
		leadScoringEditPgObj = leadScoringEditPgObj.clearAllConditions();
		leadScoringEditPgObj.clickSaveButton();
		Common.waitForPage(driver, 6);
			
		leadScoringEditPgObj = navigateToLeadScoringPage ();
		leadScoringEditPgObj = leadScoringEditPgObj.clickAddNewCondition();	
		
		String[] placeHolders = {"Select Condition", "Select Field...", "Select Condition...", "Select..."};
		String[] selectOptions = {"Field is this value", "SelState", "Equal To","California"};
		
		leadScoringEditPgObj = leadScoringEditPgObj.selectDropDownsBasedOnConditions (placeHolders, selectOptions);
		leadScoringEditPgObj = leadScoringEditPgObj.assignLeadScoringvalue("11");
		leadScoringEditPgObj.clickSaveButton();
		Common.waitForPage(driver, 6);
			
		leadScoringEditPgObj = navigateToLeadScoringPage ();
		
		boolean b = leadScoringEditPgObj.verifyTheValueInDropDownBasedOnPlaceHolder ("Select Field...", "SelState");
		boolean b1 = leadScoringEditPgObj.verifyTheValueInDropDownBasedOnPlaceHolder ("Select Condition...", "Equal To");	
		boolean b2 = leadScoringEditPgObj.verifyTheValueInDropDownBasedOnPlaceHolder("Select...", "California");
		boolean b3 = leadScoringEditPgObj.verifyScoreValue("11");
		
		System.out.println(b);
		System.out.println(b1);
		System.out.println(b2);
		System.out.println(b3);
		
		
		Assert.assertTrue ("Select Field Comparision", b);
		Assert.assertTrue ("Condition selected", b1);
		Assert.assertTrue ("Select Comparision", b2);
		Assert.assertTrue ("Score value", b3);
	}
	
	
	
	
	public LeadScoring_Edit navigateToLeadScoringPage () throws Exception{
		SiteMenu siteMenu = (SiteMenu) new SiteMenu().init();
		Common.waitForPage(driver, 3);
		siteMenu.contacts();
		siteMenu.contact_Settings();
		
		Contact_Settings contactSettings = (Contact_Settings) new Contact_Settings().init();
		Common.waitForPage(driver, 3);
		LeadScoring_Edit leadScoringEditPgObj = contactSettings.leadScoring();
		Common.waitForPage(driver, 3);
		return leadScoringEditPgObj;
	}
	
}
