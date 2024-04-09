package endpoints;

import io.qameta.allure.Step;
import io.restassured.response.Response;

public class ProductsApi extends BasicApi {

    public ProductsApi(String token) {
        super(token);
    }

    @Step("Получить список продуктов в корзине c авторизацией")
    public Response getProductsAuth() {
        return getBuilder()
                .post(Urls.CART);
    }

    @Step("Получить список продуктов в корзине c авторизацией")
    public Response postProductsAuth(int productId, int quantity) {
        return getBuilder().body("""
                        {
                        "product_id": %d,
                          "quantity": %d
                        }
                        """.formatted(productId,quantity))
                .post(Urls.CART);
    }

    @Step("Получить список продуктов без авторизации")
    public Response getProductsWithoutAuth() {
        return getBuilderWithoutAuth()
                .get(Urls.PRODUCTS);
    }

    @Step("Получить продукт без авторизации")
    public Response getProductWithoutAuth(String id) {
        return getBuilderWithoutAuth()
                .get(Urls.PRODUCTS + "/" + id);
    }

}