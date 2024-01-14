package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.itemWithText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class CodeInsideThePageTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void checkJUnitcode() {
        open("https://github.com/");
        $("[placeholder='Search or jump to...']").click();
        $("#query-builder-test").setValue("Selenide").pressEnter();
        $("[data-testid='results-list'] a").click();
        $("#wiki-tab").click();
        $(".js-wiki-more-pages-link").click();
        $("#wiki-pages-box").shouldHave(text("SoftAssertions")).click();
        $("#wiki-wrapper").shouldHave(text("Using JUnit5 extend test class:"));
//      $$(".markdown-body h4").shouldHave(itemWithText("3. Using JUnit5 extend test class:"));
    }

    @Test
    void secondTest() {
        open("https://github.com"); // Открытие гита
        $(".header-search-button > .flex-1").click(); // Открытие поискового окна
        $("#query-builder-test").setValue("Selenide").pressEnter(); // Поиск селенида
        $x("//em[contains(.,'selenide')]").click();// Выбор селенида
        $("#wiki-tab").click();// Выбор вики
        $(".js-wiki-more-pages-link").click();
        $("#wiki-pages-box").shouldHave(text("SoftAssertions")).click();//Нажатие SoftAssertions
//        $("#user-content-without-soft-assertions-you-will-get-report").scrollIntoView(false); // Скролл до кода JUnit5
//        $("#wiki-body").shouldHave(text("Using JUnit5 extend test class")); // Проверка наличия кода JUnit5
    }

}
