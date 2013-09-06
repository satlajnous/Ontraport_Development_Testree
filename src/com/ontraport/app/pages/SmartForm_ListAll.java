package com.ontraport.app.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.ontraport.app.tools.AbstractPage;

public class SmartForm_ListAll extends AbstractPage
{

    protected String   url = "/#!/smart_form_fe/listAll";

    @FindBy(how = How.XPATH, using = "//div[@id='ontraport_panel_action_new']")
    private WebElement linkNewSmartForm;

    public SmartForm_Create clickNewSmartForm () throws Exception
    {	linkNewSmartForm.click();
        return PageFactory.initElements(driver, SmartForm_Create.class);
    }

}