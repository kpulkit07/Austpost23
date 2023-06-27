package com.AccessHQ;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.*;

public class ApiPostTest {
    @Test
    public void austStatusCode() {
        RestAssured.given().header("auth-key", "d18f4f1f-2524-4fa0-8937-d93115d82e70").
                and().param("q", "parramatta").and().param("state", "NSW").
                when().get("https://digitalapi.auspost.com.au/postcode/search.json").
                then().assertThat().statusCode(is(200));
    }
    @Test
    public void austPostCode() {

        RestAssured.given().header("auth-key", "d18f4f1f-2524-4fa0-8937-d93115d82e70").
                and().param("q", "parramatta").and().param("state", "NSW").
                when().get("https://digitalapi.auspost.com.au/postcode/search.json").
                then().assertThat().body("localities.locality.postcode", equalTo(2150));
    }
}