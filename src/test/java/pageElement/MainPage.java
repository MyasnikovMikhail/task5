package pageElement;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    public static SelenideElement selectExample (String textExample){
        return $x("//li/a[@href and . = '" + textExample + "']").scrollTo().as("Выбор примера: " + textExample);
    }
}
