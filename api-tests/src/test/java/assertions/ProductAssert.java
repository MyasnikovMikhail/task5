package assertions;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.assertj.core.api.AbstractAssert;

public class ProductAssert extends AbstractAssert<BasicAssert, Response> {

    public ProductAssert(Response actual) {
        super(actual, ProductAssert.class);
    }

    public static ProductAssert assertThat(Response actual) {
        return new ProductAssert(actual);
    }

    @Step("Проверить продукты по количеству")
    public void checkProductsResponse(int quantityOfProducts) {
        BasicAssert.assertThat(actual)
                .statusCodeIsEqual(200)
                .responseQuantityIsEqual(quantityOfProducts);

    }

    @Step("Проверка продукта")
    public void checkProduct(String category, double discount, int id, String name, double price) {
        BasicAssert.assertThat(actual)
                .statusCodeIsEqual(200)
                .responseFieldIsEqual("category[0]", category)
                .responseFieldIsEqual("discount[0]", discount)
                .responseFieldIsEqual("id[0]", id)
                .responseFieldIsEqual("name[0]", name)
                .responseFieldIsEqual("price[0]", price);

    }

    @Step("Проверка продукта в корзине")
    public void checkStatusCodeProductInCart(int statusCode) {
        BasicAssert.assertThat(actual)
                .statusCodeIsEqual(statusCode);

    }

}