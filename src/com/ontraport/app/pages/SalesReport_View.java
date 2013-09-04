package com.ontraport.app.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.ontraport.app.tools.AbstractPage;

public class SalesReport_View extends AbstractPage
{

    protected String   url = "/#!/sales_report/view";

    @FindBy(how = How.XPATH, using = "//body")
    private WebElement body;

    public SalesReport_View sample () throws Exception
    {
        return PageFactory.initElements(driver, SalesReport_View.class);
    }

}