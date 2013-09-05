package com.ontraport.app.tests;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;



import org.junit.Assert;
import org.junit.Test;

import com.ontraport.app.pages.AffiliateProgram_Create;
import com.ontraport.app.pages.AffiliateProgram_Edit;
import com.ontraport.app.pages.AffiliateProgram_ListAll;
import com.ontraport.app.pages.Affiliate_ListAll;
import com.ontraport.app.parts.SiteMenu;
import com.ontraport.app.tools.AbstractTest;

public class Programs_NewAffiliates_RequireApproval extends AbstractTest{
	String affProgName="ReqApp"+Calendar.getInstance().getTimeInMillis();
	String newAffOption="Require approval of all new affiliates";
	String newProgTypeOption="1 Tier";
	String howMuchInfo="Share first name and last initial";
	String checkboxAffiliateOnDeclinedTransaction= "NO";
	String checkboxAffiliatePurchaseHistory="NO";
	String emailID="test@test.com";
	
	@Test
	public void testTC0650_Create_Programs_NewAffiliates_RequireApproval() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		SiteMenu siteMenu = (SiteMenu) new SiteMenu().init();
		Affiliate_ListAll affListAll= siteMenu.clickPartners();
		AffiliateProgram_ListAll affProgListAll= affListAll.clickPrograms();
		AffiliateProgram_Create affProgCreate= affProgListAll.clickNewAffiliateProgram();
		affProgCreate.programCreate(affProgName, newAffOption, newProgTypeOption, howMuchInfo,checkboxAffiliateOnDeclinedTransaction, checkboxAffiliatePurchaseHistory,emailID);
		affProgListAll.setHundredRecordsPerPage();
		boolean condition= affProgCreate.isElementPresent(affProgName);
		Assert.assertTrue(condition);
		AffiliateProgram_Edit affProgEdit= affProgListAll.clickAffiliationProgram(affProgName);
		String newAffiliation= affProgEdit.getTextNewAffliation();
		Assert.assertEquals(newAffOption, newAffiliation);
}
}
