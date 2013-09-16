package com.ontraport.app.tests;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Rule_Create;
import com.ontraport.app.pages.Rule_Edit;
import com.ontraport.app.pages.Rule_ListAll;
import com.ontraport.app.parts.SiteMenu;
import com.ontraport.app.tools.AbstractTest;
import com.ontraport.app.tools.Common;

public class CreateRule_TC0033 extends AbstractTest {
	String ruleName = "SelRule" + Calendar.getInstance().getTimeInMillis();
	
	@Test
	public void testCreateRule_SubscriptionToSeqUnpaused_Step()
			throws Exception {
		Rule_ListAll ruleListAll = navigateToRulesPage();

		Rule_Create ruleCreate = ruleListAll.ruleCreate();
		Common.waitForPage(driver, 3);
		ruleCreate= ruleCreate.inputRuleName(ruleName);
		Common.waitForPage(driver, 2);
		String[] placeHolders = { "Select Trigger...", "Select Sequence" };
		String[] selectOptions = { "Subscription to Sequence is Unpaused", "Any Sequence" };

		ruleCreate = ruleCreate.selectDropDownsBasedOnConditions(placeHolders,selectOptions);
		Common.waitForPage(driver, 2);
		String[] placeHolders1 = { "Select Action..." };
		String[] selectOptions1 = { "Recharge all declined transactions" };
		ruleCreate = ruleCreate.selectDropDownsBasedOnConditions(placeHolders1,selectOptions1);
		ruleListAll= ruleCreate.clickSaveButton();
		Common.waitForPage(driver, 3);
		ruleListAll.setHundredRecordsPerPage();
		boolean b1= ruleListAll.isElementPresent(ruleName);
		Assert.assertTrue("Rule Created", b1);
		
		Rule_Edit ruleEdit= ruleListAll.editRule(ruleName);
		Common.waitForPage(driver, 3);
		
		boolean b2=ruleEdit.verifyRuleName(ruleName);
		boolean b3= ruleEdit.verifyWhenThisHappensText("Subscription to ");
		boolean b4 = ruleEdit.verifyTheValueInDropDownBasedOnPlaceHolder("Select Sequence","Any Sequence");
		boolean b5= ruleEdit.verifyWhenThisHappensText(" is unpaused");
		boolean b6 = ruleEdit.verifyThenDoThisText("Recharge all declined transactions");
		
		System.out.println(b2);
		System.out.println(b3);
		System.out.println(b4);
		System.out.println(b5);
		System.out.println(b6);
		
		Assert.assertTrue("Rule Name", b2);
		Assert.assertTrue("When This Happens", b3);
		Assert.assertTrue("When This Happens", b4);
		Assert.assertTrue("When This Happens", b5);
		Assert.assertTrue("Then Do This", b6);

	}

	public Rule_ListAll navigateToRulesPage() throws Exception {
		SiteMenu siteMenu= (SiteMenu) new SiteMenu().init();
		Common.waitForPage(driver, 3);
		
		Contact_ListAll contact_ListAll = siteMenu.contacts();
		Common.waitForPage(driver, 3);
		Rule_ListAll ruleListAll = contact_ListAll.navRules();
		return ruleListAll;
	}



}
