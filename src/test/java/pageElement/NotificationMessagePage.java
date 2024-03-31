package pageElement;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class NotificationMessagePage {

    public static SelenideElement notificationMessage = $x("//div[@class='flash notice']").as("Поле с уведомлением");

    public static SelenideElement clickHereButton = $x("//a[.='Click here']").as("Кнопка загрузки нового сообщения");

    public static SelenideElement closeMessageButton = $x("//a[@href='#']").as("Текст уведомления");

}
