package utils;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class RestApiBuilder {
    private final RequestSpecification requestSpecification;

    public RestApiBuilder(String baseUrl) {
        requestSpecification = given().baseUri(baseUrl)
                .config(RestAssuredConfig
                        .config()
                        .httpClient(HttpClientConfig
                                .httpClientConfig()
                                .setParam("http.connection.timeout", 5000)
                        )
                )
                .contentType("application/json")
                .relaxedHTTPSValidation();
        RestAssured.filters(new AllureRestAssured());
    }

    public RequestSpecification build() {
        return requestSpecification;
    }

    public RestApiBuilder addAuth(String token) {
        requestSpecification.header("Authorization", "Bearer " + token);

        return this;
    }

}