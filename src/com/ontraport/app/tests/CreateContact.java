package com.ontraport.app.tests;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.AssertJUnit;

import com.ontraport.app.pages.Contact_Create;
import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.parts.SearchBox;
import com.ontraport.app.parts.SiteMenu;
import com.ontraport.app.tools.AbstractPart;
import com.ontraport.app.tools.AbstractTest;
import com.ontraport.app.tools.Common;
import com.ontraport.app.tools.ContactInfo;


public class CreateContact extends AbstractTest{
	
	@Test
	public void testCreateContact() throws Exception {
		//long varTimeStamp = Calendar.getInstance().getTimeInMillis();
		SiteMenu siteMenu = (SiteMenu) new SiteMenu().init();
		Common.waitForPage(driver, 30);
		siteMenu.contacts();
		
		Contact_ListAll contact_ListAll = (Contact_ListAll) new Contact_ListAll().init();
		Common.waitForPage(driver, 30);
		contact_ListAll.create();
		
		Contact_Create contact_Create = (Contact_Create) new Contact_Create().init();
        Common.waitForPage(driver, 30);
        contact_Create.saveContact(common.prop("FIRSTNAME"), common.prop("LASTNAME"), common.prop("EMAIL"));
        
        Contact_ListAll contactListAll1 = (Contact_ListAll) new Contact_ListAll().init();
		Common.waitForPage(driver, 30);
		contactListAll1.search();
		
        SearchBox searchBox = (SearchBox) new SearchBox().init();
        Common.waitForPage(driver, 30);
        searchBox.search(common.prop("FIRSTNAME"));
        
        Common.waitForPage(driver, 30);
        if(driver.findElements(By.xpath("//a[normalize-space(text())='" + common.prop("FIRSTNAME") +"']")).size()==0)
        {
        	fail("Can't find created contact");
        }
        
        Common.waitForPage(driver, 30);
        searchBox.clearSearch();
	}

}
