package service.testcases;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import service.api.MemberTag;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import static io.restassured.path.json.JsonPath.from;
import static org.hamcrest.Matchers.*;

/**
 * Created by Prowess on 2020/1/2.
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestWeTag {
    static MemberTag mt = new MemberTag();
    static int tagId;
    String memberId = "1850137480";
    int targetTagId = 2;

    @Order(100)
    @Test
    void createTag() {
        String response = mt.createTag(String.valueOf(new Date().getTime()), tagId).then().body("errmsg", equalTo("created")).extract().response().asString();
        tagId = from(response).getInt("tagid");
//        System.out.println(tagId);
    }

    @Order(200)
    @Test
    void updateTagById() {
        mt.updateTagById(String.valueOf(new Date().getTime()), tagId).then().body("errmsg", equalTo("updated"));
    }

    @Order(300)
    @Test
    void deleteTagById() {
        mt.deleteTagById(tagId).then().body("errmsg", equalTo("deleted"));
    }

    @Order(99)
    @Test
    void getTagList() {
        mt.listTags().then().body("errmsg", equalTo("ok"));
    }

    @Order(400)
    @Test
    void addMemberstoTag() {
        mt.addMembertoTag(targetTagId, null, new ArrayList(Arrays.asList(memberId + "8", memberId + "9"))).then().body("errmsg", equalTo("ok"));
    }

    @Order(500)
    @Test
    void getMemberById() {
        mt.getMembersByTagId(targetTagId).then().body("errmsg", equalTo("ok"));
    }

    @Order(600)
    @Test
    void deleteMemberById() {
        mt.deleteMemberfromTag(targetTagId, null, new ArrayList(Arrays.asList(memberId + "8", memberId + "9"))).then().body("errmsg", equalTo("deleted"));
    }
}
