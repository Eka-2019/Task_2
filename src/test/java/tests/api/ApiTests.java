package tests.api;

import config.EndPoint;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;
import tests.utils.UtilsMethods;
import utils.ValidateResponse;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.lessThan;

public class ApiTests {
    ValidatableResponse response = ValidateResponse.getRequest(EndPoint.ENTRIES.getPath());

    @Test
    public void JSONStatusTest() {
        response.statusCode(200);
        response.statusLine("HTTP/1.1 200 OK");
    }

    @Test
    public void TimeLoadFileTest() {
        response.time(lessThan(30L), TimeUnit.SECONDS);
    }

    @Test
    public void JSONHeaderTest() {
        String date = UtilsMethods.getServerCurrentDate();
        response.headers("Content-Type", "application/json");
        response.headers("Transfer-Encoding", "chunked");
        response.headers("Date", date);
        response.headers("Server", "Caddy");
        response.headers("Access-Control-Allow-Origin", "*");
        response.headers("X-Rate-Limit-Duration", "1");
        response.headers("X-Rate-Limit-Limit", "10.00");
        response.headers("X-Rate-Limit-Request-Forwarded-For", "100.1.15.120");
    }
}


