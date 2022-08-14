package com.github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideRepTest {

    @Test
    public void shouldFindJunit5Example() {
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";

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
