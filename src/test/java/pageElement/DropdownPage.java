package pageElement;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class DropdownPage {

    public static SelenideElement dropdownList = $x("//select[@id='dropdown']").as("Выпадающий список");

    public static SelenideElement valOption(int index){
        return $x("//select[@id='dropdown']/option[.='Option " + index + "']").as("Выбран вариант Option " + index);
    }
}
