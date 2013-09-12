package com.ontraport.app.tests;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Rule_Create;
import com.ontraport.app.pages.Rule_Edit;
import com.ontraport.app.pages.Rule_ListAll;
import com.ontraport.app.tools.AbstractTest;
import com.ontraport.app.tools.Common;

public class CreateRule_TC0027 extends AbstractTest {
	String ruleName = "SelRule" + Calendar.getInstance().getTimeInMillis();
	
	@Test
	public void testCreateRule_WhenContactIsAddedToSeq_Step()
			throws Exception {
		Rule_ListAll ruleListAll = navigateToRulesPage();

		Rule_Create ruleCreate = ruleListAll.ruleCreate();
		Common.waitForPage(driver, 3);
		ruleCreate= ruleCreate.inputRuleName(ruleName);
		Common.waitForPage(driver, 2);
		String[] placeHolders = { "Select Trigger...", "Select Sequence" };
		String[] selectOptions = { "When Contact is added to Sequence", "Any Sequence" };

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
		boolean b3 = ruleEdit.verifyWhenThisHappensTextWithCondition("When Contact is added to Sequence:");
		boolean b4 = ruleEdit.verifyTheValueInDropDownBasedOnPlaceHolder("Select Sequence","Any Sequence");
		boolean b5 = ruleEdit.verifyThenDoThisText("Recharge all declined transactions");
		
		System.out.println(b2);
		System.out.println(b3);
		System.out.println(b4);
		System.out.println(b5);
		
		Assert.assertTrue("Rule Name", b2);
		Assert.assertTrue("When This Happens", b3);
		Assert.assertTrue("When This Happens", b4);
		Assert.assertTrue("Then Do This", b5);

	}

	public Rule_ListAll navigateToRulesPage() throws Exception {
		Contact_ListAll contact_ListAll = (Contact_ListAll) new Contact_ListAll()
				.init();
		Common.waitForPage(driver, 30);
		Rule_ListAll ruleListAll = contact_ListAll.navRules();
		return ruleListAll;
	}

}
