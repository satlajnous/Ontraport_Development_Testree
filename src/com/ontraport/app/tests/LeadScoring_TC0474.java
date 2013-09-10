package com.ontraport.app.tests;

import org.junit.Assert;
import org.junit.Test;

import com.ontraport.app.pages.Contact_Settings;
import com.ontraport.app.pages.LeadScoring_Edit;
import com.ontraport.app.parts.SiteMenu;
import com.ontraport.app.tools.AbstractTest;
import com.ontraport.app.tools.Common;

public class LeadScoring_TC0474 extends AbstractTest {
	
	@Test
	public void testLeadScoring_HasOpenedEmailCertainNoTimes() throws Exception {
		LeadScoring_Edit leadScoringEditPgObj = navigateToLeadScoringPage ();
		
		
		leadScoringEditPgObj = leadScoringEditPgObj.clearAllConditions();
		leadScoringEditPgObj.clickSaveButton();
		Common.waitForPage(driver, 60);
			
		leadScoringEditPgObj = navigateToLeadScoringPage ();
		leadScoringEditPgObj = leadScoringEditPgObj.clickAddNewCondition();	
		
		String[] placeHolders = {"Select Condition", "Select E-Mail", "Select..."};
		String[] selectOptions = {"Has opened an E-mail a certain number of times", "Any E-Mail", "Equal To"};
				
		leadScoringEditPgObj = leadScoringEditPgObj.selectDropDownsBasedOnConditions (placeHolders, selectOptions);
		leadScoringEditPgObj = leadScoringEditPgObj.typeIntoTextBoxBasedOnIndex(3,"1");
		
		leadScoringEditPgObj = leadScoringEditPgObj.assignLeadScoringvalue("11");
		leadScoringEditPgObj.clickSaveButton();
		Common.waitForPage(driver, 60);
			
		leadScoringEditPgObj = navigateToLeadScoringPage ();
		
		boolean b = leadScoringEditPgObj.verifyTheValueInDropDownBasedOnPlaceHolder ("Select E-Mail", "Any E-Mail");
		boolean b1 = leadScoringEditPgObj.verifyTheValueInDropDownBasedOnPlaceHolder ("Select...", "Equal To");	
		boolean b2 = leadScoringEditPgObj.verifyValueOfTxtBoxBasedOnIndex(3, "1");
		boolean b3 = leadScoringEditPgObj.verifyScoreValue("11");
		
		System.out.println(b);
		System.out.println(b1);
		System.out.println(b2);
		System.out.println(b3);
		
		
		Assert.assertTrue ("E-Mail", b);
		Assert.assertTrue ("Condition", b1);
		Assert.assertTrue ("number of times", b2);
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