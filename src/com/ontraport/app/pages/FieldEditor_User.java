package com.ontraport.app.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.ontraport.app.tools.AbstractPage;

public class FieldEditor_User extends AbstractPage
{

    protected String   url = "/#!/fieldeditor&obj_id=2";

    @FindBy(how = How.XPATH, using = "//body")
    private WebElement body;

    public FieldEditor_User sample () throws Exception
    {
        return PageFactory.initElements(driver, FieldEditor_User.class);
    }

}