package com.ontraport.app.tests;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Gateway_Create;
import com.ontraport.app.pages.Gateway_Edit;
import com.ontraport.app.pages.Gateway_ListAll;
import com.ontraport.app.pages.SalesReport_Settings;
import com.ontraport.app.tools.AbstractTest;
import com.ontraport.app.tools.Common;

public class CreateGateway_TC0585 extends AbstractTest {
	String gateway = "Gateway" + Calendar.getInstance().getTimeInMillis();
	Gateway_ListAll gatewayList = new Gateway_ListAll();

	@Test
	public void testCreateeWAYGateway() throws Exception {
		String[] detailTitle = { "ewayCustomerID", "ewayRefundPassword" };
		String[] detailValues = { "test1", "test2" };
		gatewayList = createGateWayTest(gateway, "eWAY", detailTitle,
				detailValues);
		gatewayList.setHundredRecordsPerPage();
		boolean b1 = gatewayList.isElementPresent(gateway);
		Assert.assertTrue("Gateway Created", b1);

		Gateway_Edit gatewayEdit = gatewayList.clickOnGateWayLink(gateway);

		Common.waitForPage(driver, 3);

		boolean b2 = gatewayEdit.verifyGatewayName(gateway);
		boolean b3 = gatewayEdit.verifyTextInput("ewayCustomerID", "test1");
		boolean b4 = gatewayEdit.verifyTextInput("ewayRefundPassword", "test2");
		
		System.out.println(b2);
		System.out.println(b3);
		System.out.println(b4);
		
		Assert.assertTrue("Gateway Name", b2);
		Assert.assertTrue("Value in Text Field", b3);
		Assert.assertTrue("Value in Text Field", b4);		

	}

	public Gateway_ListAll createGateWayTest(String gatewayName,
			String gatewayType, String[] detailTitle, String[] detailValues)
			throws Exception {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Contact_ListAll contact_ListAll = (Contact_ListAll) new Contact_ListAll()
				.init();
		SalesReport_Settings salesReport_Settings = contact_ListAll
				.navSalesReport();
		Gateway_ListAll gateway_ListAll = salesReport_Settings.clickGateways();
		Gateway_Create gateway_Create = gateway_ListAll.create();
		gateway_ListAll = gateway_Create.newGateWay(gatewayName, gatewayType,
				detailTitle, detailValues);
		return gateway_ListAll;
	}

}
