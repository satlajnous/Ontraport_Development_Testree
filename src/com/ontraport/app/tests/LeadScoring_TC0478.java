package com.ontraport.app.tests;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;

import com.ontraport.app.pages.Contact_Settings;
import com.ontraport.app.pages.LeadScoring_Edit;
import com.ontraport.app.parts.SiteMenu;
import com.ontraport.app.tools.AbstractTest;
import com.ontraport.app.tools.Common;

public class LeadScoring_TC0478 extends AbstractTest {
	
	@Test
	public void testLeadScoring_HasBeenSubscribedProductCertainAmountTime() throws Exception {
		LeadScoring_Edit leadScoringEditPgObj = navigateToLeadScoringPage ();
		
		
		leadScoringEditPgObj = leadScoringEditPgObj.clearAllConditions();
		leadScoringEditPgObj.clickSaveButton();
		Common.waitForPage(driver, 6);
			
		leadScoringEditPgObj = navigateToLeadScoringPage ();
		leadScoringEditPgObj = leadScoringEditPgObj.clickAddNewCondition();	
		
		String[] placeHolders = {"Select Condition", "Select Subscription Product", "Select..."};
		String[] selectOptions = {"Has been subscribed to a product for a certain amount of time", "Any Subscription Product", "Days"};
				
		leadScoringEditPgObj = leadScoringEditPgObj.selectDropDownsBasedOnConditions (placeHolders, selectOptions);
		leadScoringEditPgObj = leadScoringEditPgObj.typeIntoTextBoxBasedOnIndex(2,"1");
		
		leadScoringEditPgObj = leadScoringEditPgObj.assignLeadScoringvalue("11");
		leadScoringEditPgObj.clickSaveButton();
		Common.waitForPage(driver, 6);
			
		leadScoringEditPgObj = navigateToLeadScoringPage ();
		
		boolean b = leadScoringEditPgObj.verifyTheValueInDropDownBasedOnPlaceHolder ("Select Subscription Product", "Any Subscription Product");
		boolean b1 = leadScoringEditPgObj.verifyTheValueInDropDownBasedOnPlaceHolder ("Select...", "Days");	
		boolean b2 = leadScoringEditPgObj.verifyValueOfTxtBoxBasedOnIndex(2, "1");
		boolean b3 = leadScoringEditPgObj.verifyScoreValue("11");
		
		System.out.println(b);
		System.out.println(b1);
		System.out.println(b2);
		System.out.println(b3);
		
		
		Assert.assertTrue ("Subscription", b);
		Assert.assertTrue ("Subscription Product", b1);
		Assert.assertTrue ("number of times", b2);
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

