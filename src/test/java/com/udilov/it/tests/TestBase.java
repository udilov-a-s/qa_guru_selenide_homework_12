package com.udilov.it.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    @BeforeAll
    static void beforeAll() {

        Configuration.baseUrl = "https://github.com/";
        Configuration.browserSize = "1200x900";
        Configuration.pageLoadStrategy = "eager";
    }

    @AfterEach
    void afterEach() {

        Selenide.closeWebDriver();
    }
}