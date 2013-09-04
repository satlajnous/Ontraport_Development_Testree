package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

import com.ontraport.app.pages.Account_View;
import com.ontraport.app.pages.ApiSettings_ListAll;
import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.parts.ActionsMenu;
import com.ontraport.app.parts.DialogBox;
import com.ontraport.app.parts.SearchBox;
import com.ontraport.app.parts.SiteMenu;
import com.ontraport.app.parts.UserMenu;
import com.ontraport.app.tools.AbstractTest;
import com.ontraport.app.tools.Common;

public class DeleteAPIKeys extends AbstractTest{

	@Test
	public void testDeleteAPIKeys() throws Exception {
		SiteMenu siteMenu = (SiteMenu) new SiteMenu().init();
		Common.waitForPage(driver, 30);
		siteMenu.contacts();
		
		Contact_ListAll contact_ListAll = (Contact_ListAll) new Contact_ListAll().init();
		Common.waitForPage(driver, 30);
		contact_ListAll.openUserMenu();
		
		UserMenu userMenu = (UserMenu) new UserMenu().init();
		Common.waitForPage(driver, 30);
		userMenu.clickAdmin();
		
		Account_View account_View = (Account_View) new Account_View().init();
		Common.waitForPage(driver, 30);
		account_View.clickAPI();
		
		SearchBox searchBox = (SearchBox) new SearchBox().init();
        Common.waitForPage(driver, 30);
        searchBox.search(common.prop("APINAME"));
        
		ApiSettings_ListAll apiSettings_ListAll = (ApiSettings_ListAll) new ApiSettings_ListAll().init();
		Common.waitForPage(driver, 30);
		apiSettings_ListAll.selectAPI();
		
		ActionsMenu actionsMenu = (ActionsMenu) new ActionsMenu().init();
        Common.waitForPage(driver, 30);
        actionsMenu.clickDeleteAPI();
        
        DialogBox dialogBox = (DialogBox) new DialogBox().init();
        Common.waitForPage(driver, 30);
        dialogBox.acceptMessage();

        Common.waitForPage(driver, 30);
        searchBox.clearSearch();
        
        Common.waitForPage(driver, 30);
		contact_ListAll.search();
        
        Common.waitForPage(driver, 30);
        searchBox.search(common.prop("APINAME"));
        
        Common.waitForPage(driver, 30);
        
        if(driver.findElements(By.xpath("//a[normalize-space(text())='" + common.prop("APINAME") +"']")).size()>0)
        {
        	fail("Found deleted contact");
        }

        Common.waitForPage(driver, 30);
        searchBox.clearSearch();
	}

}
