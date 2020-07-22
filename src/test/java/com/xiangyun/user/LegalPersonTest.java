package com.xiangyun.user;

import com.xiangyun.BaseTest;
import org.junit.jupiter.api.Test;

import static com.xiangyun.BaseRequestBody.body;
import static io.restassured.RestAssured.given;

public class LegalPersonTest extends BaseTest {
    @Test
    void should_return_success_given_legalPersonInfo_when_register() {
        given().contentType("application/json")
                .body(body()
                        .put("type", 1)
                        .put("companyName", "企业名称")
                        .put("companyCode", "JLCC00000000000001")
                        .build())
                .when().post("/api/legalPerson/register")
                .then().log().body()
                .statusCode(200);
    }
}
