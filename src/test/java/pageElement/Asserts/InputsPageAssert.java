package pageElement.Asserts;

import com.codeborne.selenide.Condition;
import org.assertj.core.api.AbstractAssert;
import org.junit.Assert;
import pageElement.InputsPage;

import static pageElement.InputsPage.input;

public class InputsPageAssert extends AbstractAssert<InputsPageAssert, InputsPage> {

    protected InputsPageAssert(InputsPage actual) {
        super(actual, InputsPageAssert.class);
    }

    public static InputsPageAssert assertThat(InputsPage actual) {
        return new InputsPageAssert(actual);
    }

    public InputsPage page() {
        return actual;
    }

    public InputsPageAssert checkIsVisible() {
        input.should(Condition.visible);

        return this;
    }

    public InputsPageAssert checkInputAndClear(String answer) {
        Assert.assertEquals(input.getValue(), answer);
        input.clear();

        return this;
    }
}
