package pageElement;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class HoversPage {

    public static SelenideElement avatars(int number) {
        return $x("//div[@class='figure'][" + number + "]").as("Аватар под номером " + number);
    }

    public static ElementsCollection infoNameAvatars = $$x("//h5");

    public static ElementsCollection infoLinkAvatars = $$x("//a[.='View profile']");
}
