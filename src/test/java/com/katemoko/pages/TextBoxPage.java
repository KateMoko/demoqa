package com.katemoko.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxPage {
    // SelenideElements / locator / etc
    SelenideElement fullNameInput = $("#userName"),
            emailInput = $("#userEmail"),
            currentAddressInput = $("#currentAddress"),
            permanentAddressInput = $("#permanentAddress"),
            submitButton = $("#submit"),
            outputName = $("#name"),
            outputEmail = $("#email"),
            outputCurrentAddress = $("#currentAddress.mb-1"),
            outputPermanentAddress = $("#permanentAddress.mb-1");

    // Actions
    public TextBoxPage openPage() {
        open("/text-box");

        return this;
    }

    public TextBoxPage setFullName(String value) {
        fullNameInput.setValue(value);

        return this;
    }

    public TextBoxPage setEmail(String value) {
        emailInput.setValue(value);

        return this;
    }

    public TextBoxPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);

        return this;
    }

    public TextBoxPage setPermanentAddress(String value) {
        permanentAddressInput.setValue(value);

        return this;
    }

    public void clickSubmit() {
        submitButton.click();
    }

    public TextBoxPage verifyOutputName(String value) {
        outputName.shouldHave(text(value));

        return this;
    }

    public TextBoxPage verifyOutputEmail(String value) {
        outputEmail.shouldHave(text(value));

        return this;
    }

    public TextBoxPage verifyOutputCurrentAddress(String value) {
        outputCurrentAddress.shouldHave(text(value));

        return this;
    }

    public TextBoxPage verifyOutputPermanentAddress(String value) {
        outputPermanentAddress.shouldHave(text(value));

        return this;
    }
}