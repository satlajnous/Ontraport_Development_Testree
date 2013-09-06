package com.ontraport.app.tests;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.testng.AssertJUnit;

import java.util.Calendar;
import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.SmartForm_Create;
import com.ontraport.app.pages.SmartForm_Edit;
import com.ontraport.app.pages.SmartForm_ListAll;
import com.ontraport.app.parts.SiteMenu;
import com.ontraport.app.tools.AbstractTest;

public class SmartForms_FontFamily extends AbstractTest {
	String smartFormName = "SForm" + Calendar.getInstance().getTimeInMillis();
	String giveFontName = "Arial Black";

	@Test
	public void testTC0349_Update_SmartForms_FontFamily() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		SiteMenu sitemenu = (SiteMenu) new SiteMenu().init();
		Contact_ListAll contactListAll = sitemenu.contacts();
		SmartForm_ListAll smartListAll = contactListAll.navSmartForms();
		Thread.sleep(4000);
		SmartForm_Create smartFormCreate = smartListAll.clickNewSmartForm();
		smartFormCreate.createNewSmartForm(smartFormName);
		contactListAll = sitemenu.contacts();
		smartListAll = contactListAll.navSmartForms();
		smartListAll.setHundredRecordsPerPage();
		boolean condition = smartListAll.isElementPresent(smartFormName);
		AssertJUnit.assertTrue(condition);
		SmartForm_Edit smartFormEdit = smartListAll
				.editSmartForm(smartFormName);
		smartFormEdit.clickSubmitButton();
		smartFormEdit.editFontFamily(giveFontName);
		contactListAll = sitemenu.contacts();
		smartListAll = contactListAll.navSmartForms();
		smartListAll.setHundredRecordsPerPage();
		smartFormEdit = smartListAll.editSmartForm(smartFormName);
		smartFormEdit.clickSubmitButton();
		Thread.sleep(3000);
		String fontName = smartFormEdit.getTextFromInput();
		Assert.assertEquals(giveFontName, fontName);
		smartFormEdit.editFontFamily("Arial");
	}
}
