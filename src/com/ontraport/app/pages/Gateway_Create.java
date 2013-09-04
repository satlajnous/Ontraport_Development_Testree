package com.ontraport.app.pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.ontraport.app.tools.AbstractPage;

public class Gateway_Create extends AbstractPage {
	
		
		protected String   url = "/#!/gateway/create";
		
		@FindBy(how = How.XPATH, using = "//input[@type='text']")
	    private WebElement inputGatewayName;
		
		@FindBy(how = How.XPATH, using = "//button//span[text()='Save']")
	    private WebElement buttonSave;
		
		//@FindBy(how = How.XPATH, using = "//button//span[text()='Save']")
	   // private WebElement selectChooseGatewayType;
		
		@FindBy(how = How.XPATH, using = "//div[input[normalize-space(@placeholder)='Select a Gateway Type']]/descendant::button")
	    private WebElement selectButtonChooseGatewayType;
		
		@FindBy(how = How.XPATH, using = "//div//input[normalize-space(@placeholder)='Select a Gateway Type']")
	    private WebElement selectInputChooseGatewayType;
		
		@FindBy(how = How.XPATH, using = "//div[input[normalize-space(@placeholder)='Select a Gateway Type']]//li/div")
	    private List<WebElement> selectListDIVChooseGatewayType;
		
		@FindBy(how = How.XPATH, using = "//*[@class='ussr-component-input ussr-form-input-type-text  clearfix']")
	    private List<WebElement> txtFieldParentElementsChooseGatewayType;
	
		
		public Gateway_ListAll newGateWay (String gatewayName, String gatewayType, String[] detailTitle, String[] detailValues){
			try {
				inputGatewayName.sendKeys(gatewayName);
				selectDropDownByTyping(gatewayType);
				Thread.sleep(3000);
				//typing into required text fields
				for (int i = 0; i < detailTitle.length; i++) {
					getTextBoxOnTheLabel(detailTitle[i]).sendKeys(detailValues[i]);
				}

				buttonSave.click();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return PageFactory.initElements(driver, Gateway_ListAll.class); 

		}
		
		
		public void selectDropDownByTyping (String option){
	        System.out.println("**************************************************************");


	        System.out.println("option:" + option);

	        selectButtonChooseGatewayType.click();
	        selectInputChooseGatewayType.sendKeys(option);


	        try {
	              Thread.sleep(2000);
	        } catch (InterruptedException e) {
	              // TODO Auto-generated catch block
	              e.printStackTrace();
	        }
	        //driver.findElement(By.xpath("//div[div[text()='"+ruleDesc+"']]//div[input[normalize-space(@placeholder)='"+placeHolder+"']]/descendant::li/div[normalize-space(text())='"+option+"']")).click();
	        //List<WebElement> childEleP = driver.findElements(By.xpath("//div[input[normalize-space(@placeholder)='"+placeHolder+"']]//li/div"));
	        //Iterator<WebElement> childEleIteratorP = childEleP.iterator();
	        System.out.println("*************ChildItems************");
	        System.out.println("Number:"+selectListDIVChooseGatewayType.size());

	        for (int i = 0; i < selectListDIVChooseGatewayType.size(); i++) {
	        	selectButtonChooseGatewayType.sendKeys(Keys.ARROW_DOWN);
	              try {
	                    Thread.sleep(2000);
	              } catch (InterruptedException e) {
	                    // TODO Auto-generated catch block
	                    e.printStackTrace();
	              }
	              List<WebElement> childEle = selectListDIVChooseGatewayType;
	              Iterator<WebElement> childEleIterator = childEle.iterator();
	              while (childEleIterator.hasNext()) {
	                    WebElement webElement = (WebElement) childEleIterator.next();
	                    System.out.println(webElement.getText());
	                    if (webElement.getText().trim().equalsIgnoreCase(option.trim())){
	                          webElement.click();
	                          return;
	                    }

	              }
	        }


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
