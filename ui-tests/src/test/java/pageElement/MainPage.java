package pageElement;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import pageElement.Asserts.MainPageAssert;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage {

    public SelenideElement selectExample(String textExample) {
        return $x("//li/a[@href and . = '" + textExample + "']").as("Выбор примера: " + textExample);
    }

    public MainPageAssert check() {
        return MainPageAssert.assertThat(this);
    }

    public MainPage clickExampleButton(String textExample) {
        selectExample(textExample).shouldBe(Condition.visible).scrollTo().click();

        return this;
    }
}
