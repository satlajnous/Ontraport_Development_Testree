package com.ontraport.app.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.ontraport.app.tools.AbstractSuite;

@RunWith(Suite.class)
@SuiteClasses({
	com.ontraport.app.tests.CreateRule_TC0017.class,
	com.ontraport.app.tests.CreateRule_TC0027.class,
	com.ontraport.app.tests.CreateRule_TC0028.class,
	com.ontraport.app.tests.CreateRule_TC0029.class,
	com.ontraport.app.tests.CreateRule_TC0030.class,
})
public class Rules_TestSuite extends AbstractSuite{}

