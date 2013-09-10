package com.ontraport.app.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.ontraport.app.tools.AbstractPage;

public class LandingPage_TypeSelection extends AbstractPage
{

    protected String   url = "/#!/landing_page/typeSelection";

    @FindBy(how = How.XPATH, using = "//div[div[*/text()='Easy Pages']]/descendant::button[*[normalize-space(text())='Create']]")
    private WebElement linkCreateEasyPages;

    public LandingPage_Create createEasyPages () throws Exception
    {	
    	linkCreateEasyPages.click();
        return PageFactory.initElements(driver, LandingPage_Create.class);
    }

}


