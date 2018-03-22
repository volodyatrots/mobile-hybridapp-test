package com.epam.lab.pageobjects;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;


public class MenuBrowserPage extends MobilePageObject {

    @FindBy(id = "menu_button")
    public MobileElement menuButton;

    @FindBy(id = "tab_switcher_button")
    public MobileElement tabSwitcherButton;

    @FindBy(id = "menu_item_text")
    public MobileElement newTabButton;


    public void openMenu() {
        menuButton.click();
    }

    public void openTabs() {
        tabSwitcherButton.click();
    }

    public void openNewTab() {
        newTabButton.click();
    }
}
