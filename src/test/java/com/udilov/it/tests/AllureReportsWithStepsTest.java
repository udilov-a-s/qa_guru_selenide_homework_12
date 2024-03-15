package com.udilov.it.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.udilov.it.data.Data.ISSUE_NUMBER;
import static com.udilov.it.data.Data.repositoryName;

public class AllureReportsWithStepsTest extends TestBase {

    @Test
    @Owner("Udilov_a_s")
    @Feature("Issue в репозитории")
    @Story("Проверка Issue")
    @Severity(SeverityLevel.NORMAL)
    @Link(value = "Github", url = "https://github.com")
    @DisplayName("Проверка названия Issue c номером " + ISSUE_NUMBER)
    public void allureReportsWithSteps() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();

        steps.openMainPage();
        steps.searchForRepository(repositoryName);
        steps.clickOnRepositoryLink(repositoryName);
        steps.openIssuesTub();
        steps.shouldSeeIssueWithNumber(ISSUE_NUMBER);
    }
}