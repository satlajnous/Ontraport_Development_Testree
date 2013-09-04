package com.ontraport.app.tests;


import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ontraport.app.pages.Affiliate_ListAll;
import com.ontraport.app.pages.Affiliate_Settings;
import com.ontraport.app.parts.SiteMenu;
import com.ontraport.app.tools.AbstractTest;
import com.ontraport.app.tools.Common;

public class GlobalSettings extends AbstractTest {
	@Test
	public void testGlobalSettings_PayAffiliatesBy_Paypal() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		SiteMenu sitemenu = (SiteMenu) new SiteMenu().init();
		Affiliate_ListAll afflListAll = sitemenu.clickPartners();
		Affiliate_Settings afflSetting = afflListAll.clickGlobalSettings();
		afflSetting.globalSettings_Paypal();
		afflListAll.clickGlobalSettings();
	}

	@Test
	public void testGlobalSettings_PayAffiliatesBy_Check() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		SiteMenu sitemenu = (SiteMenu) new SiteMenu().init();
		Affiliate_ListAll afflListAll = sitemenu.clickPartners();
		Affiliate_Settings afflSetting = afflListAll.clickGlobalSettings();
		afflSetting.globalSettings_check();
		afflListAll.clickGlobalSettings();
	}

	@Test
	public void testGlobalSettings_PayAffiliatesBy_TheirChoice()
			throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		SiteMenu sitemenu = (SiteMenu) new SiteMenu().init();
		Affiliate_ListAll afflListAll = sitemenu.clickPartners();
		Affiliate_Settings afflSetting = afflListAll.clickGlobalSettings();
		afflSetting.globalSettings_TheirChoice();
		afflListAll.clickGlobalSettings();
	}

	@Test
	public void testGlobalSettings_PayThreshold() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		SiteMenu sitemenu = (SiteMenu) new SiteMenu().init();
		Affiliate_ListAll afflListAll = sitemenu.clickPartners();
		Affiliate_Settings afflSetting = afflListAll.clickGlobalSettings();
		afflSetting.globalSettings_paythreshold("100");
		afflListAll.clickGlobalSettings();
		afflSetting.globalSettings_paythreshold("0");
		afflListAll.clickGlobalSettings();
	}

	@Test
	public void testGlobalSettings_CommissionPaid_FirstReferrer()
			throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		SiteMenu sitemenu = (SiteMenu) new SiteMenu().init();
		Affiliate_ListAll afflListAll = sitemenu.clickPartners();
		Affiliate_Settings afflSetting = afflListAll.clickGlobalSettings();
		afflSetting.globalSettings_FirstReferrer();
		afflListAll.clickGlobalSettings();
	}

	@Test
	public void testGlobalSettings_CommissionPaid_LastReferrer()
			throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		SiteMenu sitemenu = (SiteMenu) new SiteMenu().init();
		Affiliate_ListAll afflListAll = sitemenu.clickPartners();
		Affiliate_Settings afflSetting = afflListAll.clickGlobalSettings();
		afflSetting.globalSettings_LastReferrer();
		afflListAll.clickGlobalSettings();
	}

	@Test
	public void testGlobalSettings_CookiesExpire_Never() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		SiteMenu sitemenu = (SiteMenu) new SiteMenu().init();
		Affiliate_ListAll afflListAll = sitemenu.clickPartners();
		Affiliate_Settings afflSetting = afflListAll.clickGlobalSettings();
		afflSetting.globalSettings_NeverExpire();
		afflListAll.clickGlobalSettings();
	}

	@Test
	public void testGlobalSettings_CookiesExpire_30Days() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		SiteMenu sitemenu = (SiteMenu) new SiteMenu().init();
		Affiliate_ListAll afflListAll = sitemenu.clickPartners();
		Affiliate_Settings afflSetting = afflListAll.clickGlobalSettings();
		afflSetting.globalSettings_30DaysExpire();
		afflListAll.clickGlobalSettings();
	}

	@Test
	public void testGlobalSettings_Back() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		SiteMenu sitemenu = (SiteMenu) new SiteMenu().init();
		Affiliate_ListAll afflListAll = sitemenu.clickPartners();
		Affiliate_Settings afflSetting = afflListAll.clickGlobalSettings();
		afflSetting.globalSettings_Back();

	}

	@Test
	public void testGlobalSettings_Cancel() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		SiteMenu sitemenu = (SiteMenu) new SiteMenu().init();
		Affiliate_ListAll afflListAll = sitemenu.clickPartners();
		Affiliate_Settings afflSetting = afflListAll.clickGlobalSettings();
		afflSetting.globalSettings_Cancel();

	}

}
