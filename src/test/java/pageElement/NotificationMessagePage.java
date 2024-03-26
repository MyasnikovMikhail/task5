package pageElement;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class NotificationMessagePage {

    public static SelenideElement notificationMessage = $x("//div[@class='flash notice']");

    public static SelenideElement clickHereButton = $x("//a[.='Click here']");

    public static SelenideElement closeMessageButton = $x("//a[@href='#']");

}
