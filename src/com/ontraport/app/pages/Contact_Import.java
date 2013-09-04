package com.ontraport.app.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.ontraport.app.tools.AbstractPage;

public class Contact_Import extends AbstractPage
{

    protected String   url = "/#!/contact/import";

    @FindBy(how = How.XPATH, using = "//body")
    private WebElement body;

    public Contact_Import sample () throws Exception
    {
        return PageFactory.initElements(driver, Contact_Import.class);
    }

}