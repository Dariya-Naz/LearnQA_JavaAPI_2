import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomeworkTest {
    @Test
    public void testGetJson(){
        JsonPath response = RestAssured
                .given()
                .get("https://playground.learnqa.ru/api/get_json_homework")
                .jsonPath();

        List<Object> answer = response.getList("messages");

        Map<String, String> massiv = new HashMap<>();
        massiv.put("message", "timestamp");

        massiv = (Map<String, String>) answer.get(1);

        String message = massiv.get("message");
        System.out.println(message);

    }
}
