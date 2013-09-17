package com.ontraport.app.tests;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;

import com.ontraport.app.pages.Account_View;
import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Rule_Create;
import com.ontraport.app.pages.Rule_Edit;
import com.ontraport.app.pages.Rule_ListAll;
import com.ontraport.app.pages.Tag_Create;
import com.ontraport.app.pages.Tag_ListAll;
import com.ontraport.app.parts.SiteMenu;
import com.ontraport.app.tools.AbstractTest;
import com.ontraport.app.tools.Common;

public class CreateRule_TC0051 extends AbstractTest {
	String ruleName = "SelRule" + Calendar.getInstance().getTimeInMillis();
	String tagName = "SelTag" + Calendar.getInstance().getTimeInMillis();
	@Test
	public void testCreateRule_WhenContactIsRemovedFromTag()
			throws Exception {
		createTag(tagName);
		Rule_ListAll ruleListAll = navigateToRulesPage();

		Rule_Create ruleCreate = ruleListAll.ruleCreate();
		Common.waitForPage(driver, 3);
		ruleCreate= ruleCreate.inputRuleName(ruleName);
		Common.waitForPage(driver, 2);
		String[] placeHolders = { "Select Trigger...", "Select Tag"};
		String[] selectOptions = { "When Contact is removed from Tag", tagName};

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
		boolean b3= ruleEdit.verifyWhenThisHappensText("When Contact is removed from Tag:");
		boolean b4 = ruleEdit.verifyTheValueInDropDownBasedOnPlaceHolder("Select Tag", tagName);
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
	
	public void createTag(String tagName) throws Exception{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Contact_ListAll contact_ListAll = (Contact_ListAll) new Contact_ListAll().init();
        Account_View accView= contact_ListAll.navAdmin();
        Tag_ListAll tagListAll= accView.clickManageTags();
        Tag_Create tagCreate= tagListAll.create();
        tagListAll=tagCreate.newTag(tagName);
        tagListAll.setHundredRecordsPerPage();
        boolean condition= tagListAll.isElementPresent(tagName);
        Assert.assertTrue(condition);
	}

}
