package com.ontraport.app.tests;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;



import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Gateway_Create;
import com.ontraport.app.pages.Gateway_ListAll;

import com.ontraport.app.pages.SalesReport_Settings;
import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.AbstractTest;

import com.ontraport.app.tools.Common;

public class CreateGateway extends AbstractTest
{	String gateway = "Gateway" + Calendar.getInstance().getTimeInMillis();
	Gateway_ListAll gatewayList= new Gateway_ListAll();
	
	@Test
	public void testCreateDummyGateway () throws Exception{
		 String[] detailTitle = {"nickname"};
	     String[] detailValues = {"test1"};
	     createGateWayTest(gateway, "Dummy Gateway", detailTitle, detailValues);
	     boolean condition  = gatewayList.isElementPresent(gateway);
	     Assert.assertTrue(condition);
	}
	
	@Test
	public void testCreateAuthorizeNetCIMGateway () throws Exception{
		 String[] detailTitle = {"x_login", "x_tran_key"};
	     String[] detailValues = {"test1", "test2"};
	     createGateWayTest(gateway, "Authorize.net CIM", detailTitle, detailValues);
	     boolean condition  = gatewayList.isElementPresent(gateway);
	     Assert.assertTrue(condition);
	}
	
	@Test
	public void testCreateAuthorizeNetGateway () throws Exception{
		 String[] detailTitle = {"x_login", "x_tran_key"};
	     String[] detailValues = {"test1", "test2"};
	     createGateWayTest(gateway, "Authorize.net", detailTitle, detailValues);
	     boolean condition  = gatewayList.isElementPresent(gateway);
	     Assert.assertTrue(condition);
	}
    
	@Test
	public void testCreateElavonGateway () throws Exception{
		 String[] detailTitle = {"ssl_merchant_id", "ssl_user_id", "ssl_pin"};
	     String[] detailValues = {"test1", "test2", "test3"};
	     createGateWayTest(gateway, "Elavon", detailTitle, detailValues);
	     boolean condition  = gatewayList.isElementPresent(gateway);
	     Assert.assertTrue(condition);
	}
	
	@Test
	public void testCreateeWAYGateway () throws Exception{
		 String[] detailTitle = {"ewayCustomerID", "ewayRefundPassword"};
	     String[] detailValues = {"test1", "test2"};
	     createGateWayTest(gateway, "eWAY", detailTitle, detailValues);
	     boolean condition  = gatewayList.isElementPresent(gateway);
	     Assert.assertTrue(condition);
	}
	
	@Test
	public void testCreateeWAYTokenGateway () throws Exception{
		 String[] detailTitle = {"ewayCustomerID", "ewayRefundPassword", "ewayUsername", "ewayPassword"};
	     String[] detailValues = {"test1", "test2", "test3", "test4"};
	     createGateWayTest(gateway, "eWAY Token", detailTitle, detailValues);
	     boolean condition  = gatewayList.isElementPresent(gateway);
	     Assert.assertTrue(condition);
	}
	
	@Test
	public void testCreateNetworkMerchantsIncGateway () throws Exception{
		 String[] detailTitle = {"username", "password"};
	     String[] detailValues = {"test1", "test2"};
	     createGateWayTest(gateway, "Network Merchants Inc", detailTitle, detailValues);
	     boolean condition  = gatewayList.isElementPresent(gateway);
	     Assert.assertTrue(condition);
	}
	
	@Test
	public void testCreatePayflowProGateway () throws Exception{
		 String[] detailTitle = {"USER", "VENDOR", "PARTNER", "PWD"};
	     String[] detailValues = {"test1", "test2", "test3", "test4"};
	     createGateWayTest(gateway, "Payflow Pro", detailTitle, detailValues);
	     boolean condition  = gatewayList.isElementPresent(gateway);
	     Assert.assertTrue(condition);
	}
	
	@Test
	public void testCreatePayJunctionGateway () throws Exception{
		 String[] detailTitle = {"dc_logon", "dc_password"};
	     String[] detailValues = {"test1", "test2"};
	     createGateWayTest(gateway, "PayJunction", detailTitle, detailValues);
	     boolean condition  = gatewayList.isElementPresent(gateway);
	     Assert.assertTrue(condition);
	}
	
	@Test
	public void testCreatePayLeapGateway () throws Exception{
		 String[] detailTitle = {"UserName", "Password"};
	     String[] detailValues = {"test1", "test2"};
	     createGateWayTest(gateway, "PayLeap", detailTitle, detailValues);
	     boolean condition  = gatewayList.isElementPresent(gateway);
	     Assert.assertTrue(condition);
	}
	
	@Test
	public void testCreatePayPalGateway () throws Exception{
		 String[] detailTitle = {"email"};
	     String[] detailValues = {"test1"};
	     createGateWayTest(gateway, "PayPal", detailTitle, detailValues);
	     boolean condition  = gatewayList.isElementPresent(gateway);
	     Assert.assertTrue(condition);
	}
	
	@Test
	public void testCreateQuickBooks_QBMSGateway () throws Exception{
		 String[] detailTitle = {"ConnectionTicket", "AppLogin","AppID"};
	     String[] detailValues = {"test1", "test2", "test3"};
	     createGateWayTest(gateway, "QuickBooks (QBMS)", detailTitle, detailValues);
	     boolean condition  = gatewayList.isElementPresent(gateway);
	     Assert.assertTrue(condition);
	}
	
	@Test
	public void testCreateUSAePayGateway () throws Exception{
		 String[] detailTitle = {"UMkey", "UMpin"};
	     String[] detailValues = {"test1", "test2"};
	     createGateWayTest(gateway, "USAePay", detailTitle, detailValues);
	     boolean condition  = gatewayList.isElementPresent(gateway);
	     Assert.assertTrue(condition);
	}
	
	@Test
	public void testCreateUSAePayTokenGateway () throws Exception{
		 String[] detailTitle = {"UMkey", "UMpin"};
	     String[] detailValues = {"test1", "test2"};
	     createGateWayTest(gateway, "USAePay Token", detailTitle, detailValues);
	     boolean condition  = gatewayList.isElementPresent(gateway);
	     Assert.assertTrue(condition);
	}
	
	@Test
	public void testCreatePayPalPaymentsProGateway () throws Exception{
		 String[] detailTitle = {"USER", "PWD", "SIGNATURE"};
	     String[] detailValues = {"test1", "test2","test3"};
	     createGateWayTest(gateway, "PayPal Payments Pro", detailTitle, detailValues);
	     boolean condition  = gatewayList.isElementPresent(gateway);
	     Assert.assertTrue(condition);
	}
        
    public void createGateWayTest (String gatewayName, String gatewayType, String[] detailTitle, String[] detailValues)throws Exception{	
    	
    	        Contact_ListAll contact_ListAll = (Contact_ListAll) new Contact_ListAll().init();
    	        Common.waitForPage(driver, 30);
    	        SalesReport_Settings salesReport_Settings = contact_ListAll.navSalesReport();
    	        Common.waitForPage(driver, 30);
    	        Gateway_ListAll gateway_ListAll = salesReport_Settings.clickGateways();
    	        Common.waitForPage(driver, 30);
    	        Gateway_Create gateway_Create = gateway_ListAll.create();
    	        Common.waitForPage(driver, 30);
    	        gateway_ListAll = gateway_Create.newGateWay(gatewayName, gatewayType, detailTitle, detailValues);
    	        //Thread.sleep (10000);
    	        
    	        //Assert the created gateway
    	        //gateway_ListAll.logout();
    	    }
}