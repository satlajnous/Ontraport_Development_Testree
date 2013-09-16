package com.ontraport.app.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.ontraport.app.tools.AbstractSuite;

@RunWith(Suite.class)
@SuiteClasses(
{
    // Suite begins in authenticated state on this page:
    // http://app.ontraport.com/#!/contact/listAll
    //com.ontraport.app.tests.Simple.class,
    /*com.ontraport.app.tests.CreateContact.class,
    com.ontraport.app.tests.AddGroup.class,
    com.ontraport.app.tests.AddRoundRobin.class,
    com.ontraport.app.tests.AddWeightedRandom.class,
    com.ontraport.app.tests.CreateAPIKeys.class,
    com.ontraport.app.tests.AddDeleteUserPermissions.class,
    com.ontraport.app.tests.Create1SCSync.class,
    com.ontraport.app.tests.CreateAffiliateTrackingPixel.class,
    com.ontraport.app.tests.AffiliateLink.class,
    com.ontraport.app.tests.AddColumn.class,
    com.ontraport.app.tests.DeleteAPIKeys.class,
    com.ontraport.app.tests.DeleteColumn.class,
    com.ontraport.app.tests.DeleteWeightedRandom.class,
    com.ontraport.app.tests.DeleteRoundRobin.class,
    com.ontraport.app.tests.DeleteGroup.class,
    com.ontraport.app.tests.DeleteContact.class,*/
	
})
public class Active extends AbstractSuite
{
}
