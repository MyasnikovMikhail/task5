package pageElement.Asserts;

import com.codeborne.selenide.Condition;
import org.assertj.core.api.AbstractAssert;
import org.junit.Assert;
import pageElement.DropdownPage;

import static pageElement.DropdownPage.dropdownList;

public class DropdownPageAssert extends AbstractAssert<DropdownPageAssert, DropdownPage> {
    protected DropdownPageAssert(DropdownPage actual) {
        super(actual, DropdownPageAssert.class);
    }

    public static DropdownPageAssert assertThat(DropdownPage actual) {
        return new DropdownPageAssert(actual);
    }

    public DropdownPage page() {
        return actual;
    }


    public DropdownPageAssert checkIsVisible() {
        dropdownList.should(Condition.visible);

        return this;
    }

    public DropdownPageAssert checkSelectOption(int index) {
        Assert.assertEquals(dropdownList.getText(), "Option " + index);

        return this;
    }

    public DropdownPageAssert infoSelectOption(int index) {
        System.out.println(dropdownList.getText() + "| Option " + index);
        return this;
    }
}
