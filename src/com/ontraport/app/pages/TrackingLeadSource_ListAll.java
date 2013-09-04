package com.ontraport.app.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.ontraport.app.tools.AbstractPage;

public class TrackingLeadSource_ListAll extends AbstractPage
{

    protected String   url = "/#!/tracking_lead_source/listAll";

    @FindBy(how = How.XPATH, using = "//body")
    private WebElement body;

    public TrackingLeadSource_ListAll sample () throws Exception
    {
        return PageFactory.initElements(driver, TrackingLeadSource_ListAll.class);
    }

}