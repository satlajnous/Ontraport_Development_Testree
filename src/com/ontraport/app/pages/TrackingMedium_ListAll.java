package com.ontraport.app.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.ontraport.app.tools.AbstractPage;

public class TrackingMedium_ListAll extends AbstractPage
{

    protected String   url = "/#!/tracking_medium/listAll";

    @FindBy(how = How.XPATH, using = "//body")
    private WebElement body;

    public TrackingMedium_ListAll sample () throws Exception
    {
        return PageFactory.initElements(driver, TrackingMedium_ListAll.class);
    }

}