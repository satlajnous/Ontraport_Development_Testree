package com.ontraport.app.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.ontraport.app.tools.AbstractSuite;

@RunWith(Suite.class) @SuiteClasses({
    //com.ontraport.app.tests.EmailMessageEdit.class,
    com.ontraport.app.tests.Update_Email_Preview.class,
    com.ontraport.app.tests.Update_Email_Cancel.class,
}) public class EditEmailMessage_TestSuite extends AbstractSuite {}

