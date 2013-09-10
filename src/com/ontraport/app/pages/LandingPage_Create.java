package com.ontraport.app.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.ontraport.app.tools.AbstractPage;

public class LandingPage_Create extends AbstractPage
{

    protected String   url = "/#!/landing_page/create";

    @FindBy(how = How.XPATH, using = "//input[@type='text']")
    private WebElement inputLandingPageName;
    
    @FindBy(how = How.XPATH, using = "//div[@class='menu_button_class']//td[normalize-space(text())='Page URL:']")
    private WebElement clickPageURL;
    
    @FindBy(how = How.XPATH, using = "//div[@class='ontraport_components_dialog']//input[@class='btn2' and @value='Accept']")
    private WebElement buttonAcceptDialog;
    
    @FindBy(how = How.XPATH, using = "//div[@id='layer_box']/div[contains(normalize-space(text()),'New Item')]")
    private WebElement linkNewItem;
    
    @FindBy(how = How.XPATH, using = "//div[@class='ussr-dialog-content jb-ace-scroll-target']//div[@class='create_button_class']//td[contains(normalize-space(text()),'Shape')]")
    private WebElement linkNewItemShape;
    
    @FindBy(how = How.XPATH, using = "//button//span[text()='Save']")
    private WebElement buttonSave;
    
    @FindBy(how = How.XPATH, using = "//div[@class='blue_box']//input[@name='domaintype']|//td[normalize-space(text())='Use a Hosted Domain']")
	private WebElement radioButtonHostedDomain;
  
	@FindBy(how = How.XPATH, using = "//div[@class=\"ontraport_components_dialog\"]/div[@class='blue_box']//td[normalize-space(text())='http://']/input[@class='inpt_text standard_input']")
	private WebElement inputTextInDomainPopUp;
  
    public LandingPage_ListAll createNewLandingPage (String lpName,String URL) throws Exception
    {	
    	Thread.sleep(1000);
    	inputLandingPageName.clear();
    	inputLandingPageName.sendKeys(lpName);
    	Thread.sleep(1000);
    	clickPageURL.click();
    	Thread.sleep(1000);
    	radioButtonHostedDomain.click();
    	inputTextInDomainPopUp.click();
    	inputTextInDomainPopUp.sendKeys(URL);
    	Thread.sleep (3000);
    	buttonAcceptDialog.click();
    	Thread.sleep(1000);
    	linkNewItem.click();
    	linkNewItemShape.click();
    	Thread.sleep(1000);
    	buttonSave.click();
        return PageFactory.initElements(driver, LandingPage_ListAll.class);
    } 
    
    public LandingPage_ListAll createBasicLandingPage(String lpName) throws Exception{
    	Thread.sleep(1000);
    	inputLandingPageName.clear();
    	inputLandingPageName.sendKeys(lpName);
    	Thread.sleep(1000);
    	buttonSave.click();
    	return PageFactory.initElements(driver, LandingPage_ListAll.class);	
    }
}