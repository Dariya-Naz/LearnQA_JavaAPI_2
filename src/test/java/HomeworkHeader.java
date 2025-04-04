import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomeworkHeader {
    @Test
    public void testHomeworkHeader() {
        Response response = RestAssured
                .given()
                .post("https://playground.learnqa.ru/api/homework_header")
                .andReturn();

        Headers headers = response.getHeaders();
        assertTrue(headers.hasHeaderWithName("x-secret-homework-header"), "Response doesn't contain 'x-secret-homework-header' header");
        assertEquals("Some secret value", headers.getValue("x-secret-homework-header"), "Unexpected header value");
    }
}
