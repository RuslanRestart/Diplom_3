import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.ErrorLoggingFilter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Random;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;

public class UserUtil {

    private String email;
    private String password = "testPass";

    private final RequestSpecification baseRequestSpecification = new RequestSpecBuilder()
            .addHeader("Content-Type", "application/json")
            .setRelaxedHTTPSValidation()
            .addFilter(new RequestLoggingFilter())
            .addFilter(new ResponseLoggingFilter())
            .addFilter(new ErrorLoggingFilter())
            .build();

    public void createUserFromApi() {
        email = generateEmail();

        String body = "{" +
                "\"email\": \"" + email + "\"," +
                "\"password\": \"" + password + "\"," +
                "\"name\": " + "\"stellarBurgerLover" + "\"" +
                "}";

        given()
                .spec(baseRequestSpecification)
                .body(body)
                .post("https://stellarburgers.nomoreparties.site/api/auth/register");
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public static String generateEmail() {
        return "stellarUser" + new Random().nextInt(10000000) + "@ya.ru";
    }
}
