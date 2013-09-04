package com.ontraport.app.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.ontraport.app.tools.AbstractPage;

public class Message_CreatePostcard extends AbstractPage
{

    protected String   url = "/#!/message/create&type=Postcard";

    @FindBy(how = How.XPATH, using = "//body")
    private WebElement body;

    public Message_CreatePostcard sample () throws Exception
    {
        return PageFactory.initElements(driver, Message_CreatePostcard.class);
    }

}