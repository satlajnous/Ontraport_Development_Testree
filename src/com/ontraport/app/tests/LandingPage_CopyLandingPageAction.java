package com.ontraport.app.tests;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;

import com.ontraport.app.pages.LandingPage_Create;
import com.ontraport.app.pages.LandingPage_Edit;
import com.ontraport.app.pages.LandingPage_ListAll;
import com.ontraport.app.pages.LandingPage_TypeSelection;
import com.ontraport.app.parts.SiteMenu;
import com.ontraport.app.tools.AbstractTest;

public class LandingPage_CopyLandingPageAction extends AbstractTest{
	String lpName = "SelLP" + Calendar.getInstance().getTimeInMillis();
	String URL="SelPage"+ Calendar.getInstance().getTimeInMillis();
	
	@Test
	public void testTC0670_LandingPage_CopyLandingPageAction() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		SiteMenu sitemenu = (SiteMenu) new SiteMenu()
				.init();
		LandingPage_ListAll lpListAll= sitemenu.clickLandingPages();
		LandingPage_TypeSelection lpTypeSelect= lpListAll.clickNewLandingPage();
		LandingPage_Create lpCreate=lpTypeSelect.createEasyPages();
		lpListAll=lpCreate.createBasicLandingPage(lpName);
		lpListAll.setHundredRecordsPerPage();
		boolean condition= lpListAll.isElementPresent(lpName);
		Assert.assertTrue(condition);
		LandingPage_Edit lpEdit=lpListAll.copyLP(lpName);
		String newLPName=lpEdit.getLandingPageName();
		lpEdit.saveLP();
		lpListAll.setHundredRecordsPerPage();
		boolean condition2= lpListAll.isElementPresent(newLPName);
		Assert.assertTrue(condition2);
		lpListAll.editLandingPage(newLPName);
		String newLPName2=lpEdit.getLandingPageName();
		Assert.assertEquals(("Copy of "+lpName), newLPName2);
	}
}
