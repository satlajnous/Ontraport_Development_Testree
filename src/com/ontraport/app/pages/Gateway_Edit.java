package com.ontraport.app.pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.ontraport.app.tools.AbstractPage;

public class Gateway_Edit extends AbstractPage
{

    protected String   url = "/#!/gateway/edit&id=";

    @FindBy(how = How.XPATH, using = "//*[@id='ussr-chrome-panel-pane']/div[3]/div/div[3]/div/div/div/input")
	private WebElement displayName;
    
    @FindBy(how = How.XPATH, using = "//*[@class='ussr-component-input ussr-form-input-type-text  clearfix']")
    private List<WebElement> txtFieldParentElementsChooseGatewayType;
  

    public boolean verifyGatewayName(String condition){
		String gatewayName=displayName.getAttribute("value").trim();
		if(gatewayName.equals(condition.trim())){
			return true;
		}
		return false;
	}
    
    public boolean verifyTextInput (String label, String textValue)throws Exception{
    	
    	WebElement textInFieldLabel= getTextBoxOnTheLabel(label);
    	String text= textInFieldLabel.getAttribute("value");
    	System.out.println("Text value: "+ text);
        	if(text.equals(textValue.trim())){
        		return true;
        	}
    		
    	return false;
    }
    
    public WebElement getTextBoxOnTheLabel (String textboxLabel) throws Exception{
		Iterator<WebElement> itr = txtFieldParentElementsChooseGatewayType.iterator();
		while (itr.hasNext()) {
			WebElement eachParentElement = (WebElement) itr.next();
			String textfromApp = eachParentElement.getText().trim();
			System.out.println (textfromApp);
			if (textfromApp.equalsIgnoreCase(textboxLabel)){
				//return eachParentElement.findElement(By.xpath(".//input[@type='text']"));
				return eachParentElement.findElement(By.xpath(".//input[@type='text']"));
			}
			
		}
		
		throw new Exception ("No Label Match found");
	}

}