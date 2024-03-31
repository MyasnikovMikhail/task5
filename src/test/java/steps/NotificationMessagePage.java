package steps;

import org.junit.jupiter.api.Assertions;

import static pageElement.NotificationMessagePage.*;

public class NotificationMessagePage {
    public static void checkAndCloseMessage(){
        System.out.println(notificationMessage.getText());
        if (!notificationMessage.getText().contains("Action successful"))
            Assertions.fail("Неверное уведомление");
        closeMessageButton.click();
        clickHereButton.click();
    }
}
