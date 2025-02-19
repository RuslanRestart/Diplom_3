import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.ErrorLoggingFilter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class StellarBurgerApi {

    private final RequestSpecification baseRequestSpecification = new RequestSpecBuilder()
            .addHeader("Content-Type", "application/json")
            .setRelaxedHTTPSValidation()
            .addFilter(new RequestLoggingFilter())
            .addFilter(new ResponseLoggingFilter())
            .addFilter(new ErrorLoggingFilter())
            .build();

    public Response createUserFromApi(User user) {

        String body = "{" +
                "\"email\": \"" + user.getEmail() + "\"," +
                "\"password\": \"" + user.getPassword() + "\"," +
                "\"name\": \"" + user.getName() +  "\"" +
                "}";

        return given()
                .spec(baseRequestSpecification)
                .body(body)
                .post("https://stellarburgers.nomoreparties.site/api/auth/register")
                .thenReturn();
    }

    public Response deleteUserFromApi(String bearerToken) {
        return given()
                .spec(baseRequestSpecification)
                .auth().oauth2(bearerToken)
                .delete("https://stellarburgers.nomoreparties.site/api/auth/user")
                .thenReturn();
    }
}
