package com.ontraport.app.tools;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPart
{
    protected WebDriver driver;

    public AbstractPart ()
    {
        driver = AbstractSuite.getDriver();
    }

    public AbstractPart init ()
    {
        return PageFactory.initElements(driver, this.getClass());
    }
}
