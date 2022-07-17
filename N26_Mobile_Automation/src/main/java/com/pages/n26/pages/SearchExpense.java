package com.pages.n26.pages;

import com.pages.n26.base.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SearchExpense extends BasePage {

    @AndroidFindBy(id = "com.monefy.app.lite:id/title_text_view")
    public MobileElement itemTitle;

    @AndroidFindBy(id = "com.monefy.app.lite:id/amount_text_view")
    public MobileElement itemPrice;

    @AndroidFindBy(id = "com.monefy.app.lite:id/date_text_view")
    public MobileElement itemDate;

    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Open navigation\"]")
    public MobileElement backBtn;

    @AndroidFindBy(accessibility = "Delete")
    public MobileElement deleteIcon;

    public SearchExpense(AppiumDriver driver) {
        super(driver);
    }

    public void clickTitleView(){
        clickOnElement(itemTitle);
    }

    public void clickDeleteIcon(){
        clickOnElement(deleteIcon);
    }

    public void clickBackBtn(){
        clickOnElement(backBtn);
    }
}