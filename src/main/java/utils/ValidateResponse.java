package utils;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import models.JsonElementModel;
import models.JsonModel;
import org.apache.log4j.Logger;

import java.util.List;

import static io.restassured.RestAssured.given;
import static utils.BaseURL.BASE_URI;

public class ValidateResponse {
    private static final Logger LOGGER = Logger.getLogger(ValidateResponse.class);

    public static ValidatableResponse getRequest(String path) {
        RestAssured.baseURI = BASE_URI;
        return given()
                .when()
                .get(path)
                .then();
    }

    public static JsonModel getJSON(String path) {
        LOGGER.info("Getting Json");
        return getRequest(path).extract()
                .jsonPath().getObject(".", JsonModel.class);
    }


    public static List<JsonElementModel> getJsonElementList(String path) {
        LOGGER.info("Getting Json elements list");
        return getRequest(path).extract()
                .jsonPath().getList("entries", JsonElementModel.class);
    }

}
