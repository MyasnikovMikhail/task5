package pageElement;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ContextMenuPage {
    public static SelenideElement fieldForTheClick = $x("//div[@id='hot-spot']").as("Поле для вызова контекстного меню");
}
