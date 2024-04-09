package pageElement.Asserts;

import org.assertj.core.api.AbstractAssert;
import org.junit.Assert;
import pageElement.CheckboxesPage;

import static com.codeborne.selenide.Condition.visible;
import static pageElement.CheckboxesPage.statusCheckbox;

public class CheckboxesPageAssert extends AbstractAssert<CheckboxesPageAssert, CheckboxesPage> {


    protected CheckboxesPageAssert(CheckboxesPage actual) {
        super(actual, CheckboxesPageAssert.class);
    }

    public static CheckboxesPageAssert assertThat(CheckboxesPage actual) {
        return new CheckboxesPageAssert(actual);
    }

    public CheckboxesPage page() {
        return actual;
    }

    public CheckboxesPageAssert checkCheckboxIsVisible() {
        CheckboxesPage.checkbox(1).should(visible);
        CheckboxesPage.checkbox(2).should(visible);

        return this;
    }


    public CheckboxesPageAssert checkStatusCheckbox(int numCheckbox) {
        Assert.assertEquals(CheckboxesPage.checkbox(numCheckbox).isSelected(), statusCheckbox);

        return this;
    }
}
