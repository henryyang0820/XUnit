package service;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

/**
 * Created by Prowess on 2019/12/30.
 */
public class TestWork {
    static String token;

    @BeforeAll
    public static void getToken() {
        token = given()
                .param("corpid", "wwec5c5ba00bdb8377")
                .param("corpsecret", "t4P-_xQD-YJmHWO2h0HWxgt4zoFKMQZonLqk4bhaO4c")
                .when()
                .log().all()
                .get("https://qyapi.weixin.qq.com/cgi-bin/gettoken")
                .then()
                .log().all()
                .body("errcode", equalTo(0))
                .extract()
                .body().path("access_token");
        System.out.println(token);
    }

    @Test
    void getDepart(){
        given()
                .log().all()
                .param("access_token",token)
                .when()
                .log().all()
                .get("https://qyapi.weixin.qq.com/cgi-bin/department/list")
                .then()
                .log().all()
                .body("errcode",equalTo(0))
                .extract()
                .body().path("department");
    }

    @Test
    void createDepart(){
        HashMap<String ,Object> data = new HashMap<>();
        data.put("name","天猫子公司1");
        data.put("parentid",1);
        int id =given()
                .log().all()
                .queryParam("access_token",token)
                .contentType(ContentType.JSON)
                .body(data)
                .when()
                .log().all()
                .post("https://qyapi.weixin.qq.com/cgi-bin/department/create")
                .then().log().all()
                .body("errcode",equalTo(0))
                .extract()
                .body().path("id");
        System.out.println("__________________"+id);
    }
}
