package pageElement;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class CheckboxesPage {

    public static SelenideElement checkbox1 = $x("//text()[.=' checkbox 1']/preceding-sibling::input").as("Чекбокс 1");

    public static SelenideElement checkbox2 = $x("//text()[contains(.,'checkbox 2')]/preceding-sibling::input[1]").as("Чекбокс 2");
}
