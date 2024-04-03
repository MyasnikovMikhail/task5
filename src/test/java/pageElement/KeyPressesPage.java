package pageElement;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class KeyPressesPage {
    public static SelenideElement text = $x("//p[@id='result']").as("Вывод текст с нажатой кнопкой");
}
