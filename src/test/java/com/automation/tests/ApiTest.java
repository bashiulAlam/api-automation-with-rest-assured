package com.automation.tests;

import org.junit.jupiter.api.Test;
import utils.Constants;
import utils.EndPoints;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ApiTest {
    @Test
    public void checkPlaceName() {
        String zip = "90210";

        given()
                .when()
                .get(Constants.BASE_URL + EndPoints.PLACE_DETAILS.replace("{zip}", zip))
                .then()
                .assertThat()
                .body("places[0].'place name'", equalTo("Beverly Hills"));
    }
}
