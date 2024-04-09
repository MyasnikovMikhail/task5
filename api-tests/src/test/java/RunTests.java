
import assertions.ProductAssert;
import endpoints.AuthApi;
import endpoints.ProductsApi;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RunTests {

    ProductsApi productsApi;

    @BeforeEach
    void getAuthToken() {
        String token = AuthApi.loginUser("mmk", "mmk").jsonPath().getString("access_token");
        productsApi = new ProductsApi(token);
    }
    @Test
    void checkProductById() {
        Response response = productsApi.getProductWithoutAuth("1");
        ProductAssert.assertThat(response)
                .checkProduct("Electronics", 10.0, 1, "HP Pavilion Laptop", 10.99);
    }

    @Test
    void checkNumOfProductsInList() {
        Response response = productsApi.getProductsWithoutAuth();
        ProductAssert.assertThat(response).checkProductsResponse(16);
    }

}
