package com.ontraport.app.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.ontraport.app.tools.AbstractSuite;

@RunWith(Suite.class)
@SuiteClasses({
	com.ontraport.app.tests.AddNewSection.class,
    com.ontraport.app.tests.DeleteSection.class,
})
public class Broken extends AbstractSuite
{
	
}
