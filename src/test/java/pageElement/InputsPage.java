package pageElement;

import com.codeborne.selenide.SelenideElement;
import pageElement.Asserts.InputsPageAssert;

import static com.codeborne.selenide.Selenide.$x;

public class InputsPage {

    public static SelenideElement input = $x("//input[@type='number']").as("Поле ввода");

    public InputsPageAssert check() {
        return InputsPageAssert.assertThat(this);
    }

    public InputsPage clickAndSandKeys(String inputStr) {
        input.click();
        input.sendKeys(inputStr);
        return this;
    }

    public InputsPage outInputInfo(String inputStr) {
        System.out.println("Было введено: " + inputStr);
        System.out.println("Вывод" + input.getValue());

        return this;
    }

}
