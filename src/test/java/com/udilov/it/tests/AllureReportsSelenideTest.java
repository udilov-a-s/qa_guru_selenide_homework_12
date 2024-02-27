package com.udilov.it.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.udilov.it.data.data.issueNumber;
import static com.udilov.it.data.data.repositoryName;
import static org.openqa.selenium.By.linkText;

public class AllureReportsSelenideTest extends TestBase {

    @Test
    @Owner("Udilov_a_s")
    @Feature("Issue в репозитории")
    @Story("Проверка Issue")
    @Severity(SeverityLevel.NORMAL)
    @Link(value = "Github", url = "https://github.com")
    @DisplayName("Проверка названия Issue c номером " + issueNumber)
    public void allureReportsSelenide() {

        SelenideLogger.addListener("allure", new AllureSelenide());

        open("");
        $(".header-search-button").click();
        $("#query-builder-test").setValue(repositoryName).pressEnter();
        $(linkText(repositoryName)).click();
        $("#issues-tab").click();
        $(withText("#" + issueNumber)).should(Condition.exist);
    }
}
