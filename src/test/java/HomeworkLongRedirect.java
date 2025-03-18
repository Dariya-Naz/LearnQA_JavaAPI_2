import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class HomeworkLongRedirect {
    @Test
    public void testRedirect() {
        int statusCode = 0;
        int count = 0;
        String locationHeader = "https://playground.learnqa.ru/api/long_redirect";
        do {
            Response response = RestAssured
                    .given()
                    .redirects()
                    .follow(false)
                    .get(locationHeader)
                    .andReturn();

            locationHeader = response.getHeader("Location");
            statusCode = response.getStatusCode();
            count++;
        } while (statusCode == 301);
        System.out.println("Количество редиректов: " + (count-1));
    }
}


