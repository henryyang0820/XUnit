package app.testcases;

import app.page.App;
import app.page.HomePage;
import app.page.LoginPage;
import org.junit.Ignore;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.net.MalformedURLException;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * Created by Prowess on 2019/11/13.
 */
public class TestLogin {
    private static LoginPage lg;
    private static HomePage hg;

    @BeforeAll
    static void beforeAll() throws MalformedURLException {
        lg = App.start();
    }

    @AfterEach
    void loginOut() {
        hg.loginOut();
    }
    @Ignore
    @ParameterizedTest
    @MethodSource("user")
    void testLogin(String name, String pwd ) {
        hg = lg.login(name, pwd);
//        if(name.equals("")||pwd.equals((""))){
//            assertThat(lg.getText(),equalTo(assertString));
//        }
    }

    public static Stream<Arguments> user() {
        return Stream.of(
//                arguments("wuq", "123456"),
//                arguments("yangxiaolong", "1"),
                arguments("maxy", "123456")
        );
    }
}
