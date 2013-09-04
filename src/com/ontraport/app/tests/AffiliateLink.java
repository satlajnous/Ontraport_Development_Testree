package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

import com.ontraport.app.pages.Account_View;
import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.OntraportAdmin_Afflink;
import com.ontraport.app.parts.SiteMenu;
import com.ontraport.app.parts.UserMenu;
import com.ontraport.app.tools.AbstractTest;
import com.ontraport.app.tools.Common;

public class AffiliateLink extends AbstractTest 
{

	@Test
	public void testAffiliateLink() throws Exception {
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
		account_View.clickSoftwareAffiliateLinks();
	
		OntraportAdmin_Afflink ontraportAdmin_Afflink = (OntraportAdmin_Afflink) new OntraportAdmin_Afflink().init();
		Common.waitForPage(driver, 30);
		ontraportAdmin_Afflink.trypage();
		
		Common.waitForPage(driver, 30);
		
		if(driver.findElements(By.xpath("//li[@id='menu-item-9']//a[.='Features']")).size()==0)
        {
        	fail("Can't find Affiliates page");
        }
		driver.navigate().back();
	}

}
