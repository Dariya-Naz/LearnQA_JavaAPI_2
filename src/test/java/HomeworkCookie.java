import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomeworkCookie {
    @Test
    public void testHomeworkCookie() {
        Response response = RestAssured
                .given()
                .post("https://playground.learnqa.ru/api/homework_cookie")
                .andReturn();

        Map<String, String> cookies = response.getCookies();

        String responseCookie = response.getCookie("HomeWork");

        assertTrue(cookies.containsKey("HomeWork"), "Response does not contain cookie 'Hemowork'");
        assertTrue((responseCookie.equals("hw_value")), "Cookie value is not equal to 'hw_value'");

    }
}
