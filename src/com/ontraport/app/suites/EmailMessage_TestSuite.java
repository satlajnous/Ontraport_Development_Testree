package com.ontraport.app.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.ontraport.app.tools.AbstractSuite;

@RunWith(Suite.class) @SuiteClasses({
	com.ontraport.app.tests.CreateEmailMessage_TC0128.class,
    com.ontraport.app.tests.UpdateEmailMsg_TC0552.class,
    com.ontraport.app.tests.UpdateEmailMsg_TC0557.class,
    com.ontraport.app.tests.UpdateEmailMsg_TC0556.class,
    com.ontraport.app.tests.UpdateEmailMsg_TC0553.class,
    com.ontraport.app.tests.UpdateEmailMsg_TC0554.class, 
    com.ontraport.app.tests.UpdateEmailMsg_TC0607.class,
    com.ontraport.app.tests.UpdateEmailMsg_TC0608.class,
    
}) public class EmailMessage_TestSuite extends AbstractSuite {}

