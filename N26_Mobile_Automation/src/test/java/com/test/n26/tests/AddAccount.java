package com.test.n26.tests;

import com.pages.n26.pages.*;
import com.test.n26.base.BaseTest;
import com.test.n26.utils.TestUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.test.n26.listeners.TestListener.info;

public class AddAccount extends BaseTest {

    AppLanding onBoardingPage;
    AppSettings settingsPage;
    MenuBar menuBarPage;
    CategoriesList categoriesPage;
    TestUtils generalUtils;
    AppHome home;
    Account account;
    JSONObject jsonObject;

    @BeforeClass
    public void beforeClass() throws IOException, ParseException {
        onBoardingPage = new AppLanding(getDriver());
        settingsPage = new AppSettings(getDriver());
        menuBarPage = new MenuBar(getDriver());
        categoriesPage = new CategoriesList(getDriver());
        generalUtils = new TestUtils();
        home = new AppHome(getDriver());
        account = new Account(getDriver());
        jsonObject = generalUtils.readJSONFileData();
    }

    @AfterMethod
    public void clearApp() {
        getDriver().resetApp();
    }

    @Test
    public void changeCurrency() {

        generalUtils.closeStartingDialogs(onBoardingPage);

        menuBarPage.clickSettingsBtn();
        info("Account Setting button clicked.");

        settingsPage.clickAccountsBtn();
        info("Accounts option clicked.");

        account.clickAddBtn();
        info("Add account option clicked.");

        account.enterUserName(jsonObject.get("user").toString());
        info("User name entered.");

        account.enterInitialAmount(jsonObject.get("addInitialAmount").toString());
        info("Initial amount entered.");

        account.btnAccountType();
        info("Account type selected.");

        account.btnSaveData();
        info("Save button clicked.");

        menuBarPage.clickSettingsBtn();
        info("Account Setting button clicked.");

        settingsPage.clickAccountsBtn();
        info("Accounts option clicked.");

        Assert.assertEquals(account.addBtn.get(2).getText(), jsonObject.get("user").toString());
        info("Accounts added successfully and verified.");

        Assert.assertEquals(account.accountAmount.get(1).getText(), jsonObject.get("initialAmount").toString());
        info("Account amount added successfully and verified.");
    }
}