package com.ontraport.app.tests;

import org.junit.Assert;
import org.junit.Test;

import com.ontraport.app.pages.Contact_Settings;
import com.ontraport.app.pages.LeadScoring_Edit;
import com.ontraport.app.parts.SiteMenu;
import com.ontraport.app.tools.AbstractTest;
import com.ontraport.app.tools.Common;

public class LeadScoring_TC0484 extends AbstractTest {
	
	@Test
	public void testLeadScoring_TC0484_SMSDoesNotContainText() throws Exception {
		LeadScoring_Edit leadScoringEditPgObj = navigateToLeadScoringPage ();
		
		
		leadScoringEditPgObj = leadScoringEditPgObj.clearAllFields();
//		leadScoringEditPgObj = leadScoringEditPgObj.clearAllConditions();
		leadScoringEditPgObj.clickSaveButton();
		Common.waitForPage(driver, 3);
			
		leadScoringEditPgObj = navigateToLeadScoringPage ();
		leadScoringEditPgObj = leadScoringEditPgObj.clickAddNewCondition();	
		
		String[] placeHolders = {"Select Condition"};
		String[] selectOptions = {"SMS Does Not Contain Text"};
				
		leadScoringEditPgObj = leadScoringEditPgObj.selectDropDownsBasedOnConditions (placeHolders, selectOptions);
		leadScoringEditPgObj = leadScoringEditPgObj.typeIntoTextBoxBasedOnIndex(1,"Test");
		leadScoringEditPgObj = leadScoringEditPgObj.assignLeadScoringvalue("11");
		leadScoringEditPgObj.clickSaveButton();
		Common.waitForPage(driver, 3);
			
		leadScoringEditPgObj = navigateToLeadScoringPage ();
		boolean b1 = leadScoringEditPgObj.contactScoringWithConditionText("SMS Does Not Contain");
		boolean b2 = leadScoringEditPgObj.verifyValueOfTxtBoxBasedOnIndex(1, "Test");
		boolean b3 = leadScoringEditPgObj.verifyScoreValue("11");
		
		System.out.println(b1);
		System.out.println(b3);
		
		
		Assert.assertTrue ("Condition", b1);
		Assert.assertTrue ("Text", b2);
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
