package pageElement;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class DropdownPage {

    public static SelenideElement dropdownList = $x("//select[@id='dropdown']");

    public static SelenideElement valOption1 = $x("//select[@id='dropdown']/option[.='Option 1']");

    public static SelenideElement valOption2 = $x("//select[@id='dropdown']/option[.='Option 2']");
}
