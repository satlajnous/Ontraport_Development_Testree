package com.ontraport.app.tests;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Sequence_CreateDate;
import com.ontraport.app.pages.Sequence_Edit;
import com.ontraport.app.pages.Sequence_ListAll;
import com.ontraport.app.pages.Sequence_TypeSelection;
import com.ontraport.app.tools.AbstractTest;

public class DateSequence_CopySequence extends AbstractTest {
	String seqName = "DateSeq" + Calendar.getInstance().getTimeInMillis();

	@Test
	public void testTC0564_Action_DateSequence_CopySequence() throws Exception {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll()
				.init();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Sequence_ListAll seqListAll = contactListAll.navSequences();
		Sequence_TypeSelection seqType = seqListAll.clickNewSequence();
		Sequence_CreateDate seqDate = seqType.clickCreateDateSeq();
		seqListAll=seqDate.createDateSeq(seqName);
		boolean condition = seqListAll.isElementPresent(seqName);
		Assert.assertTrue(condition);
		
		Sequence_Edit seqEdit=seqListAll.copySequences(seqName);
		String newSeqName=seqEdit.getSeqName();
		seqEdit.saveLP();
		seqListAll.setHundredRecordsPerPage();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		boolean condition2= seqListAll.isElementPresent(newSeqName);
		Assert.assertTrue(condition2);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		seqEdit=seqListAll.editSequence(newSeqName);
		String newSeqName2=seqEdit.getSeqName();
		Assert.assertEquals(("Copy of "+seqName), newSeqName2);
	}

}
