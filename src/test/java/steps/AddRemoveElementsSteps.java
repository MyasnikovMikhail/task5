package steps;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import static pageElement.AddRemoveElementsPage.addElementButton;
import static pageElement.AddRemoveElementsPage.deleteButton;

public class AddRemoveElementsSteps {
    @Step("Добавление кнопки")
    public static void addButtons(int addBtn) {
        int countButton = deleteButton.size();
        for (int i = 1; i <= addBtn; i++) {
            addElementButton.click();
            Assertions.assertEquals(deleteButton.size(), countButton + i);
        }
    }

    @Step("Удаление кнопки")
    public static void deleteButtons(int deleteBtn) {
        int countButton = deleteButton.size();
        for (int i = 1; i < deleteBtn; i++) {
            deleteButton.get(i).click();
            Assertions.assertEquals(deleteButton.size(), countButton - i);
        }
    }

    @Step("Удаление всех кнопок")
    public static void clearButtons() {
        for (int i = deleteButton.size()- 1; i >=0 ; i--) {
            deleteButton.get(i).click();
        }
        Assertions.assertEquals(deleteButton.size(), 0);
    }

    @Step("Действия с кнопками")
    public static void addAndDeleteButtons(int addBtn, int deleteBtn){
        addButtons(addBtn);
        deleteButtons(deleteBtn);
        clearButtons();
    }
}
