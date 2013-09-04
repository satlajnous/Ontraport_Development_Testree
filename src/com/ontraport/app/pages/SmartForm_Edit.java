package com.ontraport.app.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.ontraport.app.tools.AbstractPage;

public class SmartForm_Edit extends AbstractPage
{

    protected String   url = "/#!/smart_form_fe/edit&id=";

    @FindBy(how = How.XPATH, using = "//body")
    private WebElement body;

    public SmartForm_Edit sample () throws Exception
    {
        return PageFactory.initElements(driver, SmartForm_Edit.class);
    }

}