package endpoints;

import dto.request.DTOUser;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import utils.RestApiBuilder;

import static utils.ConfProperties.getProperty;

public class AuthApi {

    @Step("Зарегистрировать нового пользователя 'login'")
    public static Response registerNewUser(String login, String password) {
        return new RestApiBuilder(getProperty("BASE_URL_API")).build()
                .body(new DTOUser(login, password))
                .post(Urls.REGISTER);
    }

    @Step("Авторизоваться под пользователем 'login'")
    public static Response loginUser(String login, String password) {
        return new RestApiBuilder(getProperty("BASE_URL_API")).build()
                .body(new DTOUser(login, password))
                .post(Urls.LOGIN);
    }

}