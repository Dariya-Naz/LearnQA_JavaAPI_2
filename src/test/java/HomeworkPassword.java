import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HomeworkPassword {
    @Test
    public void testSecretPassword(){
        //Get cookie
        String password = "0";
        String[] passwords = {"123456", "password", "12345678", "qwerty", "abc123", "123456789", "111111", "1234567", "iloveyou", "adobe123[a]", "123123", "admin", "1234567890", "letmein", "photoshop[a]", "1234", "monkey", "shadow", "sunshine", "12345", "password1", "princess", "azerty", "trustno1", "0", "baseball", "dragon", "football", "mustang", "access", "master", "michael", "superman", "696969", "batman", "welcome", "1qaz2wsx", "login", "qwertyuiop", "solo", "passw0rd", "starwars", "121212", "flower", "hottie", "loveme", "zaq1zaq1", "hello", "freedom", "whatever", "qazwsx", "666666", "654321", "!@#$%^&*", "charlie", "aa123456", "donald", "qwerty123", "1q2w3e4r", "555555", "lovely", "7777777", "888888", "123qwe", "12345678", "1234567", "ashley", "bailey", "jesus", "ninja"};
        for (String x : passwords) {
            password = x;

        Map<String, String> params = new HashMap<>();
        params.put("login", "super_admin");
        params.put("password", password);

        Response responseForGet = RestAssured
                .given()
                .body(params)
                .post("https://playground.learnqa.ru/ajax/api/get_secret_password_homework")
                .andReturn();
        String responseCookie = responseForGet.getCookie("auth_cookie");


        //Check auth cookie
        Map<String, String> cookies = new HashMap<>();
        cookies.put("auth_cookie", responseCookie);

        Response responseForCheck = RestAssured
                .given()
                .cookies(cookies)
                .when()
                .post("https://playground.learnqa.ru/ajax/api/check_auth_cookie")
                .andReturn();


        String a = responseForCheck.asString();


        if (Objects.equals(a, "You are authorized")) {
            System.out.println(a);
            System.out.println("Correct password is '" + password + "'");
            break;
        }
        }
    }
}
