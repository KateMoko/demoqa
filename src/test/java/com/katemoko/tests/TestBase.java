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
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    TextBoxPage textBoxPage = new TextBoxPage();

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = System.getProperty("baseUrl");
        String[] browserAndVersion = System.getProperty("browser").split(":");
        Configuration.browser = browserAndVersion[0];
        Configuration.browserVersion = browserAndVersion[1];
        Configuration.browserSize = System.getProperty("browserSize");
        Configuration.pageLoadStrategy = "eager";

        Configuration.remote = String.format("https://%s:%s@%s",
                System.getProperty("selenoidLogin"),
                System.getProperty("selenoidPassword"),
                System.getProperty("selenoidUrl").replace("https://", "")
        );

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));

        Configuration.browserCapabilities = capabilities;
    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterEach
    void addAttachment() {
        Attach.screenshotAs("Last step screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}