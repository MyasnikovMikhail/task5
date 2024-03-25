package pageElement;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class DisappearingElementsPage {
    public static ElementsCollection elementsWithButtons = $$x("//li/a[@href]").as("Кнопки на экране");
    public static SelenideElement buttonHome = $x("//li/a[.='Home']").as("Кнопка Home");

}
