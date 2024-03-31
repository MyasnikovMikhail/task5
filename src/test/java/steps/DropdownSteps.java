package steps;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import static pageElement.DropdownPage.dropdownList;
import static pageElement.DropdownPage.valOption;

public class DropdownSteps {

    @Step("Клик и проверка текста элемента dropdown")
    public static void clickAndCheckDropdownList(int... indexes) {
        for(int index: indexes) {
            System.out.println("Выбор Option " + (index == 1 ? "1" : "2"));
            dropdownList.click();
            valOption(index).click();
            Assertions.assertEquals(dropdownList.getText(), "Option " + (index == 1 ? "1" : "2"));
            System.out.println("Текущий текст элемента dropdown: " + dropdownList.getText());
        }
    }

}
