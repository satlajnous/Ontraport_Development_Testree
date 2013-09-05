package com.ontraport.app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.ontraport.app.tools.AbstractPage;

public class AffiliateProgram_Edit extends AbstractPage
{

    protected String   url = "/#!/affiliate_program/edit&id=";

    @FindBy(how = How.XPATH, using = "//div[label[text()='New Affiliates']]//div//span")
    private WebElement displayNewAffiliation;
    
    @FindBy(how = How.XPATH, using = "//div[label[text()='Program Type']]//div//span")
    private WebElement displayProgramType;
    
    @FindBy(how = How.XPATH, using = "//div[label[text()='How much Information on Referral do you want to share with affiliate']]//div//span")
    private WebElement displayHowMuchInfo;
    
    @FindBy(how = How.XPATH, using = "//div[label[text()='Show affiliates information on declined charges']]//div//span")
    private WebElement displayaffiliateInfoDeclinedCharges;
    
    @FindBy(how = How.XPATH, using = "//div[label[text()='Show affiliates complete purchase history for each referred client']]//div//span")
    private WebElement displayaffiliateCompletePurchaseHistory;
    
    @FindBy(how = How.XPATH, using = "//div[label[text()='Notify someone when affiliate has earned a commission with an email']]//div")
    private WebElement displaynotifyEmail;
    
    public String getTextNewAffliation (){
    	String newAff= displayNewAffiliation.getText().trim();
    	System.out.println("New Affiliates: "+newAff);
    	return newAff;
    }
    
    public String getTextProgramType (){
    	String progType= displayProgramType.getText().trim();
    	System.out.println("Program Type: "+progType);
    	return progType;
    }
    
    public String getTextHowMuchInfo (){
    	String howMuchInfo= displayHowMuchInfo.getText().trim();
    	System.out.println("How much Info: "+howMuchInfo);
    	return howMuchInfo;
    }
    
    public String getTextAffiliateInfoOnDeclinedCharges (){
    	String affiliateInfoDeclinedCharges= displayaffiliateInfoDeclinedCharges.getText().trim();
    	System.out.println("Affiliate Info Declined Charges:"+affiliateInfoDeclinedCharges);
    	return affiliateInfoDeclinedCharges;
    }
    
    public String getTextAffiliatePurchaseHistory (){
    	String affiliateCompletePurchaseHistory= displayaffiliateCompletePurchaseHistory.getText().trim();
    	System.out.println("New Affiliates: "+affiliateCompletePurchaseHistory);
    	return affiliateCompletePurchaseHistory;
    }
    
    public String getTextNotifyWithEmail (){
    	String notifyEmail= displaynotifyEmail.getText().trim();
    	System.out.println("Notify Email: "+notifyEmail);
    	return notifyEmail;
    }
    
    
}