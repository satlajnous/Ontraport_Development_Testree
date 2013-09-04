package com.ontraport.app.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.ontraport.app.tools.AbstractPage;

public class Rule_Edit extends AbstractPage
{

    protected String   url = "/#!/rule/edit&id=";

    @FindBy(how = How.XPATH, using = "//body")
    private WebElement body;

    public Rule_Edit sample () throws Exception
    {
        return PageFactory.initElements(driver, Rule_Edit.class);
    }

}