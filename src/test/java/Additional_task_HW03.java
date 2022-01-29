import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

///Открыть https://the-internet.herokuapp.com/drag_and_drop
///Перенести прямоугольник А на место В
///Проверить, что прямоугольники действительно поменялись

public class Additional_task_HW03 {
   //arrange
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        baseUrl = "https://the-internet.herokuapp.com";
    }
   //act
    @Test
    void additional_task_HW03() {
        open ("/drag_and_drop");
        $("#column-a").dragAndDropTo($("#column-b"));
   //assert
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }
}
