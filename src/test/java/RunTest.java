import com.codeborne.selenide.SelenideElement;
import hooks.WebHooks;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static java.lang.Thread.sleep;
import static pageElement.CheckboxesPage.checkbox1;
import static pageElement.CheckboxesPage.checkbox2;
import static pageElement.DisappearingElementsPage.buttonHome;
import static pageElement.DisappearingElementsPage.elementsWithButtons;
import static pageElement.DropdownPage.*;
import static pageElement.HoversPage.*;
import static pageElement.InputsPage.input;
import static pageElement.MainPage.selectExample;
import static pageElement.MainPage.text;
import static pageElement.NotificationMessagePage.*;

public class RunTest extends WebHooks {
    @Test
    public void transitionalToTheCheckboxes() {
        selectExample("Checkboxes").click();
        System.out.println("Состояние checkbox1: " + checkbox1.getAttribute("checked"));
        System.out.println("Состояние checkbox2: " + checkbox2.getAttribute("checked"));
        checkbox1.click();
        checkbox2.click();
        System.out.println("Состояние checkbox1: " + checkbox1.getAttribute("checked"));
        System.out.println("Состояние checkbox2: " + checkbox2.getAttribute("checked"));
    }

    @Test
    public void transitionalToTheDropdown() {
        selectExample("Dropdown").click();
        dropdownList.click();
        valOption1.click();
        System.out.println("Option 1 выбран?: " + valOption1.getAttribute("selected"));
        System.out.println("Option 2 выбран?: " + valOption2.getAttribute("selected"));
        dropdownList.click();
        valOption2.click();
        System.out.println("Option 1 выбран?: " + valOption1.getAttribute("selected"));
        System.out.println("Option 2 выбран?: " + valOption2.getAttribute("selected"));
    }

    @Test
    public void transitionalToTheDisappearingElements() {
        for (int i = 1; i < 12; i++) {
            selectExample("Disappearing Elements").click();
            if (i == 10) {
                Assertions.assertFalse(i == 10);
            }

            if (elementsWithButtons.size() >= 5)
                break;

            buttonHome.click();
            System.out.println("Цикл №" + i);
        }
    }

    @Test
    public void transitionalToTheInputs() throws InterruptedException {
        selectExample("Inputs").click();
        input.click();
        input.sendKeys((int) (Math.random() * 10000) + "");
        sleep(5000);
        System.out.println(input.getValue());
    }

    @Test
    public void transitionalToTheHovers(){
        selectExample("Hovers").click();
        for (int i = 1; i < 4; i++) {
            avatars(i).hover();
            for(SelenideElement elem : infoNameAvatars){
                if(elem.isDisplayed()){
                    System.out.println(elem.text());
                    break;
                }
            }

            for(SelenideElement elem : infoLinkAvatars){
                if(elem.isDisplayed()) {
                    System.out.println(elem.text());
                    break;
                }
            }
            System.out.println();
        }
    }

    @Test
    public void transitionalToTheNotificationMessage(){
//        text.scrollTo();
        selectExample("Notification Messages").scrollTo().click();
        for(;;){
            System.out.println(notificationMessage.getText());
            if(notificationMessage.getText().contains("Action successful"))
                break;
            closeMessageButton.click();
            clickHereButton.click();
        }
    }
}
