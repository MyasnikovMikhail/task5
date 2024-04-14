package endpoints;

import io.qameta.allure.Step;
import io.restassured.specification.RequestSpecification;
import utils.RestApiBuilder;

import java.util.Optional;

import static utils.ConfProperties.getProperty;

public class BasicApi {
    protected String token;

    public BasicApi(String token) {
        this.token = token;
    }

    public RequestSpecification getBuilder() {
        return new RestApiBuilder(getProperty("BASE_URL_API"))
                .addAuth(token)
                .build();
    }

    public RequestSpecification getBuilderWithoutAuth() {
        return new RestApiBuilder(getProperty("BASE_URL_API"))
                .build();
    }

    @Step("Получение токена")
    public static String getTokenForPerson(String username, String password) {
        Optional<String> token = AuthApi.loginUser(username, password).jsonPath().getString("access_token").describeConstable();
        return token.orElseGet(() -> AuthApi.registerNewUser(username, password).jsonPath().getString("access_token"));
    }

}