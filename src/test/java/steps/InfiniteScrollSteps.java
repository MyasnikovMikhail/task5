package steps;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.actions;
import static pageElement.InfiniteScrollPage.listText;

public class InfiniteScrollSteps {
    public static void searchWordAndScroll(String word) {
        boolean isActive = true;
        while (isActive) {
            actions().scrollToElement(listText.get(listText.size() - 1));
            for (SelenideElement text : listText) {
                if (text.getText().contains(word)) {
                    actions().scrollToElement(text);
                    if (text.isDisplayed()) {
                        System.out.println(text.getText());
                        isActive = false;
                        break;
                    }
                }
            }
            listText.get(listText.size() - 1).scrollIntoView(true);
        }
    }
}
