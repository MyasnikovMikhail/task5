package steps;


import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Selenide.actions;
import static pageElement.DragAndDropPage.columnA;
import static pageElement.DragAndDropPage.columnB;

public class DragAndDropSteps {
    public static void dragAndDropWithAction() {
        Assertions.assertEquals(columnA.getText(), "A");
        Assertions.assertEquals(columnB.getText(), "B");
        actions().clickAndHold(columnA).moveToElement(columnB).release().build().perform();
        Assertions.assertEquals(columnA.getText(), "B");
        Assertions.assertEquals(columnB.getText(), "A");
    }
}
