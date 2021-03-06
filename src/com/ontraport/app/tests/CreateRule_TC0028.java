package com.ontraport.app.tests;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Rule_Create;
import com.ontraport.app.pages.Rule_Edit;
import com.ontraport.app.pages.Rule_ListAll;
import com.ontraport.app.pages.Sequence_CreateDate;
import com.ontraport.app.pages.Sequence_ListAll;
import com.ontraport.app.pages.Sequence_TypeSelection;
import com.ontraport.app.parts.SiteMenu;
import com.ontraport.app.tools.AbstractTest;
import com.ontraport.app.tools.Common;

public class CreateRule_TC0028 extends AbstractTest {
	String ruleName = "SelRule" + Calendar.getInstance().getTimeInMillis();
	String seqName = "DateSeq" + Calendar.getInstance().getTimeInMillis();
	
	@Test
	public void testCreateRule_WhenContactIsAddedToSeq_Date()
			throws Exception {
		
		createDateSeq(seqName);
		Rule_ListAll ruleListAll = navigateToRulesPage();

		Rule_Create ruleCreate = ruleListAll.ruleCreate();
		Common.waitForPage(driver, 3);
		ruleCreate= ruleCreate.inputRuleName(ruleName);
		Common.waitForPage(driver, 2);
		String[] placeHolders = { "Select Trigger...", "Select Sequence" };
		String[] selectOptions = { "When Contact is added to Sequence", seqName};

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
		boolean b3 = ruleEdit.verifyWhenThisHappensText("When Contact is added to Sequence:");
		boolean b4 = ruleEdit.verifyTheValueInDropDownBasedOnPlaceHolder("Select Sequence",seqName);
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
		SiteMenu siteMenu= (SiteMenu) new SiteMenu().init();
		Common.waitForPage(driver, 3);
		
		Contact_ListAll contact_ListAll = siteMenu.contacts();
		Common.waitForPage(driver, 3);
		Rule_ListAll ruleListAll = contact_ListAll.navRules();
		return ruleListAll;
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
