package pageElement;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class CommonPage {
    public static SelenideElement pageTitle = $x("//h3[text()]").as("Заголовок страницы");
}
