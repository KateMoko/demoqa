package com.katemoko.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    // SelenideElements / locator / etc
    SelenideElement monthSelect = $(".react-datepicker__month-select"),
            yearSelect = $(".react-datepicker__year-select");
    String dayPickerLocator = ".react-datepicker__day--0%s:not(.react-datepicker__day--outside-month)";

    // Actions
    public void setDate(String day, String month, String year) {
        monthSelect.selectOption(month);
        yearSelect.selectOption(year);
        dayPickerLocator = String.format(dayPickerLocator, day);
        $(dayPickerLocator).click();
    }
}