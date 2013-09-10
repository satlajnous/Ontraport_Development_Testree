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

public class Update_LandingPage_PageTitle extends AbstractTest{
	String lpName = "SelLP" + Calendar.getInstance().getTimeInMillis();
	String URL="SelPage"+ Calendar.getInstance().getTimeInMillis();
	String pageTitle= "Test Title";
	
	@Test
	public void testTC0673_Update_LandingPage_PageTitle() throws Exception {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		SiteMenu siteMenu = (SiteMenu) new SiteMenu().init();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		LandingPage_ListAll lpListAll= siteMenu.clickLandingPages();
		LandingPage_TypeSelection lpType=lpListAll.clickNewLandingPage();
		LandingPage_Create lpCreate= lpType.createEasyPages();
		lpCreate.createNewLandingPage(lpName, URL);
		lpListAll.setHundredRecordsPerPage();
		boolean condition= lpListAll.isElementPresent(lpName);
		Assert.assertTrue(condition);
		LandingPage_Edit lpEdit= lpListAll.editLandingPage(lpName);
		lpEdit.enterPageTitle(pageTitle);
		lpEdit.saveLP();
		boolean condition1= lpListAll.isElementPresent(lpName);
		Assert.assertTrue(condition1);
		lpEdit= lpListAll.editLandingPage(lpName);
		String getPageTitle= lpEdit.getPageTitle();
		Assert.assertEquals(pageTitle, getPageTitle);
		

}
}