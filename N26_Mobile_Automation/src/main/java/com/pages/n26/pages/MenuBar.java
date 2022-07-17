package com.pages.n26.pages;

import com.pages.n26.base.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class MenuBar extends BasePage {

    @AndroidFindBy(accessibility = "Open navigation")
    public MobileElement openNavigationBtn;

    @AndroidFindBy(accessibility = "Settings")
    public MobileElement settingsBtn;

    @AndroidFindBy(accessibility = "Search records")
    public MobileElement searchRecordsBtn;

    @AndroidFindBy(id = "com.monefy.app.lite:id/et_search")
    public MobileElement topSearchBar;

    @AndroidFindBy(accessibility = "Up navigation button")
    public MobileElement navigationBackBtn;

    @AndroidFindBy(id = "com.monefy.app.lite:id/transfer_menu_item")
    public MobileElement transferAmountBtn;

    @AndroidFindBy(id = "com.monefy.app.lite:id/tv_str")
    public MobileElement searchResult;

    public MenuBar(AppiumDriver driver) {
        super(driver);
    }

    public void clickSettingsBtn(){
        clickOnElement(settingsBtn);
    }

    public void clickSearchIcon(){
        clickOnElement(searchRecordsBtn);
    }

    public void searchRecords(String record){
        setValueInTextField(topSearchBar, record);
    }

    public void closeNavigation(){
        clickOnElement(navigationBackBtn);
    }
    public void clickSearchResult(){
        clickOnElement(searchResult);
    }
}