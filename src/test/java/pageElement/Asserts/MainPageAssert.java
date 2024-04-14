package pageElement.Asserts;

import org.assertj.core.api.AbstractAssert;
import pageElement.MainPage;

import static com.codeborne.selenide.Condition.visible;

public class MainPageAssert extends AbstractAssert<MainPageAssert, MainPage> {


    protected MainPageAssert(MainPage actual) {
        super(actual, MainPageAssert.class);
    }

    public static MainPageAssert assertThat(MainPage actual) {
        return new MainPageAssert(actual);
    }

    public MainPage page() {
        return actual;
    }

    public MainPageAssert checkExampleButtonsIsVisible(String nameButton) {
        actual.selectExample(nameButton).should(visible);

        return this;
    }
}
