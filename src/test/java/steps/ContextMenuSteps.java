package steps;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Selenide.actions;
import static pageElement.ContextMenuPage.fieldForTheClick;

public class ContextMenuSteps {
    public static void clickFieldAndCheckTextMessage() {
        actions().contextClick(fieldForTheClick).build().perform();
        Assertions.assertEquals(Selenide.switchTo().alert().getText(),"You selected a context menu");
        Selenide.switchTo().alert().accept();
    }
}
