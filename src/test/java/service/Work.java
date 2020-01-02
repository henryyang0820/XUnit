package service;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

/**
 * Created by Prowess on 2020/1/2.
 * 单例获取token
 */
public class Work {
    String token;
    private static Work work;

    public static Work getInstance() {
        if (work == null) {
            work = new Work();
        }
        return work;
    }

    public String getToken() {
        if (token == null) {
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
        return token;
    }
}
