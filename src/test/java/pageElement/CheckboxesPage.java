package pageElement;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import pageElement.Asserts.CheckboxesPageAssert;

import static com.codeborne.selenide.Selenide.$x;

public class CheckboxesPage {

    public static SelenideElement checkbox(int index) {
        return $x("//form[@id='checkboxes']/input[" + index + "]").as("Выбор чекбокса " + index);
    }

    public static boolean statusCheckbox = false;

    public CheckboxesPageAssert check() {
        return CheckboxesPageAssert.assertThat(this);
    }

    public CheckboxesPage clickCheckboxButton(int index) {
        checkbox(index).shouldBe(Condition.visible).click();

        return this;
    }

    public CheckboxesPage getStatusCheckbox(int numCheckbox) {
        statusCheckbox = checkbox(numCheckbox).isSelected();

        return this;
    }

    public CheckboxesPage outInfoStatusCheckbox(int numCheckbox) {
        System.out.println(CheckboxesPage.checkbox(numCheckbox).isSelected() + " " + statusCheckbox);

        return this;
    }
}
