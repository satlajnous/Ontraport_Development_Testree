package com.ontraport.app.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.ontraport.app.tools.AbstractSuite;

@RunWith(Suite.class)
@SuiteClasses({
//com.ontraport.app.tests.SmartForms_Field_Display_NothingSelected.class,
//com.ontraport.app.tests.SmartForms_TC0348.class,
//com.ontraport.app.tests.SmartForms_FontFamily.class, 
com.ontraport.app.tests.SmartForm_FontSize_TC0350.class,
//com.ontraport.app.tests.SmartForm_BorderStyle_TC0358.class,
//com.ontraport.app.tests.SmartForm_BorderSize_TC0359.class,
//com.ontraport.app.tests.SmartForm_BorderRadius_TC0360.class,
//com.ontraport.app.tests.SmartForm_BorderPosition_TC0362.class,
//com.ontraport.app.tests.SmartForm_BorderRepeat_TC0363.class,
})
public class SmartForms_TestSuite extends AbstractSuite {
}
