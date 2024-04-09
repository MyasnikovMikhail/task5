package pageElement;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import pageElement.Asserts.DisappearingElementsPageAssert;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class DisappearingElementsPage {

    public static ElementsCollection elementsWithButtons = $$x("//li/a[@href]").as("Кнопки на экране");

    public static SelenideElement buttonHome = $x("//li/a[.='Home']").as("Кнопка Home");

    public DisappearingElementsPageAssert check() {
        return DisappearingElementsPageAssert.assertThat(this);
    }

    public DisappearingElementsPage buttonHomeClick() {
        buttonHome.click();
        return this;
    }

    public DisappearingElementsPage outInfoNumCycle(int index) {
        System.out.println("Цикл №" + index + ", количество элементов " + elementsWithButtons.size());
        return this;
    }
}
