package steps;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import static pageElement.HoversPage.*;

public class HoversSteps {
    @Step("Наведение курсора и проверка вывода имени и доп. информации")
    public static void clickAndCheckAvatars(int ... numAvatars){
        for(int numAvatar: numAvatars){
            avatars(numAvatar).as("Новедение курсора на автар №" + numAvatar).hover();
            Assertions.assertEquals(infoNameAvatars(numAvatar).getText(),"name: user" + numAvatar);
            Assertions.assertEquals(infoLinkAvatars(numAvatar).getText(),"View profile");
        }
    }
}
