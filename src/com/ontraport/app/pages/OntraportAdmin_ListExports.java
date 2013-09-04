package com.ontraport.app.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.ontraport.app.tools.AbstractPage;

public class OntraportAdmin_ListExports extends AbstractPage
{

    protected String   url = "/#!/ontraport_admin";

    @FindBy(how = How.XPATH, using = "//body")
    private WebElement body;

    public OntraportAdmin_ListExports sample () throws Exception
    {
        return PageFactory.initElements(driver, OntraportAdmin_ListExports.class);
    }

}