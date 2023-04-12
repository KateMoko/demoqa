package com.katemoko.tests;

import org.junit.jupiter.api.Test;

public class RegistrationFormTest extends TestBase {

    @Test
    void successfulRegistrationTest() {
        registrationPage.openPage()
                .removeFooter()
                .setFirstName("Jennifer")
                .setLastName("Smith")
                .setEmail("jensmith@ololo.com")
                .setGender("Female")
                .setMobileNumber("9875673423")
                .setBirthDate("16", "October", "2000")
                .setSubjects("Commerce")
                .setHobby("Music")
                .uploadPicture("misterPesel.jpg")
                .setCurrentAddress("49 London Road London N81 4QR")
                .setState("Haryana")
                .setCity("Panipat")
                .clickSubmit();

        registrationPage.verifyRegistrationResultsModalAppears()
                .verifyResult("Student Name", "Jennifer Smith")
                .verifyResult("Student Email", "jensmith@ololo.com")
                .verifyResult("Gender", "Female")
                .verifyResult("Mobile", "9875673423")
                .verifyResult("Date of Birth", "16 October,2000")
                .verifyResult("Subjects", "Commerce")
                .verifyResult("Hobbies", "Music")
                .verifyResult("Picture", "misterPesel.jpg")
                .verifyResult("Address", "49 London Road London N81 4QR")
                .verifyResult("State and City", "Haryana Panipat");
    }
}