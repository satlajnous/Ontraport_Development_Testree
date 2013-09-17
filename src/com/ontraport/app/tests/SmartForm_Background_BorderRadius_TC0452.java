package com.ontraport.app.tests;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.testng.AssertJUnit;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.SmartForm_Create;
import com.ontraport.app.pages.SmartForm_Edit;
import com.ontraport.app.pages.SmartForm_ListAll;
import com.ontraport.app.parts.SiteMenu;
import com.ontraport.app.tools.AbstractTest;

public class SmartForm_Background_BorderRadius_TC0452 extends AbstractTest {
	String smartFormName = "SForm" + Calendar.getInstance().getTimeInMillis();
	String sectionName = "Background";
	String fieldName = "Border Radius";
	String fieldvalue = "20px";

	
	@Test
	public void SmartForm_Background_BorderRadius_TC0452() throws Exception{
		SmartForm_Create smartFormCreate = createSmartForm (smartFormName);
		SmartForm_Edit smartFormEdit = navigateToContactsAndClickSmartForms (smartFormName);
		smartFormEdit = smartFormEdit.clickSubmitButton();
		//Fill text box field
		smartFormEdit = smartFormEdit.clickBackground();
		smartFormEdit.setSelectInBackgroundBasedOnLabel(sectionName,fieldName,fieldvalue);      
		smartFormEdit.clickSaveButton();
		smartFormEdit = navigateToContactsAndClickSmartForms (smartFormName);
		smartFormEdit = smartFormEdit.clickSubmitButton();
		//Verification on select field
		smartFormEdit = smartFormEdit.clickBackground();
		boolean b = smartFormEdit.verifySelectedOptionInBackgroundBasedOnLabel(sectionName,fieldName,fieldvalue);
		System.out.println(b);
		Assert.assertTrue("Field Value", b);
		
	}
	
	public SmartForm_Create createSmartForm (String smartFormName) throws Exception{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		SiteMenu sitemenu = (SiteMenu) new SiteMenu().init();
		Contact_ListAll contactListAll = sitemenu.contacts();
		SmartForm_ListAll smartListAll = contactListAll.navSmartForms();
		Thread.sleep(4000);
		SmartForm_Create smartFormCreate = smartListAll.clickNewSmartForm();
		return smartFormCreate.createNewSmartForm(smartFormName);
	}
	
	
	public SmartForm_Edit navigateToContactsAndClickSmartForms (String smartFormName) throws Exception{
		SiteMenu sitemenu = (SiteMenu) new SiteMenu().init();
		Contact_ListAll contactListAll = sitemenu.contacts();
		SmartForm_ListAll smartListAll = contactListAll.navSmartForms();
		smartListAll.setHundredRecordsPerPage();
		boolean condition = smartListAll.isElementPresent(smartFormName);
		AssertJUnit.assertTrue(condition);
		return smartListAll.editSmartForm(smartFormName);
	}
	

	
}
