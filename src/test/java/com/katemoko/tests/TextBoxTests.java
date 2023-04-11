package com.katemoko.tests;

import org.junit.jupiter.api.Test;

public class TextBoxTests extends TestBase {
    @Test
    void successfulFillFormTest() {
        textBoxPage.openPage()
                .setFullName("Mr Smith")
                .setEmail("aa@aaa.com")
                .setCurrentAddress("Some street 1")
                .setPermanentAddress("Another street 1")
                .clickSubmit();

        textBoxPage.verifyOutputName("Mr Smith")
                .verifyOutputEmail("aa@aaa.com")
                .verifyOutputCurrentAddress("Some street 1")
                .verifyOutputPermanentAddress("Another street 1");
    }
}