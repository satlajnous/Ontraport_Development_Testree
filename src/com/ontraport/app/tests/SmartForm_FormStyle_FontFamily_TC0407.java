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

public class SmartForm_FormStyle_FontFamily_TC0407 extends AbstractTest {
	String smartFormName = "SForm" + Calendar.getInstance().getTimeInMillis();
	String sectionName = "label style";
	String fieldName = "Font Family";
	String giveFontName = "Courier";

	
	@Test
	public void testSmartForm_FormStyle_FontFamily_TC0407 () throws Exception{
		SmartForm_Create smartFormCreate = createSmartForm (smartFormName);
		SmartForm_Edit smartFormEdit = navigateToContactsAndClickSmartForms (smartFormName);
		smartFormEdit = smartFormEdit.clickSubmitButton();
		//Fill text box field
		smartFormEdit = smartFormEdit.clickFormStyle();
		smartFormEdit.setSelectInFormStyleBasedOnLabel(sectionName,fieldName, giveFontName);      
		smartFormEdit.clickSaveButton();
		smartFormEdit = navigateToContactsAndClickSmartForms (smartFormName);
		smartFormEdit = smartFormEdit.clickSubmitButton();
		//Verification on select field
		smartFormEdit = smartFormEdit.clickFormStyle();
		boolean b = smartFormEdit.verifySelectedOptionInFormStyleBasedOnLabel(sectionName,fieldName, giveFontName);
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
