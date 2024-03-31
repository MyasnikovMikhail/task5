package steps;

import org.junit.jupiter.api.Assertions;

import static pageElement.StatusCodesPage.*;

public class StatusCodePage {
    public static void selectAndCheckPageText(){
        for (int i = 0; i < 4; i++) {
            String statusCode = statusCodeButton.get(i).getText();
            statusCodeButton.get(i).click();
            Assertions.assertTrue(textPage.getText().contains(statusCode + " status code"));
            System.out.println("Страница №" + (i + 1) + "\n" + textPage.getText().replaceFirst("\n", "") + "\n");
            hereButton.click();
        }
    }
}
