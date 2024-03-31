package steps;

import io.qameta.allure.Step;

import java.util.ArrayList;
import java.util.List;

import static pageElement.InputsPage.input;

public class InputsSteps {

    @Step("Ввод данных в поле элемента input")
    public static void clickAndCheckInput(String sendString) {
        input.click();
        input.clear();
        input.sendKeys(sendString);
        System.out.println("Введенная строка: " + sendString);
        System.out.println("Вывод значения в поле: " + input.getValue() + "\n");
    }

    public static List<String> testDataCollector(int size) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < size - 2; i++) {
            result.add((int) (Math.random() * 10000) + "");
        }
        result.add("Строка");
        result.add("Вторая строка");
        return result;
    }
}
