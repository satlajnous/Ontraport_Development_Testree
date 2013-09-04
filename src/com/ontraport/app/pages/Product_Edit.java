package com.ontraport.app.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.ontraport.app.tools.AbstractPage;

public class Product_Edit extends AbstractPage
{

    protected String   url = "/#!/product/edit&id=";

    @FindBy(how = How.XPATH, using = "//body")
    private WebElement body;

    public Product_Edit sample () throws Exception
    {
        return PageFactory.initElements(driver, Product_Edit.class);
    }

}