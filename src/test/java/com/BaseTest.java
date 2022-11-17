package com;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import io.qameta.allure.selenide.LogType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.Attach;

import java.util.logging.Level;



public class BaseTest {

    @BeforeAll
    static void configure() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(true)
                .enableLogs(LogType.BROWSER, Level.ALL)
        );

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", System.getProperty("browse", "chrome"));
        capabilities.setCapability("browserVersion", System.getProperty("version", "100.0"));
        capabilities.setCapability("enableVNC", System.getProperty("enableVNC"));
        capabilities.setCapability("enableVideo", System.getProperty("enableVideo"));

        Configuration.browserCapabilities = capabilities;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = System.getProperty("resolution");
        Configuration.remote = System.getProperty("remote");
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        if ((System.getProperty("enableVideo") != null)) {
            Attach.addVideo();
        }
    }
}
