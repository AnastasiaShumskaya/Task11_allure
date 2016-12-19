package com.selenid.task11;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageobjectsTask11.HomePage;
import pageobjectsTask11.LoginPage;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.TestCaseId;

import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.source;

@Listeners(SomeListener.class)
public class AppTest {

    private static final String URL = "https://192.168.100.26/";
    private static final String USERNAME = "AnastasiaShumskaya";
    private static final String PASSWORD = "1";
    private static final String TITLE = "Office";
    private static final String NAME = "Shumskaya, Anastasia";

    @Test(groups = "fast")
    @TestCaseId("ID-001")
    @Features("Login")
    @Stories("Verify the ability to login to app with valid credentials")
    @Description("test Description")
    public void loginTest() {
        LoginPage rmSysPage = open(URL, LoginPage.class);
        HomePage homePage = rmSysPage.login(USERNAME, PASSWORD);

        Assert.assertTrue(homePage.linkName().contains(NAME), "Profile name is wrong!");
        close();
    }

    @Test(groups = "fast")
    @TestCaseId("ID-002")
    @Features("Login")
    @Stories("Verify the ability to login to app with valid credentials")
    @Description("test Description")
    public void officeTabCase() throws InterruptedException {
        LoginPage rmSysPage = open(URL, LoginPage.class);
        HomePage homePage = rmSysPage.login(USERNAME, PASSWORD);
        homePage.goToOfficeTab();

        Assert.assertTrue(homePage.getTitle().contains(TITLE), "Loaded page is wrong!");
        close();
    }
}
