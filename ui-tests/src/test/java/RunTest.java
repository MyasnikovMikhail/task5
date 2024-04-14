import hooks.WebHooks;
import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static pageElement.Asserts.DisappearingElementsPageAssert.isNotBreak;
import static steps.CheckboxesSteps.checkAndClickCheckbox;
import static steps.DisappearingElementsSteps.checkAndClickHomeButton;
import static steps.DropdownSteps.clickAndCheckDropdownList;
import static steps.HoversSteps.hoverAndCheckAvatars;
import static steps.InputsSteps.inputAndCheckText;
import static steps.MainPageSteps.selectExample;
import static utils.ConfProperties.getProperty;

public class RunTest extends WebHooks {
    @Tag("all")
    @Tag("checkboxes")
    @ParameterizedTest(name = "{displayName}: {arguments}")
    @CsvSource({"2, Checkboxes1", "10, Checkboxes"})
    @DisplayName("Страница Checkboxes")
    public void transitionalToTheCheckboxes(int numClickCheckboxes, String exampleName) {
        selectExample(exampleName);
        checkAndClickCheckbox(numClickCheckboxes);
    }

    @Tag("all")
    @Tag("dropdown")
    @DisplayName("Страница Dropdown List")
    @Test
    public void transitionalToTheDropdown() {
        selectExample("Dropdown");
        clickAndCheckDropdownList(1, 2, 1);
    }

    @Tag("all")
    @Tag("disappearing")
    @DisplayName("Страница Disappearing Elements")
    @Test
    public void transitionalToTheDisappearingElements() {
        int i = 0;
        while (isNotBreak) {
            selectExample("Disappearing Elements");
            checkAndClickHomeButton(i++);
        }
    }

    @Tag("all")
    @Tag("inputs")
    @DisplayName("Страница Inputs")
    @Test
    public void transitionalToTheInputs() {
        selectExample("Inputs");
        inputAndCheckText();
    }

    @Tag("all")
    @Tag("hovers")
    @DisplayName("Страница Hovers")
    @Test
    public void transitionalToTheHovers() {
        selectExample("Hovers");
        hoverAndCheckAvatars(1, 2, 3);
    }
}

