package pageElement;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class InputsPage {

    public static SelenideElement input = $x("//input[@type='number']").as("Поле ввода");

}
