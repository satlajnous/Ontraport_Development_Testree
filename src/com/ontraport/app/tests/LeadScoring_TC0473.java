package com.ontraport.app.tests;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;

import com.ontraport.app.pages.Contact_Settings;
import com.ontraport.app.pages.LandingPage_Create;
import com.ontraport.app.pages.LandingPage_ListAll;
import com.ontraport.app.pages.LandingPage_TypeSelection;
import com.ontraport.app.pages.LeadScoring_Edit;
import com.ontraport.app.parts.SiteMenu;
import com.ontraport.app.tools.AbstractTest;
import com.ontraport.app.tools.Common;

public class LeadScoring_TC0473 extends AbstractTest {
	String lpName = "SelLP" + Calendar.getInstance().getTimeInMillis();
	String URL="SelTest"+Calendar.getInstance().getTimeInMillis();
	
	@Test
	public void testLeadScoring_HasVisitedLandingPageCertainNoOfTimes()throws Exception {
		createLP(lpName, URL);
		LeadScoring_Edit leadScoringEditPgObj = navigateToLeadScoringPage();

		leadScoringEditPgObj = leadScoringEditPgObj.clearAllFields();
		leadScoringEditPgObj.clickSaveButton();
		Common.waitForPage(driver, 3);

		leadScoringEditPgObj = navigateToLeadScoringPage ();
		leadScoringEditPgObj = leadScoringEditPgObj.clickAddNewCondition();	
		
		String[] placeHolders = {"Select Condition", "Select Landing Page", "Select..."};
		String[] selectOptions = {"Has visited a landing page a certain number of times", lpName, "Equal To"};
				
		leadScoringEditPgObj = leadScoringEditPgObj.selectDropDownsBasedOnConditions (placeHolders, selectOptions);
		leadScoringEditPgObj = leadScoringEditPgObj.typeIntoTextBoxBasedOnIndex(3,"1");
		
		leadScoringEditPgObj = leadScoringEditPgObj.assignLeadScoringvalue("11");
		leadScoringEditPgObj.clickSaveButton();
		Common.waitForPage(driver, 3);

		leadScoringEditPgObj = navigateToLeadScoringPage();

		boolean b = leadScoringEditPgObj.verifyTheValueInDropDownBasedOnPlaceHolder ("Select Landing Page", lpName);
		boolean b1 = leadScoringEditPgObj.verifyTheValueInDropDownBasedOnPlaceHolder ("Select...", "Equal To");	
		boolean b2 = leadScoringEditPgObj.verifyValueOfTxtBoxBasedOnIndex(3, "1");
		boolean b3 = leadScoringEditPgObj.verifyScoreValue("11");
		
		System.out.println(b);
		System.out.println(b1);
		System.out.println(b2);
		System.out.println(b3);
		
		
		Assert.assertTrue ("Landing Page", b);
		Assert.assertTrue ("Condition", b1);
		Assert.assertTrue ("number of times", b2);
		Assert.assertTrue ("Score value", b3);
	}

	public LeadScoring_Edit navigateToLeadScoringPage() throws Exception {
		SiteMenu siteMenu =(SiteMenu) new SiteMenu().init();
		Common.waitForPage(driver, 3);
		siteMenu.contacts();
		siteMenu.contact_Settings();

		Contact_Settings contactSettings = (Contact_Settings) new Contact_Settings().init();
		Common.waitForPage(driver, 3);
		LeadScoring_Edit leadScoringEditPgObj = contactSettings.leadScoring();
		Common.waitForPage(driver, 3);
		return leadScoringEditPgObj;
	}
	
	public void createLP(String lpName, String URL) throws Exception{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		SiteMenu sitemenu = (SiteMenu) new SiteMenu().init();
		LandingPage_ListAll lpListAll= sitemenu.clickLandingPages();
		LandingPage_TypeSelection lpTypeSelect= lpListAll.clickNewLandingPage();
		LandingPage_Create lpCreate=lpTypeSelect.createEasyPages();
		lpListAll=lpCreate.createNewLandingPage(lpName, URL);
		lpListAll.setHundredRecordsPerPage();
		boolean condition= lpListAll.isElementPresent(lpName);
		Assert.assertTrue(condition);
	}

}
