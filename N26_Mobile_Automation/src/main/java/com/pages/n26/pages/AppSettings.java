package com.pages.n26.pages;

import com.pages.n26.base.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class AppSettings extends BasePage {

    @AndroidFindBy(id = "com.monefy.app.lite:id/right_drawer")
    public MobileElement rightDrawer;

    @AndroidFindBy(id = "com.monefy.app.lite:id/categories_panel")
    public MobileElement categoriesBtn;

    @AndroidFindBy(id = "com.monefy.app.lite:id/accounts_panel")
    public MobileElement accountsBtn;

    @AndroidFindBy(id = "com.monefy.app.lite:id/currency_panel")
    public MobileElement currenciesBtn;

    @AndroidFindBy(id = "com.monefy.app.lite:id/settings_panel")
    public MobileElement settingsBtn;

    public AppSettings(AppiumDriver driver) {
        super(driver);
    }

    public void clickSettingsBtn() {
        clickOnElement(settingsBtn);
    }

    public void clickAccountsBtn() {
        clickOnElement(accountsBtn);
    }
}