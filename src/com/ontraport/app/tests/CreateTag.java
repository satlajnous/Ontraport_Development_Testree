package com.ontraport.app.tests;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;

import com.ontraport.app.pages.Account_View;
import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Tag_Create;
import com.ontraport.app.pages.Tag_ListAll;
import com.ontraport.app.tools.AbstractTest;
import com.ontraport.app.tools.Common;

public class CreateTag extends AbstractTest
{
	@Test
	public void testCreateTag () throws Exception{
		Contact_ListAll contact_ListAll = (Contact_ListAll) new Contact_ListAll().init();
        Common.waitForPage(driver, 30);
        Account_View accView= contact_ListAll.navAdmin();
        Common.waitForPage(driver, 30);
        Tag_ListAll tagListAll= accView.clickManageTags();
        Common.waitForPage(driver, 30);
        Tag_Create tagCreate= tagListAll.create();
        Common.waitForPage(driver, 30);
        String tagName= "SelTag" + Calendar.getInstance().getTimeInMillis();
        tagListAll=tagCreate.newTag(tagName);
        Common.waitForPage(driver, 30);
        boolean condition= tagListAll.isElementPresent(tagName);
        Assert.assertTrue(condition);
        tagListAll.logout();
}
}
