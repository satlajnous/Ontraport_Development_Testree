package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.User_Edit;
import com.ontraport.app.parts.ActionsMenu;
import com.ontraport.app.parts.DialogBox;
import com.ontraport.app.parts.SiteMenu;
import com.ontraport.app.parts.UserMenu;
import com.ontraport.app.tools.AbstractTest;
import com.ontraport.app.tools.Common;

public class AddDeleteUserPermissions extends AbstractTest
{

	@Test
	public void testAddDeleteUserPermissions() throws Exception {
		SiteMenu siteMenu = (SiteMenu) new SiteMenu().init();
		Common.waitForPage(driver, 30);
		siteMenu.contacts();
		
		Contact_ListAll contact_ListAll = (Contact_ListAll) new Contact_ListAll().init();
		Common.waitForPage(driver, 30);
		contact_ListAll.openUserMenu();
		
		UserMenu userMenu = (UserMenu) new UserMenu().init();
		Common.waitForPage(driver, 30);
		userMenu.clickPersonalSettings();
		
		User_Edit user_Edit = (User_Edit) new User_Edit().init();
		Common.waitForPage(driver, 30);
		user_Edit.addPermision();
		
		ActionsMenu actionsMenu = (ActionsMenu) new ActionsMenu().init();
		Common.waitForPage(driver, 30);
		actionsMenu.createPermission();

		Common.waitForPage(driver, 30);

		
		if(driver.findElements(By.xpath("//td/span/a[text()='Can View Contacts']")).size()==0)
        {
        	fail("Can't find created permission");
        }
		Common.waitForPage(driver, 30);
		user_Edit.clickDeletePermision();
		
		DialogBox dialogBox = (DialogBox) new DialogBox().init();
        Common.waitForPage(driver, 30);
        dialogBox.acceptMessage();

        Common.waitForPage(driver, 30);

        if(driver.findElements(By.xpath("//td/span/a[text()='Can View Contacts']")).size()>0)
        {
        	fail("Found deleted permission");
        }
	}

}
