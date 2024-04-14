package pageElement;

import com.codeborne.selenide.SelenideElement;
import pageElement.Asserts.DropdownPageAssert;

import static com.codeborne.selenide.Selenide.$x;

public class DropdownPage {

    public static SelenideElement dropdownList = $x("//select[@id='dropdown']").as("Выпадающий список");

    public static SelenideElement valOption(int index) {
        return $x("//select[@id='dropdown']/option[.='Option " + index + "']").as("Выбран вариант Option " + index);
    }

    public DropdownPageAssert check() {
        return DropdownPageAssert.assertThat(this);
    }


    public DropdownPage outInfoSelectOption(int index) {
        System.out.println("Выбор Option " + (index == 1 ? "1" : "2"));
        return this;
    }

    public DropdownPage selectOption(int index) {
        dropdownList.click();
        valOption(index).click();

        return this;
    }
}
