package com.test.n26.tests;

import com.pages.n26.pages.*;
import com.test.n26.base.BaseTest;
import com.test.n26.utils.TestUtils;
import org.testng.Assert;
import org.testng.annotations.*;

import static com.test.n26.listeners.TestListener.info;

public class CurrencyChange extends BaseTest {

    AppLanding onBoardingPage;
    AppSettings settingsPage;
    MenuBar menuBarPage;
    CategoriesList categoriesPage;
    TestUtils generalUtils;
    AppHome home;

    @BeforeClass
    public void beforeClass() {
        onBoardingPage = new AppLanding(getDriver());
        settingsPage = new AppSettings(getDriver());
        menuBarPage = new MenuBar(getDriver());
        categoriesPage = new CategoriesList(getDriver());
        generalUtils = new TestUtils();
        home = new AppHome(getDriver());
    }

    @AfterMethod
    public void clearApp(){
        getDriver().resetApp();
    }

    @Test
    public void changeCurrency() {

        generalUtils.closeStartingDialogs(onBoardingPage);

        menuBarPage.clickSettingsBtn();
        info("Account Setting button clicked.");

        settingsPage.clickSettingsBtn();
        info("Settings option clicked.");

        categoriesPage.clickCurrencyBtn();
        info("Change Currency button clicked.");

        categoriesPage.enterCurrency("PKR");
        info("Enter PKR currency.");

        categoriesPage.selectCurrencyBtn();
        info("Select PKR currency.");

        menuBarPage.clickSettingsBtn();
        info("Account Setting button clicked to close navigation.");

        Assert.assertEquals(home.balanceAmountTxt.getText(), "Balance PKR0.00");
        info("Currency changed verified.");

    }
}