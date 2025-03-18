import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Test;

import java.util.Objects;

public class HomeworkToken {
    @Test
    public void testHomeworkToken () throws InterruptedException {
        //The first request
        JsonPath response = RestAssured
                .given()
                .get("https://playground.learnqa.ru/ajax/api/longtime_job")
                .jsonPath();
        String token = response.get("token");
        int seconds = response.get("seconds");
        System.out.println("Задача создана успешно");


        //The second request
        Thread.sleep(2000);
        JsonPath response_2 = RestAssured
                .given()
                .queryParam("token", token)
                .get("https://playground.learnqa.ru/ajax/api/longtime_job")
                .jsonPath();


        String status = response_2.get("status");

        if (Objects.equals(status, "Job is NOT ready")) {
            System.out.println("Промежуточный статус верный");
        }

        //The third request
        Thread.sleep(seconds*1000);
        JsonPath response_3 = RestAssured
                .given()
                .queryParam("token", token)
                .get("https://playground.learnqa.ru/ajax/api/longtime_job")
                .jsonPath();

        String result = response_3.get("result");
        String status_2 = response_3.get("status");
        if (Objects.equals(status_2, "Job is ready")) {
            System.out.println("Итоговый статус верный");
        }
        if (result != null){
            System.out.println("Поле result присутствует");
        }

    }


}
