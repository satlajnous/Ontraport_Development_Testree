package com.ontraport.app.pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.ontraport.app.tools.AbstractPage;

public class Rule_ListAll extends AbstractPage
{

    protected String   url = "/#!/rule/listAll";

    @FindBy(how = How.XPATH, using = "//div[@id='ontraport_panel_action_new']")
    private WebElement linkToCreate;

    public Rule_Create ruleCreate () throws Exception
{
        try {
            linkToCreate.click();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        return PageFactory.initElements(driver, Rule_Create.class);
    }

}