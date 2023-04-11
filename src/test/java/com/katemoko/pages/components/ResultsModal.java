package com.katemoko.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultsModal {
    // SelenideElements / locator / etc
    SelenideElement resultsModal = $(".modal-dialog"),
            resultsHeader = $("#example-modal-sizes-title-lg"),
            resultsTable = $(".table-responsive");

    // Actions
    public void verifyModalAppears() {
        resultsModal.should(appear);
        resultsHeader.shouldHave(text("Thanks for submitting the form"));
    }

    public void verifyResult(String key, String value) {
        resultsTable.$(byText(key)).sibling(0).shouldHave(text(value));
    }
}