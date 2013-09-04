package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.parts.ActionsMenu;
import com.ontraport.app.parts.DialogBox;
import com.ontraport.app.parts.SearchBox;
import com.ontraport.app.parts.SiteMenu;
import com.ontraport.app.tools.AbstractTest;
import com.ontraport.app.tools.Common;

public class DeleteContact extends AbstractTest{

	@Test
	public void test() throws Exception {
		SiteMenu siteMenu = (SiteMenu) new SiteMenu().init();
		Common.waitForPage(driver, 30);
		siteMenu.contacts();
		
		Contact_ListAll contact_ListAll = (Contact_ListAll) new Contact_ListAll().init();
		Common.waitForPage(driver, 30);
		contact_ListAll.search();

		SearchBox searchBox = (SearchBox) new SearchBox().init();
        Common.waitForPage(driver, 30);
        searchBox.search(common.prop("FIRSTNAME"));
        
		Common.waitForPage(driver, 30);
		contact_ListAll.selectContacts();
		
		ActionsMenu actionsMenu = (ActionsMenu) new ActionsMenu().init();
        Common.waitForPage(driver, 30);
        actionsMenu.clickDeleteContact();

		DialogBox dialogBox = (DialogBox) new DialogBox().init();
        Common.waitForPage(driver, 30);
        dialogBox.acceptMessage();

        Common.waitForPage(driver, 30);
        searchBox.clearSearch();
        
        Common.waitForPage(driver, 30);
		contact_ListAll.search();
        
        Common.waitForPage(driver, 30);
        searchBox.search(common.prop("FIRSTNAME"));
        
        Common.waitForPage(driver, 30);
        
        if(driver.findElements(By.xpath("//a[normalize-space(text())='" + common.prop("FIRSTNAME") +"']")).size()>0)
        {
        	fail("Found deleted contact");
        }

        Common.waitForPage(driver, 30);
        searchBox.clearSearch();
		
	}

}
