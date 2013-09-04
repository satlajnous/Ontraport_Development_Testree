package com.ontraport.app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.Common;

public class Gateway_ListAll  extends AbstractPage
{

    protected String   url = "/#!/gateway/listAll";

    @FindBy(how = How.XPATH, using = "//div[@id='ontraport_panel_action_new']")
    private WebElement linkToCreate;
    
    @FindBy(how = How.XPATH, using = "//div[label[text()='RECORDS']]/descendant::button")
    private WebElement selectButtonRecordsPerPage;
    
    @FindBy(how = How.XPATH, using = "//div[label[text()='RECORDS']]/descendant::li/div[text()='100']")
    private WebElement selectListDiv100Records;
    
        
    public Gateway_Create create () throws Exception
    {
        
        try {
            linkToCreate.click();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        return PageFactory.initElements(driver, Gateway_Create.class);
    }
    
    
   /* public Gateway_ListAll setHundredRecordsPerPage (){
		try {
			selectButtonRecordsPerPage.click();
			Thread.sleep(2000);
			selectListDiv100Records.click();
			Thread.sleep(5000);
			Common.waitForPage(driver, 30);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return PageFactory.initElements(driver, Gateway_ListAll.class);
	}*/
    
    
    public Gateway_ListAll clickOnGateWayLink (String gatewayName){
		try {
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return PageFactory.initElements(driver, Gateway_ListAll.class);
	}
    
    

}
