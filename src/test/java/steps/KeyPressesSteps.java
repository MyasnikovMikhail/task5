package steps;

import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Selenide.actions;
import static pageElement.KeyPressesPage.text;

public class KeyPressesSteps {
    public static void pressBtnAndCheckText(CharSequence key, String youEntered) {
        actions().sendKeys(key).build().perform();
        Assertions.assertEquals(text.getText(), "You entered: " + youEntered);

    }

    public static void pressBtnLettersAndCheckText() {
        for (int i = 0; i <= 10; i++) {
            char letter = (char) (65 + Math.random() * 26);
            System.out.print(letter + " ");
            pressBtnAndCheckText(letter + "", letter + "");
        }

    }
}
