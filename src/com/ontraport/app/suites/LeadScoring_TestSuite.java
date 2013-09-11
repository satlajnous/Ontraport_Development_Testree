package com.ontraport.app.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.ontraport.app.tools.AbstractSuite;

@RunWith(Suite.class)
@SuiteClasses({

		com.ontraport.app.tests.LeadScoring_TC0334.class,
		com.ontraport.app.tests.LeadScoring_TC0337.class,
		com.ontraport.app.tests.LeadScoring_TC0338.class,
		com.ontraport.app.tests.LeadScoring_TC0339.class,
		com.ontraport.app.tests.LeadScoring_TC0472.class,
		com.ontraport.app.tests.LeadScoring_TC0474.class,
		com.ontraport.app.tests.LeadScoring_TC0475.class,
		com.ontraport.app.tests.LeadScoring_TC0476.class,
		com.ontraport.app.tests.LeadScoring_TC0506.class,
		com.ontraport.app.tests.LeadScoring_TC0507.class, })
public class LeadScoring_TestSuite extends AbstractSuite {
}