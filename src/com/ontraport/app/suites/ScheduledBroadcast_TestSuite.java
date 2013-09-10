package com.ontraport.app.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.ontraport.app.tools.AbstractSuite;

@RunWith(Suite.class) @SuiteClasses({
    com.ontraport.app.tests.BroadcastManager_Actions_OpensDrawer.class,
}) public class ScheduledBroadcast_TestSuite extends AbstractSuite {}