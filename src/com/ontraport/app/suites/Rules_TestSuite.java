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
	com.ontraport.app.tests.CreateRule_TC0031.class,
	com.ontraport.app.tests.CreateRule_TC0032.class,
	com.ontraport.app.tests.CreateRule_TC0033.class,
	com.ontraport.app.tests.CreateRule_TC0034.class,
	com.ontraport.app.tests.CreateRule_TC0042.class,
})
public class Rules_TestSuite extends AbstractSuite{}

