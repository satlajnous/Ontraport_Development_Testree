package com.ontraport.app.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.ontraport.app.tools.AbstractPage;

public class AffiliateProgram_Create extends AbstractPage
{

    protected String   url = "/#!/affiliate_program/create";

    @FindBy(how = How.XPATH, using = "//div[label[text()='Program Name']]//input")
    private WebElement inputProgramName;
    
    @FindBy(how = How.XPATH, using = "//div[input[normalize-space(@placeholder)='Select New Affiliates...']]/descendant::button")
    private WebElement selectButtonNewAffiliates;
	
	@FindBy(how = How.XPATH, using = "//div//input[normalize-space(@placeholder)='Select New Affiliates...']")
    private WebElement selectInputChooseNewAffiliates;
	
	@FindBy(how = How.XPATH, using = "//div[input[normalize-space(@placeholder)='Select New Affiliates...']]//li/div")
    private List<WebElement> selectListDIVChooseNewAffiliates;
    
	@FindBy(how = How.XPATH, using = "//div[input[normalize-space(@placeholder)='Select Program Type...']]/descendant::button")
    private WebElement selectButtonProgramType;
	
	@FindBy(how = How.XPATH, using = "//div//input[normalize-space(@placeholder)='Select Program Type...']")
    private WebElement selectInputChooseProgramType;
	
	@FindBy(how = How.XPATH, using = "//div[input[normalize-space(@placeholder)='Select Program Type...']]//li/div")
    private List<WebElement> selectListDIVChooseProgramType;
    
	@FindBy(how = How.XPATH, using = "//div[input[normalize-space(@placeholder)='Select How Much Information On Referral Do You Want To Share With Affiliate...']]/descendant::button")
    private WebElement selectButtonHowMuchInfo;
	
	@FindBy(how = How.XPATH, using = "//div//input[normalize-space(@placeholder)='Select How Much Information On Referral Do You Want To Share With Affiliate...']")
    private WebElement selectInputChooseHowMuchInfo;
	
	@FindBy(how = How.XPATH, using = "//div[input[normalize-space(@placeholder)='Select How Much Information On Referral Do You Want To Share With Affiliate...']]//li/div")
    private List<WebElement> selectListDIVChooseHowMuchInfo;
    
    @FindBy(how = How.XPATH, using = "//div[label[text()='Show affiliates information on declined charges']]//a//span")
    private WebElement checkboxAffiliateOnDeclinedTransaction;
    
    @FindBy(how = How.XPATH, using = "//div[label[text()='Show affiliates complete purchase history for each referred client']]//a//span")
    private WebElement checkboxAffiliatePurchaseHistory;
    
    @FindBy(how = How.XPATH, using = "//div[label[text()='Notify someone when affiliate has earned a commission with an email']]//input[@placeholder='Select User']")
    private WebElement selectNotifyWithEmail;
    
    @FindBy(how = How.XPATH, using = "//li//span[normalize-space(text())='Custom E-mail']")
    private WebElement selectCustomEmail;
    
    @FindBy(how = How.XPATH, using = "//div[@class='ussr-custom-value-editor-wrapper']//input[@type='text']")
    private WebElement inputCustomEmailText;
    
    @FindBy(how = How.XPATH, using = "//div[@class='ussr-custom-value-editor-wrapper']//span[text()='Select']")
    private WebElement buttonCustomEmailSelect;
    
    @FindBy(how = How.XPATH, using = "//button//span[text()='Save']")
    private WebElement buttonSave;
    
    @FindBy(how = How.XPATH, using = "//div[text()='Back']")
	private WebElement buttonBack;

	@FindBy(how = How.XPATH, using = "//button//span[text()='Cancel']")
	private WebElement buttonCancel;
  
    public AffiliateProgram_ListAll programCreate (String name, String newAffOption, String newProgTypeOption, String howMuchInfo, String affiliateOnDeclinedTransaction, String affiliatePurchaseHistory, String emailID ) throws Exception
    {	
    	inputProgramName.sendKeys(name);
    	Thread.sleep(1000);
    	selectDropDownByTyping(selectButtonNewAffiliates, selectInputChooseNewAffiliates, selectListDIVChooseNewAffiliates, newAffOption);
    	Thread.sleep(1000);
    	selectDropDownByTyping(selectButtonProgramType, selectInputChooseProgramType, selectListDIVChooseProgramType, newProgTypeOption);
    	Thread.sleep(1000);
    	selectDropDownByTyping(selectButtonHowMuchInfo, selectInputChooseHowMuchInfo, selectListDIVChooseHowMuchInfo, howMuchInfo);
    	Thread.sleep(1000);
    	if(affiliateOnDeclinedTransaction.equals("YES")){
    		checkboxAffiliateOnDeclinedTransaction.click();
    	}
    	if(affiliatePurchaseHistory.equals("YES")){
    		checkboxAffiliatePurchaseHistory.click();
    	}
    	selectNotifyWithEmail.click();
    	Thread.sleep(1000);
    	selectCustomEmail.click();
    	Thread.sleep(1000);
		inputCustomEmailText.sendKeys(emailID);
    	Thread.sleep(1000);
    	buttonCustomEmailSelect.click();
    	buttonSave.click();
    	Thread.sleep(1000);
        return PageFactory.initElements(driver, AffiliateProgram_ListAll.class);
    }
    
    public AffiliateProgram_ListAll clickCancel(){
    	buttonCancel.click();
    	return PageFactory.initElements(driver, AffiliateProgram_ListAll.class);
    }
    
    public AffiliateProgram_ListAll clickBack(){
    	buttonBack.click();
    	return PageFactory.initElements(driver, AffiliateProgram_ListAll.class);
    }
    

}