package com.ontraport.app.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.ontraport.app.tools.AbstractSuite;

@RunWith(Suite.class)
@SuiteClasses({
com.ontraport.app.tests.SmartForms_Field_Display_NothingSelected.class,
com.ontraport.app.tests.SmartForms_TC0348.class,
com.ontraport.app.tests.SmartForms_FontFamily.class, 
com.ontraport.app.tests.SmartForm_FontSize_TC0350.class,
com.ontraport.app.tests.SmartForm_BorderStyle_TC0358.class,
com.ontraport.app.tests.SmartForm_BorderSize_TC0359.class,
com.ontraport.app.tests.SmartForm_BorderRadius_TC0360.class,
com.ontraport.app.tests.SmartForm_BorderPosition_TC0362.class,
com.ontraport.app.tests.SmartForm_BorderRepeat_TC0363.class,
com.ontraport.app.tests.SmartForm_Background_BckgrndPos_TC0447.class,
com.ontraport.app.tests.SmartForm_Background_BckgrndRept_TC0448.class,
com.ontraport.app.tests.SmartForm_Background_BorderRadius_TC0452.class,
com.ontraport.app.tests.SmartForm_Background_BorderSize_TC0451.class,
com.ontraport.app.tests.SmartForm_Background_BorderStyle_TC0449.class,
com.ontraport.app.tests.SmartForm_FormStyle_FontFamily_TC0433.class,
com.ontraport.app.tests.SmartForm_FormStyle_FontFamily_TC0439.class,
com.ontraport.app.tests.SmartForm_FormStyle_FontSize_TC0434.class,
com.ontraport.app.tests.SmartForm_FormStyle_FontSize_TC0440.class,
com.ontraport.app.tests.SmartForm_FormStyle_BackgroundPos_TC0415.class,
com.ontraport.app.tests.SmartForm_FormStyle_BackgroundRept_TC0416.class,
com.ontraport.app.tests.SmartForm_FormStyle_FontFamily_TC0407.class,
com.ontraport.app.tests.SmartForm_FormStyle_FontSize_TC0408.class,


})
public class SmartForms_TestSuite extends AbstractSuite {
}
