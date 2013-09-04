package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

import com.ontraport.app.pages.Contact_Settings;
import com.ontraport.app.pages.LeadRouter_ListAll;
import com.ontraport.app.parts.ActionsMenu;
import com.ontraport.app.parts.DialogBox;
import com.ontraport.app.parts.SearchBox;
import com.ontraport.app.parts.SiteMenu;
import com.ontraport.app.tools.AbstractTest;
import com.ontraport.app.tools.Common;

public class DeleteWeightedRandom extends AbstractTest
{

	@Test
	public void testDeleteWeightedRandom() throws Exception {
		SiteMenu siteMenu = (SiteMenu) new SiteMenu().init();
		Common.waitForPage(driver, 30);
		siteMenu.contacts();
		siteMenu.contact_Settings();
		
		Contact_Settings contact_Settings = (Contact_Settings) new Contact_Settings().init();
		Common.waitForPage(driver, 30);
		contact_Settings.leadRouting();
		
		LeadRouter_ListAll leadRouter_ListAll = (LeadRouter_ListAll) new LeadRouter_ListAll().init();
		Common.waitForPage(driver, 30);
		leadRouter_ListAll.search();

		SearchBox searchBox = (SearchBox) new SearchBox().init();
        Common.waitForPage(driver, 30);
        searchBox.search(common.prop("WEIGHTEDRANDOM"));
        
		Common.waitForPage(driver, 30);
		leadRouter_ListAll.selectRouters();
		
		ActionsMenu actionsMenu = (ActionsMenu) new ActionsMenu().init();
        Common.waitForPage(driver, 30);
        actionsMenu.clickDeleteRouter();

		DialogBox dialogBox = (DialogBox) new DialogBox().init();
        Common.waitForPage(driver, 30);
        dialogBox.acceptMessage();

        Common.waitForPage(driver, 30);
        searchBox.clearSearch();
        
        Common.waitForPage(driver, 30);
		leadRouter_ListAll.search();
        
        Common.waitForPage(driver, 30);
        searchBox.search(common.prop("WEIGHTEDRANDOM"));
        
        Common.waitForPage(driver, 30);
        
        if(driver.findElements(By.xpath("//a[normalize-space(text())='" + common.prop("WEIGHTEDRANDOM") +"']")).size()>0)
        {
        	fail("Found deleted weighted random");
        }

        Common.waitForPage(driver, 30);
        searchBox.clearSearch();
	}

}
