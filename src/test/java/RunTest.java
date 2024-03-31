import hooks.WebHooks;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.opentest4j.AssertionFailedError;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static pageElement.DisappearingElementsPage.buttonHome;
import static pageElement.DisappearingElementsPage.elementsWithButtons;
import static pageElement.InputsPage.input;
import static steps.AddRemoveElementsSteps.*;
import static steps.CheckboxesSteps.checkAndClickCheckbox;
import static steps.DropdownSteps.clickAndCheckDropdownList;
import static steps.HoversSteps.clickAndCheckAvatars;
import static steps.InputsSteps.clickAndCheckInput;
import static steps.InputsSteps.testDataCollector;
import static steps.MainSteps.clickAndCheckExample;
import static steps.NotificationMessagePage.checkAndCloseMessage;
import static steps.StatusCodePage.selectAndCheckPageText;

public class RunTest extends WebHooks {
    @Tag("Checkboxes-tests")
    @ParameterizedTest(name = "{displayName}: {arguments}")
    @CsvSource({"2", "10"})
    @DisplayName("Страница Checkboxes")
    public void transitionalToTheCheckboxes(int numClickCheckboxes) {
        clickAndCheckExample("Checkboxes", "Checkboxes");
        checkAndClickCheckbox(numClickCheckboxes);
    }

    @DisplayName("Страница Dropdown List")
    @ParameterizedTest(name = "{displayName}: {arguments}")
    @CsvSource({"1,2,1", "2,1,1", "2,2,1"})
    public void transitionalToTheDropdown(int numHov, int twoHov, int treeHov) {
        clickAndCheckExample("Dropdown", "Dropdown List");
        clickAndCheckDropdownList(numHov, twoHov, treeHov);
    }

    @DisplayName("Страница Disappearing Elements")
    @RepeatedTest(value = 10, name = RepeatedTest.LONG_DISPLAY_NAME)
    public void transitionalToTheDisappearingElements(TestInfo testInfo) {
        clickAndCheckExample("Disappearing Elements", "Disappearing Elements");
        if (elementsWithButtons.size() < 5)
            Assertions.fail("Нет 5 элементов");
        buttonHome.click();
    }


    @TestFactory
    List<DynamicTest> transitionalToTheInputs() {
        List<DynamicTest> result = new ArrayList<>();
        List<String> testData = testDataCollector(10);
        clickAndCheckExample("Inputs", "Inputs");
        for (int i = 0; i < testData.size(); i++) {
            final int index = i;
            result.add(
                    DynamicTest.dynamicTest(
                            "Проверка значений поля на странице Inputs #" + i,
                            () -> {
                                clickAndCheckInput(testData.get(index));
                                try {
                                    Assertions.assertEquals(testData.get(index), input.getValue());
                                } catch (AssertionFailedError e) {
                                    Assertions.assertEquals("", input.getValue());
                                }
                            }
                    )
            );
        }
        return result;
    }


    @DisplayName("Страница Hovers")
    @ParameterizedTest(name = "{displayName}: {arguments}")
    @CsvSource({"1,2,3", "2,1,3", "2,2,1"})
    public void transitionalToTheHovers(int numHov, int twoHov, int treeHov) {
        clickAndCheckExample("Hovers", "Hovers");
        clickAndCheckAvatars(numHov, twoHov, treeHov);


    }

    @DisplayName("Страница Notification Message")
    @RepeatedTest(value = 10, name = RepeatedTest.LONG_DISPLAY_NAME)
    public void transitionalToTheNotificationMessage() {
        clickAndCheckExample("Notification Messages", "Notification Message");
        checkAndCloseMessage();
    }

    //--------------Не сделано-----------------------

    @TestFactory
    List<DynamicTest> transitionalToTheAddRemoveElements() {
        List<DynamicTest> result = new ArrayList<>();
        clickAndCheckExample("Add/Remove Elements", "Add/Remove Elements");
        result.add(
                DynamicTest.dynamicTest(
                        "Проверка значений поля на странице Add/Remove Elements #" + 1,
                        () -> {
                            addAndDeleteButtons(2,1);
                        }
                ));
        result.add(
                DynamicTest.dynamicTest(
                        "Проверка значений поля на странице Add/Remove Elements #" + 2,
                        () -> {
                            addAndDeleteButtons(5,2);
                        }
                ));
        result.add(
                DynamicTest.dynamicTest(
                        "Проверка значений поля на странице Add/Remove Elements #" + 3,
                        () -> {
                            addAndDeleteButtons(1,3);
                        }
                )
        );
        return result;
    }

    @DisplayName("Проверка страниц Status Codes")
    @Test
    public void transitionalToTheAddStatusCodes() {
        clickAndCheckExample("Status Codes", "Status Codes");
        selectAndCheckPageText();
    }
}
