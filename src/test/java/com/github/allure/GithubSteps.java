package com.github.allure;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class GithubSteps {

    @Step("Open URL:{0}")
    public void openUrl(String url) {
        Selenide.open(url);
    }

    @Step("Find repository: {0}")
    public void findRepository(String rep) {
        $("[data-test-selector=nav-search-input]").setValue(rep).pressEnter();
    }

    @Step("Open Selenide Repo")
    public void openSelenideRepo() {
        $("a[href*='/selenide/selenide']").click();
        $("#repository-container-header").shouldHave(text("selenide / selenide"));
    }

    @Step("Open tab: {0}")
    public void openTab(String tab) {
        $("#" + tab + "-tab").click();
    }

    @Step("Open selenide Wiki about SoftAssertion")
    public void openTheme() {
        $(".wiki-rightbar").scrollIntoView(false);
        $(".wiki-more-pages-link button").click();
        $("a[href*='/selenide/selenide/wiki/SoftAssertions']").click();
    }

    @Step("Check that JUnit 5 examples are existed")
    public void checkThatTextExist(String expected) {
        $(".markdown-body").shouldHave(text(expected));
    }
}
