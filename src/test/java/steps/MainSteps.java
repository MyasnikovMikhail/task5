package steps;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import static pageElement.CommonPage.pageTitle;
import static pageElement.MainPage.selectExample;

public class MainSteps {

    @Step("Клик на нужный пример и проверка заголовка открытой страницы")
    public static void clickAndCheckExample(String example, String heading){
        selectExample(example).click();
        Assertions.assertEquals(heading, pageTitle.text());
    }
}
