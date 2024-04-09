import hooks.WebHooks;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static steps.ContextMenuSteps.clickFieldAndCheckTextMessage;
import static steps.DragAndDropSteps.dragAndDropWithAction;
import static steps.InfiniteScrollSteps.searchWordAndScroll;
import static steps.KeyPressesSteps.pressBtnAndCheckText;
import static steps.KeyPressesSteps.pressBtnLettersAndCheckText;
import static steps.MainSteps.clickAndCheckExample;

public class RunTest extends WebHooks {
    @DisplayName("Перетаскивание элементов в Drag and Drop")
    @Test
    public void transitionalToTheDragAndDrop() {
        clickAndCheckExample("Drag and Drop", "Drag and Drop");
        dragAndDropWithAction();
    }

    @DisplayName("Перетаскивание элементов в Context Menu")
    @Test
    public void transitionalToTheContextMenu() {
        clickAndCheckExample("Context Menu", "Context Menu");
        clickFieldAndCheckTextMessage();
    }

    @DisplayName("Проверка страниц Infinite Scroll")
    @Test
    public void transitionalToTheInfiniteScroll() {
        clickAndCheckExample("Infinite Scroll", "Infinite Scroll");
        searchWordAndScroll("Eius");
    }

    @DisplayName("Проверка страниц Key Presses")
    @Test
    public void transitionalToTheKeyPresses() {
        clickAndCheckExample("Key Presses", "Key Presses");
        pressBtnLettersAndCheckText();
        pressBtnAndCheckText(Keys.ENTER, "ENTER");
        pressBtnAndCheckText(Keys.CONTROL, "CONTROL");
        pressBtnAndCheckText(Keys.ALT, "ALT");
        pressBtnAndCheckText(Keys.TAB, "TAB");

    }
}
