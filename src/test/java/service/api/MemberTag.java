package service.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import service.Work;

import java.util.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

/**
 * Created by Prowess on 2019/12/31.
 */
public class MemberTag {

    String url = "https://qyapi.weixin.qq.com/cgi-bin";

    public Response createTag(String tagname, Integer tagid) {
        HashMap<String, Object> data = new HashMap<>();
        data.put("tagname", tagname);
        data.put("tagid", tagid);
        return given()
                .log().all()
                .queryParam("access_token", Work.getInstance().getToken())
                .contentType(ContentType.JSON)
                .body(data)
                .when()
                .log().all()
                .post(url + "/tag/create")
                .then()
                .log().all()
                .body("errcode", equalTo(0))
                .extract().response();
    }

    public Response updateTagById(String tagname, Integer tagid) {
        HashMap<String, Object> data = new HashMap<>();
        data.put("tagname", tagname);
        data.put("tagid", tagid);
        return given()
                .log().all()
                .queryParam("access_token", Work.getInstance().getToken())
                .contentType(ContentType.JSON)
                .body(data)
                .when()
                .log().all()
                .post(url + "/tag/update")
                .then()
                .log().all()
                .body("errcode", equalTo(0))
                .extract().response();
    }

    public Response addMembertoTag(Integer tagid, List partylist, List users) {
        HashMap<Object, Object> data = new HashMap<>();
        data.put("tagid", tagid);
        data.put("partylist", partylist);
        data.put("userlist", users);
        return given()
                .log().all()
                .queryParam("access_token", Work.getInstance().getToken())
                .contentType(ContentType.JSON)
                .body(data)
                .when()
                .log().all()
                .post(url + "/tag/addtagusers")
                .then()
                .log().all()
                .body("errcode", equalTo(0))
                .extract().response();
    }

    public Response deleteMemberfromTag(Integer tagid, List partylist, List users) {
        HashMap<Object, Object> data = new HashMap<>();
        data.put("tagid", tagid);
        data.put("partylist", partylist);
        data.put("userlist", users);
        return given()
                .log().all()
                .queryParam("access_token", Work.getInstance().getToken())
                .contentType(ContentType.JSON)
                .body(data)
                .when()
                .log().all()
                .post(url + "/tag/deltagusers")
                .then()
                .log().all()
                .body("errcode", equalTo(0))
                .extract().response();
    }

    public Response deleteTagById(Integer tagid) {

        return given()
                .log().all()
                .queryParam("access_token", Work.getInstance().getToken())
                .queryParam("tagid", tagid)
                .when()
                .log().all()
                .get(url + "/tag/delete")
                .then()
                .log().all()
                .body("errcode", equalTo(0))
                .extract().response();
    }

    public Response listTags() {
        return given()
                .log().all()
                .queryParam("access_token", Work.getInstance().getToken())
                .when()
                .log().all()
                .get(url + "/tag/list")
                .then()
                .log().all()
                .body("errcode", equalTo(0))
                .extract().response();
    }

    public Response getMembersByTagId(Integer tagid) {
        return given()
                .log().all()
                .queryParam("access_token", Work.getInstance().getToken())
                .queryParam("tagid", tagid)
                .when()
                .log().all()
                .get(url + "/tag/get")
                .then()
                .log().all()
                .body("errcode", equalTo(0))
                .extract().response();
    }


    public static void main(String[] args) {
        MemberTag tag = new MemberTag();
        System.out.println(tag.deleteMemberfromTag(1, new ArrayList(Arrays.asList(1)), null));
    }
}
