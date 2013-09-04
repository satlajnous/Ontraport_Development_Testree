package com.ontraport.app.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.ontraport.app.tools.AbstractPage;

public class Wordpress_Create extends AbstractPage
{

    protected String   url = "/#!/wordpress/create";

    @FindBy(how = How.XPATH, using = "//body")
    private WebElement body;

    public Wordpress_Create sample () throws Exception
    {
        return PageFactory.initElements(driver, Wordpress_Create.class);
    }

}