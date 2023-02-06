import jdk.jfr.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

public class PostmanEchoTest {
    @Test
    void someDataTest() {
        given()
                .baseUri("https://postman-echo.com")
                .body("some value") // отправляемые данные (заголовки и query можно выставлять аналогично)
// Выполняемые действия
                .when()
                .post("/post")
// Проверки
                .then()
                .statusCode(200)
                .body("data", equalTo("some more value"))
        ;
    }

    @Test
    void phoneNumber() {
        given()
                .baseUri("https://postman-echo.com")
                .body ("8999-999-99-77")
                .when()
                .post ("/post")
                .then()
                .body ("data", equalTo("8999-999-99-99"));
    }

    @Test
    void fullName() {
        given()
                .baseUri("https://postman-echo.com")
                .contentType("text/plain; charset=UTF-8")
                .body ("Котикова Мария Котофеевна")
                .when()
                .post ("/post")
                .then()
                .body ("data", equalTo("Котикова Мария Котовна"));
    }

    }

