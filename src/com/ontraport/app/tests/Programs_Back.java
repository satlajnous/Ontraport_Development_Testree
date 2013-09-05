package com.ontraport.app.tests;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;

import com.ontraport.app.pages.AffiliateProgram_Create;
import com.ontraport.app.pages.AffiliateProgram_ListAll;
import com.ontraport.app.pages.Affiliate_ListAll;
import com.ontraport.app.parts.SiteMenu;
import com.ontraport.app.tools.AbstractTest;

public class Programs_Back extends AbstractTest{
	
	@Test
	public void testTC0659_Create_Programs_Back() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		SiteMenu siteMenu = (SiteMenu) new SiteMenu().init();
		Affiliate_ListAll affListAll= siteMenu.clickPartners();
		AffiliateProgram_ListAll affProgListAll= affListAll.clickPrograms();
		AffiliateProgram_Create affProgCreate= affProgListAll.clickNewAffiliateProgram();
		affProgCreate.clickBack();
		String pageHeading= affProgListAll.getTextAffiliateHomePage();
		Assert.assertEquals("Affiliate Programs", pageHeading);
}

}
