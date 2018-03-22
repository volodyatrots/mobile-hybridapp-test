package com.epam.lab.businessobjects;

import com.epam.lab.pageobjects.MenuBrowserPage;
import org.apache.log4j.Logger;

public class BrowserBO {
    private static final Logger LOG = Logger.getLogger(GmailLoginBO.class);
    private MenuBrowserPage menuBrowserPage;

    public BrowserBO() {
        menuBrowserPage = new MenuBrowserPage();
    }

    public void openMenu() {
        LOG.info("Opening Menu Browser");
        menuBrowserPage.openMenu();
    }

    public void showCurrentTabs() {
        LOG.info("Show All Tabs");
        menuBrowserPage.openTabs();
    }

    public void createNewTab() {
        LOG.info("Add New Tab");
        menuBrowserPage.openNewTab();
    }
}
