package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.parts.ColumnManager;
import com.ontraport.app.parts.SiteMenu;
import com.ontraport.app.tools.AbstractTest;
import com.ontraport.app.tools.Common;

public class DeleteColumn extends AbstractTest
{

	@Test
	public void test() throws Exception {
		SiteMenu siteMenu = (SiteMenu) new SiteMenu().init();
		Common.waitForPage(driver, 30);
		siteMenu.contacts();
		
		Contact_ListAll contact_ListAll = (Contact_ListAll) new Contact_ListAll().init();
		Common.waitForPage(driver, 30);
		contact_ListAll.selectColumn();
		
		ColumnManager columnManager2 = (ColumnManager) new ColumnManager().init();
		Common.waitForPage(driver, 30);
		columnManager2.delete();
		
		Common.waitForPage(driver, 30);
		
		if(driver.findElements(By.xpath("//tr[@class='sem-collection-header-display']//a[.='Zip Code']")).size()>0)
        {
        	fail("Can't find column zip code");
        }
	}

}
