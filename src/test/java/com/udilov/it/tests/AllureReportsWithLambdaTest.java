package com.udilov.it.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import io.qameta.allure.Link;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.udilov.it.data.Data.ISSUE_NUMBER;
import static com.udilov.it.data.Data.repositoryName;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;


public class AllureReportsWithLambdaTest extends TestBase {

    @Test
    @Owner("Udilov_a_s")
    @Feature("Issue в репозитории")
    @Story("Проверка Issue")
    @Severity(SeverityLevel.NORMAL)
    @Link(value = "Github", url = "https://github.com")
    @DisplayName("Проверка названия Issue c номером " + ISSUE_NUMBER)
    public void allureReportsWithLambda() {

        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу", () -> {
            open("");
        });
        step("Ищем репозиторий " + repositoryName, () -> {
            $(".header-search-button").click();
            $("#query-builder-test").setValue(repositoryName).pressEnter();
        });
        step("Кликаем по ссылке репозитория " + repositoryName, () -> {
            $(linkText(repositoryName)).click();
        });
        step("Открываем таб issues", () -> {
            $("#issues-tab").click();
        });
        step("Проверяем наличие issue с номером " + ISSUE_NUMBER, () -> {
            $(withText("#" + ISSUE_NUMBER)).should(Condition.exist);
        });
    }
}