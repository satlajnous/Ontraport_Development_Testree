package com.ontraport.app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.ontraport.app.tools.AbstractPage;

public class OntraportAdmin_Afflink extends AbstractPage
{

    protected String   url = "/#!/ontraport_admin";

    @FindBy(how = How.XPATH, using = "//div[@class='ussr-component-section-components']/div[3]/div[2]")
    private WebElement affiliateSite;
    
    @FindBy(how = How.XPATH, using = "//body")
    private WebElement body;
    
    public OntraportAdmin_Afflink sample () throws Exception
    {
        return PageFactory.initElements(driver, OntraportAdmin_Afflink.class);
    }
    public OntraportAdmin_Afflink trypage () throws Exception
    {	
    	String Website = affiliateSite.getText();
    	driver.get(Website);
        return PageFactory.initElements(driver, OntraportAdmin_Afflink.class);
    }
}