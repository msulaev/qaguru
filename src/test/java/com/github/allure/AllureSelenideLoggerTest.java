package com.github.allure;

import com.BaseTest;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AllureSelenideLoggerTest extends BaseTest {

    @BeforeEach
    public void set() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }


    @Test
    public void shouldFindJunit5Example() {
        open("https://github.com");
        $("[data-test-selector=nav-search-input]").setValue("selenide").pressEnter();
        $("a[href*='/selenide/selenide']").click();
        $("#repository-container-header").shouldHave(text("selenide / selenide"));
        $("#wiki-tab").click();
        $(".wiki-rightbar").scrollIntoView(false);
        $(".wiki-more-pages-link button").click();
        $("a[href*='/selenide/selenide/wiki/SoftAssertions']").click();
        $(".markdown-body").shouldHave(text("3. Using JUnit5 extend test class: "));
    }
}
