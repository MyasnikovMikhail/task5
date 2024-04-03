package pageElement;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class DragAndDropPage {
    public static SelenideElement columnA = $x("//div[@id='column-a']").as("Квадрат А");
    public static SelenideElement columnB = $x("//div[@id='column-b']").as("Квадрат В");
}
