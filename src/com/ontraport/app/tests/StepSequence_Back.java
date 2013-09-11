package com.ontraport.app.tests;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Sequence_ListAll;
import com.ontraport.app.pages.Sequence_TypeSelection;
import com.ontraport.app.tools.AbstractTest;

public class StepSequence_Back extends AbstractTest {

	@Test
	public void testTC0562_Action_StepSequence_Back() throws Exception {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll()
				.init();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Sequence_ListAll seqListAll = contactListAll.navSequences();
		Sequence_TypeSelection seqType = seqListAll.clickNewSequence();
		seqListAll=seqType.clickBack();
		String pageHeading= seqListAll.getTextHomePage();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		Assert.assertEquals("Sequences", pageHeading);
	}
}
