package com.katemoko.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.katemoko.helpers.Attach;
import com.katemoko.pages.RegistrationPage;
import com.katemoko.pages.TextBoxPage;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    TextBoxPage textBoxPage = new TextBoxPage();

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";

    }

    @BeforeEach
    void addListener(){
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterEach
    void addAttachment(){
        Attach.screenshotAs("Last step screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
    }
}