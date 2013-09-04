package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Contact_Settings;
import com.ontraport.app.pages.FieldEditor;
import com.ontraport.app.parts.DialogBox;
import com.ontraport.app.parts.SiteMenu;
import com.ontraport.app.tools.AbstractTest;
import com.ontraport.app.tools.Common;

public class DeleteSection extends AbstractTest{

	@Test
	public void testDeleteSection() throws Exception {
		SiteMenu siteMenu = (SiteMenu) new SiteMenu().init();
		Common.waitForPage(driver, 30);
		siteMenu.contact_Settings();
		
		Contact_Settings contact_Settings = (Contact_Settings) new Contact_Settings().init();
		Common.waitForPage(driver, 30);
		contact_Settings.fieldSettings();
		
		FieldEditor fieldEditor = (FieldEditor) new FieldEditor().init();
		Common.waitForPage(driver, 30);
		fieldEditor.scrollDown();
		driver.findElement(By.xpath("//div[text()='" + common.prop("SELDESCRIPTION") + "']/following-sibling::div/div/div/button")).click();

		FieldEditor fieldEditor2 = (FieldEditor) new FieldEditor().init();
		Common.waitForPage(driver, 30);
		fieldEditor2.Save();
		
		Contact_Settings contactSettings2 = (Contact_Settings) new Contact_Settings().init();
		Common.waitForPage(driver, 30);
		contactSettings2.fieldSettings();
		
		FieldEditor fieldEditor3 = (FieldEditor) new FieldEditor().init();
		Common.waitForPage(driver, 30);
		fieldEditor3.scrollDown();
		
		Common.waitForPage(driver, 30);
		if (driver.getPageSource().contains(common.prop("SELTITLE"))) {
			fail("Can't find title");
        }
        if (driver.getPageSource().contains(common.prop("SELDESCRIPTION"))) {
        	fail("Can't find section description");
        }
        siteMenu.contacts();
        DialogBox dialogBox = (DialogBox) new DialogBox().init();
		Common.waitForPage(driver, 30);
		dialogBox.acceptMessageToContact();
	}

}
