package com.github.allure;

import com.BaseTest;
import org.junit.jupiter.api.Test;

import static utils.Constant.URL;


public class AllureStepsTest extends BaseTest {
    private static final String expectedText = "3. Using JUnit5 extend test class: ";
    private final GithubSteps ghSteps = new GithubSteps();

    @Test
    public void shouldFindJunit5Example() {
        ghSteps.openUrl(URL);
        ghSteps.findRepository("selenide");
        ghSteps.openSelenideRepo();
        ghSteps.openTab("wiki");
        ghSteps.openTheme();
        ghSteps.checkThatTextExist(expectedText);
    }
}
