package com.ontraport.app.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.ontraport.app.tools.AbstractSuite;

@RunWith(Suite.class)
@SuiteClasses({
	
		com.ontraport.app.tests.LeadScoring_TC0326.class,
		com.ontraport.app.tests.LeadScoring_TC0327.class,	
		com.ontraport.app.tests.LeadScoring_TC0328.class,
		com.ontraport.app.tests.LeadScoring_TC0329.class,
		com.ontraport.app.tests.LeadScoring_TC0330.class,
		com.ontraport.app.tests.LeadScoring_TC0331.class,
		com.ontraport.app.tests.LeadScoring_TC0332.class,
		com.ontraport.app.tests.LeadScoring_TC0333.class,
		com.ontraport.app.tests.LeadScoring_TC0334.class,
		com.ontraport.app.tests.LeadScoring_TC0337.class,
		com.ontraport.app.tests.LeadScoring_TC0338.class,
		com.ontraport.app.tests.LeadScoring_TC0339.class,
		com.ontraport.app.tests.LeadScoring_TC0340.class,
		com.ontraport.app.tests.LeadScoring_TC0341.class,
		com.ontraport.app.tests.LeadScoring_TC0342.class,
		com.ontraport.app.tests.LeadScoring_TC0343.class,
	
		com.ontraport.app.tests.LeadScoring_TC0472.class,
		com.ontraport.app.tests.LeadScoring_TC0473.class,
		com.ontraport.app.tests.LeadScoring_TC0474.class,
		com.ontraport.app.tests.LeadScoring_TC0475.class,
		com.ontraport.app.tests.LeadScoring_TC0476.class,
		
		
		com.ontraport.app.tests.LeadScoring_TC0477.class,
		com.ontraport.app.tests.LeadScoring_TC0478.class,
		com.ontraport.app.tests.LeadScoring_TC0479.class,
		com.ontraport.app.tests.LeadScoring_TC0480.class,
		
		
		com.ontraport.app.tests.LeadScoring_TC0483.class,
		com.ontraport.app.tests.LeadScoring_TC0484.class,
//		com.ontraport.app.tests.LeadScoring_TC0485.class,
//		com.ontraport.app.tests.LeadScoring_TC0486.class,
		
		
		com.ontraport.app.tests.LeadScoring_TC0506.class,
		com.ontraport.app.tests.LeadScoring_TC0507.class,
//		com.ontraport.app.tests.LeadScoring_TC0508.class,
		
})
public class LeadScoring_TestSuite extends AbstractSuite {
}