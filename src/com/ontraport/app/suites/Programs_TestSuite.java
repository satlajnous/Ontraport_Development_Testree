package com.ontraport.app.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.ontraport.app.tools.AbstractSuite;

@RunWith(Suite.class)
@SuiteClasses({
		com.ontraport.app.tests.Programs_NewAffiliates_RequireApproval.class,
		com.ontraport.app.tests.Programs_NewAffiliates_AutoApprove.class,
		com.ontraport.app.tests.Programs_HowMuchInfoToShare_FirstAndLastInitial.class,
		com.ontraport.app.tests.Programs_HowMuchInfoToShare_FullName.class,
		com.ontraport.app.tests.Programs_HowMuchInfoToShare_ContactId.class,
		com.ontraport.app.tests.Programs_ShowAffiliateInfoOnDeclinedCharges.class,
		com.ontraport.app.tests.Programs_ShowAffiliatePurchaseHistory.class,
		com.ontraport.app.tests.Programs_NewAffiliates_AutoApprove.class,
		com.ontraport.app.tests.Programs_Cancel.class,
		com.ontraport.app.tests.Programs_Back.class,
})
public class Programs_TestSuite extends AbstractSuite {
}
