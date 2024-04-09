package pageElement;

import com.codeborne.selenide.SelenideElement;
import pageElement.Asserts.HoversPageAssert;

import static com.codeborne.selenide.Selenide.$x;

public class HoversPage {

    public static SelenideElement avatars(int number) {
        return $x("//div[@class='figure'][" + number + "]").as("Аватар под номером " + number);
    }

    public static SelenideElement infoNameAvatars(int number) {
        return $x("//div[@class='figcaption']/h5[.='name: user" + number + "']").as("Имя аватара №" + number);
    }

    public static SelenideElement infoLinkAvatars(int number) {
        return $x("//div[@class='figcaption']/a[@href = '/users/" + number + "']").as("Личная ссылка аватара №" + number);
    }

    public HoversPageAssert check() {
        return HoversPageAssert.assertThat(this);
    }

    public HoversPage hoverAvatar(int numAvatar) {
        avatars(numAvatar).as("Новедение курсора на автар №" + numAvatar).hover();
        return this;
    }
}