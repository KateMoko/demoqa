package com.katemoko.tests;

import com.katemoko.utils.RandomUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

@Tag("smoke")
public class RegistrationFormTest extends TestBase {

    @Test
    @DisplayName("Successful registration")
    void successfulRegistrationTest() {
        RandomUtils randomUtils = new RandomUtils();
        String[] birthDate = randomUtils.getBirthDateAsStringArray();
        String firstName = randomUtils.getFirstName(),
                lastName = randomUtils.getLastName(),
                email = randomUtils.getEmail(),
                gender = randomUtils.getGender(),
                mobileNumber = randomUtils.getMobileNumber(),
                birthDay = birthDate[0],
                birthMonth = birthDate[1],
                birthYear = birthDate[2],
                subject = randomUtils.getSubject(),
                hobby = randomUtils.getHobby(),
                pictureFileName = "misterPesel.jpg",
                currentAddress = randomUtils.gerAddress(),
                state = randomUtils.getState(),
                city = randomUtils.getCityByState(state);

        step("Open registration form", () -> {
            registrationPage.openPage()
                    .removeFooter();
        });

        step("Fill out registration form", () -> {
            registrationPage.setFirstName(firstName)
                    .setLastName(lastName)
                    .setEmail(email)
                    .setGender(gender)
                    .setMobileNumber(mobileNumber)
                    .setBirthDate(birthDay, birthMonth, birthYear)
                    .setSubject(subject)
                    .setHobby(hobby)
                    .uploadPicture(pictureFileName)
                    .setCurrentAddress(currentAddress)
                    .setState(state)
                    .setCity(city)
                    .clickSubmit();
        });

        step("Verify registration results", () -> {
            registrationPage.verifyRegistrationResultsModalAppears()
                    .verifyResult("Student Name", firstName + " " + lastName)
                    .verifyResult("Student Email", email)
                    .verifyResult("Gender", gender)
                    .verifyResult("Mobile", mobileNumber)
                    .verifyResult("Date of Birth", birthDay + " " + birthMonth + "," + birthYear)
                    .verifyResult("Subjects", subject)
                    .verifyResult("Hobbies", hobby)
                    .verifyResult("Picture", pictureFileName)
                    .verifyResult("Address", currentAddress)
                    .verifyResult("State and City", state + " " + city);
        });
    }
}