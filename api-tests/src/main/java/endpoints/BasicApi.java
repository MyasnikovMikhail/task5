package endpoints;

import io.restassured.specification.RequestSpecification;
import utils.RestApiBuilder;

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

}