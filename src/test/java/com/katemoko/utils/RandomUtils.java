package com.katemoko.utils;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.*;

public class RandomUtils {
    private Faker faker = new Faker();
    private static final String[] genders = {"Male", "Female", "Other"};
    private static final String[] subjects = {"Hindi", "English", "Maths", "Physics", "Chemistry", "Biology", "Computer Science", "Commerce", "Accounting", "Economics", "Arts", "Social Studies", "History", "Civics"};
    private static final String[] hobbies = {"Sports", "Reading", "Music"};
    private static final Map<String, String[]> statesAndCities = new HashMap<>();

    static {
        statesAndCities.put("NCR", new String[]{"Delhi", "Gurgaon", "Noida"});
        statesAndCities.put("Uttar Pradesh", new String[]{"Agra", "Lucknow", "Merrut"});
        statesAndCities.put("Haryana", new String[]{"Karnal", "Panipat"});
        statesAndCities.put("Rajasthan", new String[]{"Jaipur", "Jaiselmer"});
    }

    public String getFirstName() {
        return faker.name().firstName();
    }

    public String getLastName() {
        return faker.name().lastName();
    }

    public String getEmail() {
        return faker.internet().emailAddress();
    }

    public String getGender() {
        return faker.options().option(genders);
    }

    public String getMobileNumber() {
        return faker.number().digits(10);
    }

    public String[] getBirthDateAsStringArray() {
        return new SimpleDateFormat("dd/MMMM/yyyy", Locale.ENGLISH).format(faker.date().birthday(17, 100)).split("/");
    }

    public String getSubject() {
        return faker.options().option(subjects);
    }

    public String getHobby() {
        return faker.options().option(hobbies);
    }

    public String gerAddress() {
        return faker.address().streetAddress(true);
    }

    public String getState() {
        return faker.options().option(statesAndCities.keySet().toArray()).toString();
    }

    public String getCityByState(String state) {
        return faker.options().option(statesAndCities.get(state));
    }
}