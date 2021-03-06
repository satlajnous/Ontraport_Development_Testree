package com.ontraport.app.tests;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Contact_Settings;
import com.ontraport.app.pages.LeadScoring_Edit;
import com.ontraport.app.pages.Sequence_CreateDate;
import com.ontraport.app.pages.Sequence_ListAll;
import com.ontraport.app.pages.Sequence_TypeSelection;
import com.ontraport.app.parts.SiteMenu;
import com.ontraport.app.tools.AbstractTest;
import com.ontraport.app.tools.Common;

public class LeadScoring_TC0331  extends AbstractTest {
	String seqName = "DateSeq" + Calendar.getInstance().getTimeInMillis();
	@Test
	public void testLeadScoring_SubscriptionToSeqPaused_Date()throws Exception {
		createDateSeq(seqName);
		LeadScoring_Edit leadScoringEditPgObj = navigateToLeadScoringPage();

		leadScoringEditPgObj = leadScoringEditPgObj.clearAllFields();
		leadScoringEditPgObj.clickSaveButton();
		Common.waitForPage(driver, 3);

		leadScoringEditPgObj = navigateToLeadScoringPage();
		leadScoringEditPgObj = leadScoringEditPgObj.clickAddNewCondition();

		String[] placeHolders = { "Select Condition", "Select Sequence"};
		String[] selectOptions = {"Subscription to a sequence is paused", seqName };

		leadScoringEditPgObj = leadScoringEditPgObj.selectDropDownsBasedOnConditions(placeHolders, selectOptions);
		leadScoringEditPgObj = leadScoringEditPgObj.assignLeadScoringvalue("10");
		leadScoringEditPgObj.clickSaveButton();
		Common.waitForPage(driver, 3);

		leadScoringEditPgObj = navigateToLeadScoringPage();

		boolean b1 = leadScoringEditPgObj.verifyTheValueInDropDownBasedOnPlaceHolder("Select Sequence",seqName);
		boolean b2 = leadScoringEditPgObj.verifyScoreValue("10");

		System.out.println(b1);
		System.out.println(b2);


		Assert.assertTrue("Condition", b1);
		Assert.assertTrue("Score value", b2);
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
	
	public void createDateSeq(String seqName) throws Exception{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll()
				.init();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Sequence_ListAll seqListAll = contactListAll.navSequences();
		Sequence_TypeSelection seqType = seqListAll.clickNewSequence();
		Sequence_CreateDate seqDate = seqType.clickCreateDateSeq();
		seqListAll=seqDate.createDateSeq(seqName);
		seqListAll.setHundredRecordsPerPage();
		boolean condition = seqListAll.isElementPresent(seqName);
		Assert.assertTrue(condition);
	}
}
