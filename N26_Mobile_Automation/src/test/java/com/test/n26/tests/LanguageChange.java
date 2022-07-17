package com.test.n26.tests;

import com.pages.n26.pages.*;
import com.test.n26.utils.TestUtils;
import com.test.n26.base.BaseTest;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;

import static com.test.n26.listeners.TestListener.info;

public class LanguageChange extends BaseTest {

    AppLanding onBoardingPage;
    AppSettings settingsPage;
    MenuBar menuBarPage;
    CategoriesList categoriesPage;

    TestUtils utils;

    Account account;

    JSONObject jsonObject;

    @BeforeClass
    public void beforeClass() throws IOException, ParseException {
        onBoardingPage = new AppLanding(getDriver());
        settingsPage = new AppSettings(getDriver());
        menuBarPage = new MenuBar(getDriver());
        categoriesPage = new CategoriesList(getDriver());
        utils = new TestUtils();
        account = new Account(getDriver());
        jsonObject = utils.readJSONFileData();
    }

    @Test
    public void changeLanguage() {

        utils.closeStartingDialogs(onBoardingPage);

        menuBarPage.clickSettingsBtn();
        info("Account Setting button clicked.");

        settingsPage.clickSettingsBtn();
        info("Settings option clicked.");

        categoriesPage.clickLanguageBtn();
        info("Change Language button clicked.");

        categoriesPage.closeLanguageDialog();
        info("Close Language dialog button clicked.");

        menuBarPage.clickSettingsBtn();
        info("Account Setting button clicked.");

        menuBarPage.clickSettingsBtn();
        info("Account Setting button clicked.");

        settingsPage.clickAccountsBtn();
        info("Accounts option clicked.");

        Assert.assertEquals(account.addBtn.get(0).getText(), "Add");
        info("English language verified.");
    }

    @AfterMethod
    public void clearApp(){
        getDriver().resetApp();
    }
}