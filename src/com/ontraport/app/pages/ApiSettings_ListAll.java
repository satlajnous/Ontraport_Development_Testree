package com.ontraport.app.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.ontraport.app.tools.AbstractPage;

public class ApiSettings_ListAll extends AbstractPage
{

    protected String   url = "/#!/api_settings/listAll";
    
    @FindBy(how = How.XPATH, using = "//tr[@class='sem-collection-header-display']//a[.='Name']")
    private WebElement nameColumn;
    
    @FindBy(how = How.CSS, using = "span.ussr-icon.ussr-icon-checkbox-empty")
    private WebElement checkBox;
    
    @FindBy(how = How.XPATH, using = "//div[@id='ontraport_panel_action_new']//span[.='New API Key']")
    private WebElement newAPIKey;
  
    @FindBy(how = How.XPATH, using = "//body")
    private WebElement body;

    public ApiSettings_Create clickNewAPI () throws Exception
    {
    	newAPIKey.click();
        return PageFactory.initElements(driver, ApiSettings_Create.class);
    }
    
    public ApiSettings_ListAll sample () throws Exception
    {
        return PageFactory.initElements(driver, ApiSettings_ListAll.class);
    }
    public AbstractPage selectAPI () throws InterruptedException
    {	
    	Actions builder = new Actions(driver);
    	builder.moveToElement(nameColumn).click().build().perform();
    	builder.moveToElement(checkBox).click().build().perform();
        //deleteButton.click();
        return PageFactory.initElements(driver, this.getClass());
    }

}