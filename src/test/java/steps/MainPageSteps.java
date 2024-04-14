package steps;

import pageElement.MainPage;

public class MainPageSteps {
    public static void selectExample(String exampleName) {
        new MainPage().check()
                .checkExampleButtonsIsVisible(exampleName)
                .page()
                .clickExampleButton(exampleName);
    }
}
