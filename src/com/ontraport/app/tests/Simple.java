package com.ontraport.app.tests;

import static org.junit.Assert.fail;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.parts.ActionsMenu;
import com.ontraport.app.tools.AbstractTest;

public class Simple extends AbstractTest
{
    protected Contact_ListAll contact_ListAll = (Contact_ListAll) new Contact_ListAll().init();
    @Test
    public void sanity () throws Exception
    {
        ActionsMenu actionsMenu = contact_ListAll.openActionsMenu();
        if (!actionsMenu.isVisible()) fail("Actions Menu is not visible.");
        actionsMenu.close();
        contact_ListAll.create().logout();
    }
}
