package pageElement;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.ui.Select;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class AddRemoveElementsPage {
    public static SelenideElement addElementButton = $x("//button[.='Add Element']").as("Кнопка добавить элемент");
    public static ElementsCollection deleteButton = $$x("//button[.='Delete']").as("Кнопка удалить");
}
