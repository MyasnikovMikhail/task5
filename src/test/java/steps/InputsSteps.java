package steps;

import pageElement.InputsPage;

public class InputsSteps {
    public static void inputAndCheckText() {
        new InputsPage()
                .check()
                .checkIsVisible()
                .page()
                .clickAndSandKeys(100 + "@ A")
                .check()
                .checkInputAndClear("100")
                .page()
                .clickAndSandKeys("@ A" + 200)
                .check()
                .checkInputAndClear("200");
    }
}
