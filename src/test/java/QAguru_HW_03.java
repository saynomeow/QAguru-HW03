import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.CollectionCondition.itemWithText;
import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.files.DownloadActions.click;

///Открыть страницу Selenide в Github
///Перейти в раздел Wiki проекта
///Убедься, что в списке страниц (Pages) есть страница SoftAssertions
///Открыть страницу SoftAssertions, проверить что внутри есть пример кода для JUnit5

public class QAguru_HW_03 {
   //arrange
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        baseUrl = "https://github.com/";
    }
   //act
    @Test
    void testHomeWork03() {
        open (baseUrl);
        $("[data-test-selector=nav-search-input]").setValue("Selenide").pressEnter();
        $$("ul.repo-list li").first().$(".v-align-middle").click();
        $("#wiki-tab").click();
        $("#wiki-pages-filter").setValue("SoftAssertions");
   //assert
        $("[data-filterable-for=wiki-pages-filter]").shouldHave(text("SoftAssertions")).click();
        $("[id=wiki-body]").shouldHave(text("Using JUnit5 extend test class:"));
    }
}
