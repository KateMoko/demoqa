package com.demoqa;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormTest extends TestBase {

    @Test
    void fillAllFormFieldsTest() {
        open("/automation-practice-form");

        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        $("#firstName").setValue("Jennifer");
        $("#lastName").setValue("Smith");
        $("#userEmail").setValue("jensmith@ololo.com");
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue("9875673423");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("October");
        $(".react-datepicker__year-select").selectOption("2000");
        $(".react-datepicker__month").$(byText("16")).click();
        $("#subjectsInput").setValue("Commerce").pressEnter();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("misterPesel.jpg");
        $("#currentAddress").setValue("49 London Road London N81 4QR");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Haryana")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Panipat")).click();

        $("#submit").click();

        $(".modal-content").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table").shouldHave(
                text("Jennifer Smith"),
                text("jensmith@ololo.com"),
                text("Female"),
                text("9875673423"),
                text("16 October"),
                text("2000"),
                text("Commerce"),
                text("Music"),
                text("misterPesel.jpg"),
                text("49 London Road London N81 4QR"),
                text("Haryana"),
                text("Panipat")
        );
    }
}
