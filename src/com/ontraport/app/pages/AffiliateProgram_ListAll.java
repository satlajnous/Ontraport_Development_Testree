package com.ontraport.app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.ontraport.app.tools.AbstractPage;

public class AffiliateProgram_ListAll extends AbstractPage
{

    protected String   url = "/#!/affiliate_program/listAll";

    @FindBy(how = How.XPATH, using = "//div[@id='ontraport_panel_action_new']")
    private WebElement linkNewAffiliateProgram;
    
    @FindBy(how = How.XPATH, using = "//*[@id='ussr-chrome-panel-pane']/div[1]/div[1]")
    private WebElement displayAffiliatePageHeader;

    public AffiliateProgram_Create clickNewAffiliateProgram () throws Exception
    {
    	linkNewAffiliateProgram.click();
        return PageFactory.initElements(driver, AffiliateProgram_Create.class);
    }
    
    public AffiliateProgram_Edit clickAffiliationProgram (String affProgName) throws Exception{
    	driver.findElement(By.xpath("//*[normalize-space(text())='" + (affProgName) +"']")).click();
    	Thread.sleep(1000);
    	return PageFactory.initElements(driver, AffiliateProgram_Edit.class);
    }
    
    public String getTextAffiliateHomePage (){
    	String pageHeader= displayAffiliatePageHeader.getText().trim();
    	System.out.println("Affiliate Program Home Page Header: "+pageHeader);
    	return pageHeader;
    }

}