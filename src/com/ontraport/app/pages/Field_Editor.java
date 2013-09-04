package com.ontraport.app.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.ontraport.app.tools.AbstractPage;

public class Field_Editor extends AbstractPage
{

    protected String   url = "/#!/fieldeditor";

    @FindBy(how = How.XPATH, using = "//body")
    private WebElement body;

    public Field_Editor sample () throws Exception
    {
        return PageFactory.initElements(driver, Field_Editor.class);
    }

}