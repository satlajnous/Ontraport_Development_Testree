package com.ontraport.app.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.ontraport.app.tools.AbstractPage;

public class Sequence_CreateStep extends AbstractPage
{

    protected String   url = "/#!/sequence/create&type=step";

    @FindBy(how = How.XPATH, using = "//body")
    private WebElement body;

    public Sequence_CreateStep sample () throws Exception
    {
        return PageFactory.initElements(driver, Sequence_CreateStep.class);
    }

}