package elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CalendarElement {

    private final SelenideElement calendarMonth = $(".react-datepicker__month-select"),
            calendarYear = $(".react-datepicker__year-select"),
            container = $(".react-datepicker__month");

    public void setDate(String day, String year, String month) {
        calendarMonth.selectOption(month);
        calendarYear.selectOption(year);
        container.$(byText(day)).click();
    }
}
