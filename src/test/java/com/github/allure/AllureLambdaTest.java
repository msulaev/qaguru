package com.github.allure;

import com.BaseTest;
import io.qameta.allure.Allure;
import io.qameta.allure.model.Label;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static utils.Constant.URL;

public class AllureLambdaTest extends BaseTest {

    @Test
    public void shouldFindJunit5Example() {
        Allure.getLifecycle().updateTestCase(t -> t.setLabels(List.of(new Label().setName("feature").setValue("etst"))));

        step("Open url: " + URL, () -> open(URL));
        step("Open selenide repository", () -> {
            $("[data-test-selector=nav-search-input]").setValue("selenide").pressEnter();
            $("a[href*='/selenide/selenide']").click();
            $("#repository-container-header").shouldHave(text("selenide / selenide"));
        });
        step("Open wiki tab", () -> $("#wiki-tab").click());
        step("Open title about SoftAssertions", () -> {
            $(".wiki-rightbar").scrollIntoView(false);
            $(".wiki-more-pages-link button").click();
            $("a[href*='/selenide/selenide/wiki/SoftAssertions']").click();
        });
        step("Check that JUnit 5 examples are existed", () -> {
            $(".markdown-body").shouldHave(text("3. Using JUnit5 extend test class: "));
        });
    }
}
