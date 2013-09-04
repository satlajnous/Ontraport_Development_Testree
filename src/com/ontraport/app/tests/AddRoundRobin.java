package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

import com.ontraport.app.pages.Contact_Settings;
import com.ontraport.app.pages.LeadRouter_Create;
import com.ontraport.app.pages.LeadRouter_ListAll;
import com.ontraport.app.pages.LeadRouter_TypeSelection;
import com.ontraport.app.parts.SearchBox;
import com.ontraport.app.parts.SiteMenu;
import com.ontraport.app.tools.AbstractTest;
import com.ontraport.app.tools.Common;

public class AddRoundRobin extends AbstractTest
{

	@Test
	public void testAddRoundRobin() throws Exception {
		SiteMenu siteMenu = (SiteMenu) new SiteMenu().init();
		Common.waitForPage(driver, 30);
		siteMenu.contacts();
		siteMenu.contact_Settings();
		
		Contact_Settings contact_Settings = (Contact_Settings) new Contact_Settings().init();
		Common.waitForPage(driver, 30);
		contact_Settings.leadRouting();
		
		LeadRouter_ListAll leadRouter_ListAll = (LeadRouter_ListAll) new LeadRouter_ListAll().init();
		Common.waitForPage(driver, 30);
		leadRouter_ListAll.newLeadRouter();
		
		LeadRouter_TypeSelection leadRouter_TypeSelection = (LeadRouter_TypeSelection) new LeadRouter_TypeSelection().init();
		Common.waitForPage(driver, 30);
		leadRouter_TypeSelection.create_RR();
		
		LeadRouter_Create leadRouter_Create = (LeadRouter_Create) new LeadRouter_Create().init();
		Common.waitForPage(driver, 30);
		leadRouter_Create.fillOutRR(common.prop("ROUNDROBIN"));
		
		SearchBox searchBox = (SearchBox) new SearchBox().init();
        Common.waitForPage(driver, 30);
        searchBox.search(common.prop("ROUNDROBIN"));
        
        Common.waitForPage(driver, 30);
        if(driver.findElements(By.xpath("//a[normalize-space(text())='" + common.prop("ROUNDROBIN") +"']")).size()==0)
        {
        	fail("Can't find created Round Robin");
        }
        
        Common.waitForPage(driver, 30);
        searchBox.clearSearch();
	}

}
