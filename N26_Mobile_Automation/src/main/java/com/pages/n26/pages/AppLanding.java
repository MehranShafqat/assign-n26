package com.pages.n26.pages;

import com.pages.n26.base.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class AppLanding extends BasePage {

    @AndroidFindBy(id = "com.monefy.app.lite:id/buttonContinue")
    public MobileElement getStartedBtn;

    @AndroidFindBy(id = "com.monefy.app.lite:id/buttonClose")
    public MobileElement closeBtn;

    public AppLanding(AppiumDriver driver) {
        super(driver);
    }

    public void clickGetStartedBtn() {
        clickOnElement(getStartedBtn);
    }

    public void closeSubscriptionDialog() {
        clickOnElement(closeBtn);
    }
}