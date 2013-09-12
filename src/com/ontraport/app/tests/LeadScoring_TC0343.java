package com.ontraport.app.tests;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;

import com.ontraport.app.pages.Account_View;
import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Contact_Settings;
import com.ontraport.app.pages.LeadScoring_Edit;
import com.ontraport.app.pages.Tag_Create;
import com.ontraport.app.pages.Tag_ListAll;
import com.ontraport.app.parts.SiteMenu;
import com.ontraport.app.tools.AbstractTest;
import com.ontraport.app.tools.Common;

public class LeadScoring_TC0343 extends AbstractTest {
	String tagName = "SelTag" + Calendar.getInstance().getTimeInMillis();
	@Test
	public void testLeadScoring_ContactNotSubscribedToTag()throws Exception {
		createTag(tagName);
		LeadScoring_Edit leadScoringEditPgObj = navigateToLeadScoringPage();

		leadScoringEditPgObj = leadScoringEditPgObj.clearAllFields();
		leadScoringEditPgObj.clickSaveButton();
		Common.waitForPage(driver, 3);

		leadScoringEditPgObj = navigateToLeadScoringPage();
		leadScoringEditPgObj = leadScoringEditPgObj.clickAddNewCondition();

		String[] placeHolders = { "Select Condition", "Select Tag"};
		String[] selectOptions = {"If Contact is not subscribed to Tag", tagName };

		leadScoringEditPgObj = leadScoringEditPgObj.selectDropDownsBasedOnConditions(placeHolders, selectOptions);
		leadScoringEditPgObj = leadScoringEditPgObj.assignLeadScoringvalue("11");
		leadScoringEditPgObj.clickSaveButton();
		Common.waitForPage(driver, 3);

		leadScoringEditPgObj = navigateToLeadScoringPage();

		boolean b1 = leadScoringEditPgObj.verifyTheValueInDropDownBasedOnPlaceHolder("Select Tag",tagName);
		boolean b2 = leadScoringEditPgObj.verifyScoreValue("11");

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
	
	public void createTag(String tagName) throws Exception{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Contact_ListAll contact_ListAll = (Contact_ListAll) new Contact_ListAll().init();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Account_View accView= contact_ListAll.navAdmin();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Tag_ListAll tagListAll= accView.clickManageTags();
        Tag_Create tagCreate= tagListAll.create();
        tagListAll=tagCreate.newTag(tagName);
        boolean condition= tagListAll.isElementPresent(tagName);
        Assert.assertTrue(condition);
	}
}
