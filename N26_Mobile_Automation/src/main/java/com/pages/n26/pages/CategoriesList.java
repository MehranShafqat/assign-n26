package com.pages.n26.pages;

import com.pages.n26.base.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;

public class CategoriesList extends BasePage {

    @AndroidFindBy(id = "com.monefy.app.lite:id/relativeLayoutManageCategoriesListItem")
    public List<MobileElement> categoriesList;

    @AndroidFindBy(id = "com.monefy.app.lite:id/is_budget_mode_checkbox")
    public MobileElement budgetBtn;

    @AndroidFindBy(id="com.monefy.app.lite:id/budget_amount")
    public MobileElement budgetAmount;

    @AndroidFindBy(id = "com.monefy.app.lite:id/is_carryover_checkbox")
    public MobileElement carryOverBtn;

    @AndroidFindBy(id = "com.monefy.app.lite:id/is_post_future_repeating_records_checkbox")
    public MobileElement futureBtn;

    @AndroidFindBy(id = "com.monefy.app.lite:id/buttonBuyFullApp")
    public MobileElement buyFullAppBtn;

    @AndroidFindBy(id = "com.monefy.app.lite:id/language_selection_button")
    public MobileElement languageBtn;

    @AndroidFindBy(id = "com.monefy.app.lite:id/currency_selection_button")
    public MobileElement currencyBtn;

    @AndroidFindBy(id = "com.monefy.app.lite:id/buttonExportToCsv")
    public MobileElement exportToFileBtn;

    @AndroidFindBy(id = "com.monefy.app.lite:id/is_dropbox_synchronization_enabled_checkbox")
    public MobileElement dropBoxSyncBtn;

    @AndroidFindBy(id = "com.monefy.app.lite:id/is_drive_synchronization_enabled_checkbox")
    public MobileElement googleDriveSyncBtn;

    @AndroidFindBy(id = "com.monefy.app.lite:id/backup_database_button")
    public MobileElement backUpDBBtn;

    @AndroidFindBy(id = "com.monefy.app.lite:id/restore_database_button")
    public MobileElement restoreDBBtn;

    @AndroidFindBy(id = "com.monefy.app.lite:id/clear_database_button")
    public MobileElement clearDBBtn;

    @AndroidFindBy(id = "android:id/button1")
    public MobileElement closeLanguageDialog;

    @AndroidFindBy(id = "com.monefy.app.lite:id/search_src_text")
    public MobileElement searchCurrencyField;

    @AndroidFindBy(id = "com.monefy.app.lite:id/relativeLayoutManageCategoriesListItem")
    public MobileElement selectCurrencyBtn;

    public CategoriesList(AppiumDriver driver) {
        super(driver);
    }

    public void clickLanguageBtn(){
        clickOnElement(languageBtn);
    }

    public void closeLanguageDialog(){
        clickOnElement(closeLanguageDialog);
    }

    public void clickCurrencyBtn(){
        clickOnElement(currencyBtn);
    }

    public void enterCurrency(String currency){
        setValueInTextField(searchCurrencyField,currency);
    }

    public void selectCurrencyBtn(){
        clickOnElement(selectCurrencyBtn);
    }

    public void enableBudgetMode(){
        clickOnElement(budgetBtn);
    }

}