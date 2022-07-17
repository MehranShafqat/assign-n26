package com.pages.n26.pages;

import com.pages.n26.base.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class DatesSettings extends BasePage {

    @AndroidFindBy(id = "com.monefy.app.lite:id/date_period_group")
    public MobileElement datePeriodGroupBtn;

    @AndroidFindBy(id = "com.monefy.app.lite:id/account_spinner")
    public MobileElement accountSpinnerBtn;

    @AndroidFindBy(id = "com.monefy.app.lite:id/title")
    public MobileElement accountTitleTxt;

    @AndroidFindBy(id = "com.monefy.app.lite:id/currency_name")
    public MobileElement accountCurrencyTxt;

    @AndroidFindBy(id = "com.monefy.app.lite:id/day_period_button")
    public MobileElement dayPeriodBtn;

    @AndroidFindBy(id = "com.monefy.app.lite:id/week_period_button")
    public MobileElement weekPeriodBtn;

    @AndroidFindBy(id = "com.monefy.app.lite:id/month_period_button")
    public MobileElement monthPeriodBtn;

    @AndroidFindBy(id = "com.monefy.app.lite:id/year_period_button")
    public MobileElement yearPeriodBtn;

    @AndroidFindBy(id = "com.monefy.app.lite:id/all_period_button")
    public MobileElement allPeriodBtn;

    @AndroidFindBy(id = "com.monefy.app.lite:id/custom_period_button")
    public MobileElement customPeriodBtn;

    @AndroidFindBy(id = "com.monefy.app.lite:id/show_datepicker_button")
    public MobileElement showDatePickerBtn;

    @AndroidFindBy(id = "com.monefy.app.lite:id/mtrl_picker_header_toggle")
    public MobileElement editDatePickerBtn;

    @AndroidFindBy(id = "com.monefy.app.lite:id/confirm_button")
    public MobileElement confirmDatePickBtn;

    @AndroidFindBy(id = "com.monefy.app.lite:id/mtrl_picker_text_input_date")
    public MobileElement addInputDate;

    @AndroidFindBy(id = "com.monefy.app.lite:id/cancel_button")
    public MobileElement cancelDatePickBtn;

    public DatesSettings(AppiumDriver driver) {
        super(driver);
    }
}