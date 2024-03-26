import com.codeborne.selenide.SelenideElement;
import hooks.WebHooks;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.lang.Thread.sleep;
import static pageElement.AddRemoveElementsPage.addElementButton;
import static pageElement.AddRemoveElementsPage.deleteButton;
import static pageElement.CheckboxesPage.checkbox1;
import static pageElement.CheckboxesPage.checkbox2;
import static pageElement.CommonPage.pageTitle;
import static pageElement.DisappearingElementsPage.buttonHome;
import static pageElement.DisappearingElementsPage.elementsWithButtons;
import static pageElement.DropdownPage.*;
import static pageElement.HoversPage.*;
import static pageElement.InputsPage.input;
import static pageElement.MainPage.selectExample;
import static pageElement.NotificationMessagePage.*;
import static pageElement.StatusCodesPage.*;

public class RunTest extends WebHooks {
    @DisplayName("Страница Checkboxes")
    @Test
    public void transitionalToTheCheckboxes() {
        selectExample("Checkboxes").click();
        Assertions.assertEquals("Checkboxes", pageTitle.text());
        System.out.println("Начальное состояние чекбоксов");
        System.out.println("Состояние checkbox1: " + checkbox1.getAttribute("checked"));
        System.out.println("Состояние checkbox2: " + checkbox2.getAttribute("checked") + "\n");
        checkbox1.click();
        checkbox2.click();
        System.out.println("Состояние чекбоксов после кликов");
        System.out.println("Состояние checkbox1: " + checkbox1.getAttribute("checked"));
        System.out.println("Состояние checkbox2: " + checkbox2.getAttribute("checked"));
    }

    @DisplayName("Страница Dropdown List")
    @Test
    public void transitionalToTheDropdown() {
        selectExample("Dropdown").click();
        Assertions.assertEquals("Dropdown List", pageTitle.text());
        System.out.println("Выбор Option 1");
        dropdownList.click();
        valOption1.click();
        System.out.println("Текущий текст элемента dropdown: " + dropdownList.getText());
        System.out.println("\nВыбор Option 2");
        dropdownList.click();
        valOption2.click();
        System.out.println("Текущий текст элемента dropdown: " + dropdownList.getText());
    }

    @DisplayName("Страница Disappearing Elements")
    @Test
    public void transitionalToTheDisappearingElements() {
        for (int i = 1; i < 12; i++) {
            selectExample("Disappearing Elements").click();
            Assertions.assertEquals("Disappearing Elements", pageTitle.text());
            if (i == 10) {
                Assertions.assertFalse(i == 10);
            }

            if (elementsWithButtons.size() >= 5)
                break;

            buttonHome.click();
            System.out.println("Цикл №" + i);
        }
    }

    @DisplayName("Страница Inputs")
    @Test
    public void transitionalToTheInputs() throws InterruptedException {
        selectExample("Inputs").click();
        Assertions.assertEquals("Inputs", pageTitle.text());
        input.click();
        input.sendKeys((int) (Math.random() * 10000) + "");
        sleep(5000);
        System.out.println(input.getValue());
    }

    @DisplayName("Страница Hovers")
    @Test
    public void transitionalToTheHovers() {
        selectExample("Hovers").click();
        Assertions.assertEquals("Hovers", pageTitle.text());
        for (int i = 1; i < 4; i++) {
            avatars(i).hover();
            for (SelenideElement elem : infoNameAvatars) {
                if (elem.isDisplayed()) {
                    System.out.println(elem.text());
                    break;
                }
            }

            for (SelenideElement elem : infoLinkAvatars) {
                if (elem.isDisplayed()) {
                    System.out.println(elem.text());
                    break;
                }
            }
            System.out.println();
        }
    }

    @DisplayName("Страница Notification Message")
    @Test
    public void transitionalToTheNotificationMessage() {
        selectExample("Notification Messages").click();
        Assertions.assertEquals("Notification Message", pageTitle.text());
        for (; ; ) {
            System.out.println(notificationMessage.getText());
            if (notificationMessage.getText().contains("Action successful"))
                break;
            closeMessageButton.click();
            clickHereButton.click();
        }
    }

    @DisplayName("Страница Add/Remove Elements")
    @Test
    public void transitionalToTheAddRemoveElements() {
        selectExample("Add/Remove Elements").click();
        Assertions.assertEquals("Add/Remove Elements", pageTitle.text());
        for (int i = 1; i < 6; i++) {
            addElementButton.click();
            System.out.println("Текст кнопки №" + i + ": " + deleteButton.last().getText());
        }
        System.out.println();
        for (int i = 1; i < 4; i++) {
            deleteButton.get((int) (Math.random() * deleteButton.size())).click();
            System.out.println(deleteButton.size());
            System.out.println(deleteButton.texts());
            System.out.println();
        }
    }

    @DisplayName("Страница Status Codes")
    @Test
    public void transitionalToTheAddStatusCodes() {
        selectExample("Status Codes").click();
        Assertions.assertEquals("Status Codes", pageTitle.text());
        for (int i = 0; i < 4; i++) {
            statusCodeButton.get(i).click();
            System.out.println("Страница №" + (i + 1) + "\n" + textPage.getText().replaceFirst("\n", "") + "\n");
            hereButton.click();
        }
    }
}
