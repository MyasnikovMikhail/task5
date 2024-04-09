package pageElement.Asserts;

import com.codeborne.selenide.Condition;
import org.assertj.core.api.AbstractAssert;
import org.junit.jupiter.api.Assertions;
import pageElement.HoversPage;

import static pageElement.HoversPage.*;

public class HoversPageAssert extends AbstractAssert<HoversPageAssert, HoversPage> {

    protected HoversPageAssert(HoversPage actual) {
        super(actual, HoversPageAssert.class);
    }

    public static HoversPageAssert assertThat(HoversPage actual) {
        return new HoversPageAssert(actual);
    }

    public HoversPage page() {
        return actual;
    }


    public HoversPageAssert checkIsVisible() {
        avatars(1).should(Condition.visible);
        avatars(2).should(Condition.visible);
        avatars(3).should(Condition.visible);

        return this;
    }

    public HoversPageAssert checkNameAndInfoAvatar(int numAvatar) {
        Assertions.assertEquals(infoNameAvatars(numAvatar).getText(), "name: user" + numAvatar);
        Assertions.assertEquals(infoLinkAvatars(numAvatar).getText(), "View profile");


        return this;
    }
}