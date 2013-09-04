package com.ontraport.app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.ontraport.app.tools.AbstractPage;

public class Tag_ListAll extends AbstractPage
{

    protected String   url = "/#!/tag/listAll";

    @FindBy(how = How.XPATH, using = "//div[@id='ontraport_panel_action_new']")
    private WebElement linkCreateNewTag;

    public Tag_Create create () throws Exception
    {
    	linkCreateNewTag.click();
        return PageFactory.initElements(driver, Tag_Create.class);
    }
}