package com.github;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PricingTest {

    @Test
    public void shouldOpenPricingPlan(){
        Configuration.timeout =
        open("https://github.com");
        $(byText("Pricing")).hover();
        $(byText("Compare plans")).click();
        $(".font-mktg").shouldHave(text("Choose the plan that’s right for you."));
    }
}
