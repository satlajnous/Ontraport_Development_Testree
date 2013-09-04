package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

import com.ontraport.app.parts.ActionsMenu;
import com.ontraport.app.parts.SiteMenu;
import com.ontraport.app.tools.AbstractTest;
import com.ontraport.app.tools.Common;

public class AddGroup extends AbstractTest
{

	@Test
	public void test() throws Exception {
		SiteMenu siteMenu = (SiteMenu) new SiteMenu().init();
		Common.waitForPage(driver, 30);
		siteMenu.contacts();
		
		ActionsMenu actionsMenu = (ActionsMenu) new ActionsMenu().init();
		Common.waitForPage(driver, 30);
		actionsMenu.createGroup(common.prop("GROUPNAME"), common.prop("GROUPVALUE"));
		
		ActionsMenu actionsMenu2 = (ActionsMenu) new ActionsMenu().init();
		Common.waitForPage(driver, 30);
		actionsMenu2.selectGroupAll();
		actionsMenu2.clickGroupDropDown();
		
		if(driver.findElements(By.xpath("//div[.='" +common.prop("GROUPNAME")+ "']")).size()==0)
        {
        	fail("Can't find created contact");
        }
		
		actionsMenu2.clickGroupDropDown();
	}

}
