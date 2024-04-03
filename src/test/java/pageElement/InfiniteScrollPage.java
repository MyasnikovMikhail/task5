package pageElement;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.$$x;

public class InfiniteScrollPage {
    public static ElementsCollection listText = $$x("//div [@class='jscroll-added']").as("Список текстов на странице");
}
