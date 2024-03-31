package pageElement;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class CheckboxesPage {

    public static SelenideElement checkbox(int index) {
        return $x("//form[@id='checkboxes']/input[" + index + "]").as("Выбор чекбокса " + index);
    }
}
