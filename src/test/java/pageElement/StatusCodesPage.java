package pageElement;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class StatusCodesPage {
    public static ElementsCollection statusCodeButton = $$x("//li/a[@href]").as("Кнопки статус кода");

    public static SelenideElement textPage = $x("//div[@id='content']//p[text()]").as("Текст со страницы");

    public static SelenideElement hereButton = $x("//div[@id='content']//a[text()='here']").as("Кнопка here");
}
