import io.restassured.response.Response;
import java.util.Random;

public class UserUtil {

    public static void setTokenToUser(Response response, User user){
        String[] accessTokenValue = response.getBody().jsonPath().get("accessToken").toString().split(" ");
        String token = accessTokenValue[1];
        user.setBearerToken(token);
    }

    public static String generateEmail() {
        return "stellarUser" + new Random().nextInt(10000000) + "@ya.ru";
    }
}
