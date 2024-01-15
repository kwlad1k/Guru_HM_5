package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
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
        $("#wiki-pages-box").$(byText("SoftAssertions")).click();
        $("#wiki-wrapper").shouldHave(text("Using JUnit5 extend test class:"));
        $("#wiki-wrapper").shouldHave(text("@ExtendWith({SoftAssertsExtension.class})\n" +
                "class Tests {\n" +
                "  @Test\n" +
                "  void test() {\n" +
                "    Configuration.assertionMode = SOFT;\n" +
                "    open(\"page.html\");\n" +
                "\n" +
                "    $(\"#first\").should(visible).click();\n" +
                "    $(\"#second\").should(visible).click();\n" +
                "  }\n" +
                "}"));
    }

}
