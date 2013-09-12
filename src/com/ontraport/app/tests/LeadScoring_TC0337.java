package com.ontraport.app.tests;

import org.junit.Assert;
import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Contact_Settings;
import com.ontraport.app.pages.LeadScoring_Edit;
import com.ontraport.app.parts.SiteMenu;
import com.ontraport.app.tools.AbstractTest;
import com.ontraport.app.tools.Common;

public class LeadScoring_TC0337 extends AbstractTest{
	

	
	
	@Test
	public void testLeadScoring_AfieldMeetsAGivenCriteriaLongText() throws Exception {
		LeadScoring_Edit leadScoringEditPgObj = navigateToLeadScoringPage ();
		
		
		leadScoringEditPgObj = leadScoringEditPgObj.clearAllConditions();
		leadScoringEditPgObj.clickSaveButton();
		Common.waitForPage(driver, 3);
			
		leadScoringEditPgObj = navigateToLeadScoringPage ();
		leadScoringEditPgObj = leadScoringEditPgObj.clickAddNewCondition();	
		
		String[] placeHolders = {"Select Condition", "Select Field...", "Select Condition..."};
		String[] selectOptions = {"Field is this value", "SelLongText", "Equal To"};
		
		leadScoringEditPgObj = leadScoringEditPgObj.selectDropDownsBasedOnConditions (placeHolders, selectOptions);
		leadScoringEditPgObj = leadScoringEditPgObj.typeIntoTextArea ("SeleniumLongTest",1);
		
		//leadScoringEditPgObj = leadScoringEditPgObj.typeIntoTextBoxBasedOnIndex(3,"seleniumTest");
		
		leadScoringEditPgObj = leadScoringEditPgObj.assignLeadScoringvalue("11");
		leadScoringEditPgObj.clickSaveButton();
		Common.waitForPage(driver, 3);
			
		leadScoringEditPgObj = navigateToLeadScoringPage ();
		
		boolean b = leadScoringEditPgObj.verifyTheValueInDropDownBasedOnPlaceHolder ("Select Field...", "SelLongText");
		boolean b1 = leadScoringEditPgObj.verifyTheValueInDropDownBasedOnPlaceHolder ("Select Condition...", "Equal To");	
		boolean b2 = leadScoringEditPgObj.verifyValueOfTxtBoxBasedOnIndex(1, "SeleniumLongTest");
		boolean b3 = leadScoringEditPgObj.verifyScoreValue("11");
		
		System.out.println(b);
		System.out.println(b1);
		System.out.println(b2);
		System.out.println(b3);
		
		
		Assert.assertTrue ("Select Field Comparision", b);
		Assert.assertTrue ("Condition selected", b1);
		Assert.assertTrue ("Long Text", b2);
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
