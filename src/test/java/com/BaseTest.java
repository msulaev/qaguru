package com;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Browsers.FIREFOX;

public class BaseTest {
    @BeforeAll
    public static void setUp() {
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
        Configuration.headless = false;
        Configuration.browser = FIREFOX;
    }

}
