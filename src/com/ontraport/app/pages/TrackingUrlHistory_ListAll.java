package com.ontraport.app.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.ontraport.app.tools.AbstractPage;

public class TrackingUrlHistory_ListAll extends AbstractPage
{

    protected String   url = "/#!/tracking_url_history/listAll";

    @FindBy(how = How.XPATH, using = "//body")
    private WebElement body;

    public TrackingUrlHistory_ListAll sample () throws Exception
    {
        return PageFactory.initElements(driver, TrackingUrlHistory_ListAll.class);
    }

}