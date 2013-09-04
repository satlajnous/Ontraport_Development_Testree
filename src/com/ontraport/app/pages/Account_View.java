package com.ontraport.app.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.ontraport.app.tools.AbstractPage;

public class Account_View extends AbstractPage
{

    protected String   url = "/#!/account/view";

    @FindBy(how = How.XPATH, using = "//div[@class='ussr-settings']//div[.='SOFTWARE AFFILIATE LINKS']")
    private WebElement softwareAffiliateLinks;
    
    @FindBy(how = How.XPATH, using = "//div[@class='ussr-settings']//div[.='1SHOPPINGCART SYNCING']")
    private WebElement oneSCSync;
    
    @FindBy(how = How.XPATH, using = "//div[@class='ussr-settings']//div[.='Get Affiliate Tracking Pixel']")
    private WebElement affiliateTrackingPixel;
  
    @FindBy(how = How.XPATH, using = "//div[@class='ussr-settings']/div[2]/div[1]/ul/li[1]/a/div[1]")
    private WebElement API;
    
    @FindBy(how = How.XPATH, using = "//a[@href='#!/tag/listAll']//div[text()='MANAGE TAGS']")
    private WebElement manageTags;

    public Account_View sample () throws Exception
    {
        return PageFactory.initElements(driver, Account_View.class);
    }
    
    public OntraportAdmin_Afflink clickSoftwareAffiliateLinks () throws Exception
    {
    	softwareAffiliateLinks.click();
        return PageFactory.initElements(driver, OntraportAdmin_Afflink.class);
    }
    public OneShoppingCart_View clickOneSCSync () throws Exception
    {
    	oneSCSync.click();
        return PageFactory.initElements(driver, OneShoppingCart_View.class);
    }
    public OntraportAdmin_TrackingPixel clickTrackingPixel () throws Exception
    {
    	affiliateTrackingPixel.click();
        return PageFactory.initElements(driver, OntraportAdmin_TrackingPixel.class);
    }
    public ApiSettings_ListAll clickAPI () throws Exception
    {
    	API.click();
        return PageFactory.initElements(driver, ApiSettings_ListAll.class);
    }
    
    public Tag_ListAll clickManageTags() throws Exception {
    	manageTags.click();
    	return PageFactory.initElements(driver, Tag_ListAll.class);
    }
    
}