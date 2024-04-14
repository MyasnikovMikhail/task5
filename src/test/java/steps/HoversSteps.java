package steps;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import pageElement.HoversPage;

import static pageElement.HoversPage.*;

public class HoversSteps {
    @Step("Наведение курсора и проверка вывода имени и доп. информации")
    public static void hoverAndCheckAvatars(int... numAvatars) {
        for (int numAvatar : numAvatars) {
            new HoversPage().check()
                    .checkIsVisible()
                    .page()
                    .hoverAvatar(numAvatar)
                    .check()
                    .checkNameAndInfoAvatar(numAvatar);
            avatars(numAvatar).as("Новедение курсора на автар №" + numAvatar).hover();
            Assertions.assertEquals(infoNameAvatars(numAvatar).getText(), "name: user" + numAvatar);
            Assertions.assertEquals(infoLinkAvatars(numAvatar).getText(), "View profile");
        }
    }
}