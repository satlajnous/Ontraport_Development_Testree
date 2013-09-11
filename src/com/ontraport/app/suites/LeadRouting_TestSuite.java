package com.ontraport.app.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.ontraport.app.tools.AbstractSuite;

@RunWith(Suite.class) @SuiteClasses({ 
    com.ontraport.app.tests.LeadRouting_Actions_OpensDrawer.class,
}) public class LeadRouting_TestSuite extends AbstractSuite {}