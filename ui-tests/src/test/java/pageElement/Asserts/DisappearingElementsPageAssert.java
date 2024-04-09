package pageElement.Asserts;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.assertj.core.api.AbstractAssert;
import org.junit.jupiter.api.Assertions;
import pageElement.DisappearingElementsPage;

import static pageElement.DisappearingElementsPage.buttonHome;
import static pageElement.DisappearingElementsPage.elementsWithButtons;

public class DisappearingElementsPageAssert extends AbstractAssert<DisappearingElementsPageAssert, DisappearingElementsPage> {

    protected DisappearingElementsPageAssert(DisappearingElementsPage actual) {
        super(actual, DisappearingElementsPageAssert.class);
    }

    public static boolean isNotBreak = true;

    public static DisappearingElementsPageAssert assertThat(DisappearingElementsPage actual) {
        return new DisappearingElementsPageAssert(actual);
    }

    public DisappearingElementsPage page() {
        return actual;
    }

    public DisappearingElementsPageAssert checkIsVisible() {
        buttonHome.should(Condition.visible);
        for (SelenideElement btn : elementsWithButtons) {
            btn.should(Condition.visible);
        }


        return this;
    }

    public DisappearingElementsPageAssert checkNumAttempt(int index) {
        if (index == 10) {
            Assertions.assertNotEquals(10, index);
        }
        return this;
    }

    public DisappearingElementsPageAssert checkNumElem() {
        if (elementsWithButtons.size() >= 5)
            isNotBreak = false;
        return this;
    }
}
