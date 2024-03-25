import hooks.WebHooks;
import org.junit.jupiter.api.Test;

import static pageElement.CheckboxesPage.checkbox1;
import static pageElement.CheckboxesPage.checkbox2;
import static pageElement.DropdownPage.*;
import static pageElement.MainPage.selectExample;

public class RunTest extends WebHooks {
    @Test
    public void transitionalToTheCheckboxes(){
        selectExample("Checkboxes").click();
        System.out.println("Состояние checkbox1: " + checkbox1.getAttribute("checked"));
        System.out.println("Состояние checkbox2: " + checkbox2.getAttribute("checked"));
        checkbox1.click();
        checkbox2.click();
        System.out.println("Состояние checkbox1: " + checkbox1.getAttribute("checked"));
        System.out.println("Состояние checkbox2: " + checkbox2.getAttribute("checked"));
    }

    @Test
    public void transitionalToTheDropdown(){
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
}
