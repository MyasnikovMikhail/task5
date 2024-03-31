package steps;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import static pageElement.CheckboxesPage.checkbox;

public class CheckboxesSteps {
    @Step("Клик и проверка состояние чекбоксов")
    public static void checkAndClickCheckbox(int numClickCheckboxes) {
        for (int i = 0; i <= numClickCheckboxes; i++) {
            int numCheckbox = (int) (Math.random() * (1 + 1)) + 1;
            String statusCheckbox = checkbox(numCheckbox).as("Состояние чекбокса " + numCheckbox).getAttribute("checked");
            checkbox(numCheckbox).as("Нажатие на checkbox " + numCheckbox).click();
            Assertions.assertNotEquals(checkbox(numCheckbox).as("Состояние checkbox " + numCheckbox +
                    " не равен состоянию " + statusCheckbox).getAttribute("checked"), statusCheckbox);
        }
    }
}
