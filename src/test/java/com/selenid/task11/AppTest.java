package com.selenid.task11;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageobjectsTask11.HomePage;
import pageobjectsTask11.LoginPage;
import ru.yandex.qatools.allure.annotations.*;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Listeners(SomeListener.class)
public class AppTest {

    private static final String URL = "https://192.168.100.26/";
    private static final String USERNAME = "AnastasiaShumskaya";
    private static final String PASSWORD = "1";
    private static final String TITLE = "Home";
    private static final String NAME = "Shumskaya, Anastasia";

    @Test(groups = "fast")
    @TestCaseId("ID-001")
    @Features("Login")
    @Stories("Verify the ability to login to app with valid credentials")
    @Description("test Description")
    public void loginTest() {
        LoginPage rmSysPage = open(URL, LoginPage.class);
        HomePage homePage = rmSysPage.login(USERNAME, PASSWORD);

        $(homePage.getTitle()).shouldHave(text(TITLE));
    }

    @Test(groups = "fast")
    @TestCaseId("ID-002")
    @Features("Login")
    @Stories("Verify the ability to login to app with valid credentials")
    @Description("test Description")
    public void officeTabCase() {
        LoginPage rmSysPage = open(URL, LoginPage.class);
        HomePage homePage = rmSysPage.login(USERNAME, PASSWORD);
        homePage.goToOfficeTab();

        $(homePage.linkName()).shouldHave(text(NAME));
    }
}
