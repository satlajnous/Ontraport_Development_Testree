package com.ontraport.app.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.ontraport.app.tools.AbstractSuite;

@RunWith(Suite.class) @SuiteClasses({
    com.ontraport.app.tests.StepSequence_CopySequences.class,
    com.ontraport.app.tests.DateSequence_CopySequence.class,
    com.ontraport.app.tests.StepSequence_Back.class,
    
}) public class Sequences_TestSuite extends AbstractSuite {}