package com.ontraport.app.tests;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Rule_Create;
import com.ontraport.app.pages.Rule_ListAll;
import com.ontraport.app.tools.AbstractTest;
import com.ontraport.app.tools.Common;

public class CreateRules extends AbstractTest
{		String whenThisHappens = "Contact is created";
		String thenDoThis ="Recharge all declined transactions";
		String ruleName = "SelRule" + Calendar.getInstance().getTimeInMillis();
		
	@Test
	public void testCreateRule_WhenThisHappens_WhenContactIsCreated () throws Exception{
		Contact_ListAll contact_ListAll = (Contact_ListAll) new Contact_ListAll().init();
        Common.waitForPage(driver, 30);
        Rule_ListAll ruleListAll = contact_ListAll.navRules();
        Common.waitForPage(driver, 30);
        Rule_Create rules= ruleListAll.ruleCreate();
        Common.waitForPage(driver, 30);
        ruleListAll=rules.newRuleWhenThisHappens_ContactIsCreated(ruleName, whenThisHappens, thenDoThis);
        Common.waitForPage(driver, 30);
        boolean condition= ruleListAll.isElementPresent(ruleName);
        Thread.sleep (10000);
        Assert.assertTrue(condition);
        ruleListAll.logout();
	     
	}
	
	 
}
