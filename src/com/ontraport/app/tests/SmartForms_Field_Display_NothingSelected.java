package com.ontraport.app.tests;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.SmartForm_Create;
import com.ontraport.app.pages.SmartForm_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class SmartForms_Field_Display_NothingSelected extends AbstractTest{

	@Test
	public void testTC0345_Update_SmartForms_Field_Display_NothingSelected() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
		SmartForm_ListAll smartListAll= contactListAll.navSmartForms();
		SmartForm_Create smartFormCreate= smartListAll.clickNewSmartForm();
		String fieldText= smartFormCreate.verifyNothingIsSelectedInField();
		Assert.assertEquals("Nothing selected", fieldText);
}

}
