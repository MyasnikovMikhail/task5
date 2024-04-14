package steps;

import pageElement.DisappearingElementsPage;

public class DisappearingElementsSteps {

    public static void checkAndClickHomeButton(int i) {
        new DisappearingElementsPage()
                .outInfoNumCycle(i)
                .check()
                .checkIsVisible()
                .checkNumElem()
                .checkNumAttempt(i)
                .page()
                .buttonHomeClick();
    }
}
