package com.junit;

import com.BaseTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.match;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebTest extends BaseTest {

    @ValueSource(strings = {"selenide", "allure2"})
    @ParameterizedTest(name = "Should find wiki page into rep {0}")
    void shouldFindWikiPage(String testData) {
        open("https://github.com");
        $("[data-test-selector=nav-search-input]").setValue(testData).pressEnter();
        $("a[href$='" + testData + "']").click();
        $("#repository-container-header").shouldHave(text(testData));
        $("#wiki-tab").click();
    }
}
