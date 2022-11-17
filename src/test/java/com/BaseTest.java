package com;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Allure;
import io.qameta.allure.model.Label;
import org.junit.jupiter.api.BeforeEach;

import java.util.List;

import static com.codeborne.selenide.Browsers.CHROME;
import static com.codeborne.selenide.Browsers.FIREFOX;

public class BaseTest {
    @BeforeEach
    public void setUp() {
        Configuration.holdBrowserOpen = false;
        Configuration.browserSize = "1920x1080";
        Configuration.headless = true;
        Configuration.browser = CHROME;

    }

}
