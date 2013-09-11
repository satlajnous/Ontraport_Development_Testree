package com.ontraport.app.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.ontraport.app.tools.AbstractSuite;
@RunWith(Suite.class)
@SuiteClasses({
		com.ontraport.app.tests.LandingPage_CopyLandingPageAction.class,
		com.ontraport.app.tests.Update_LandingPage_PageName.class,
		com.ontraport.app.tests.Update_LandingPage_PageTitle.class,
		com.ontraport.app.tests.Update_LandingPage_PageURL.class,
	   	com.ontraport.app.tests.Update_LandingPage_PageAlignment.class,		
})
public class LandingPages_TestSuite extends AbstractSuite {
}