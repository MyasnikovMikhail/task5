package steps;

import io.qameta.allure.Step;
import pageElement.CheckboxesPage;

public class CheckboxesSteps {

    @Step("Клик и проверка состояние чекбоксов")
    public static void checkAndClickCheckbox(int numClickCheckboxes) {
        for (int i = 0; i <= numClickCheckboxes; i++) {
            int numCheckbox = (int) (Math.random() * (1 + 1)) + 1;
            new CheckboxesPage().check()
                    .checkCheckboxIsVisible()
                    .page()
                    .getStatusCheckbox(numCheckbox)
                    .check()
                    .checkStatusCheckbox(numCheckbox)
                    .page()
                    .clickCheckboxButton(numCheckbox)
                    .getStatusCheckbox(numCheckbox)
                    .outInfoStatusCheckbox(numCheckbox)
                    .check()
                    .checkStatusCheckbox(numCheckbox);

        }
    }
}