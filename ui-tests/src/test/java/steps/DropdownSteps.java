package steps;

import io.qameta.allure.Step;
import pageElement.DropdownPage;

public class DropdownSteps {

    @Step("Клик и проверка текста элемента dropdown")
    public static void clickAndCheckDropdownList(int... indexes) {
        for (int index : indexes) {
            new DropdownPage().check()
                    .checkIsVisible()
                    .page()
                    .outInfoSelectOption(index)
                    .selectOption(index)
                    .check()
                    .checkSelectOption(index)
                    .infoSelectOption(index);


        }
    }

}