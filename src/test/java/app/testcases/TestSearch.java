package app.testcases;

import app.page.App;
import app.page.SearchPage;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.junit.Assert.assertThat;
import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.Collection;

/**
 * Created by Prowess on 2019/11/12.
 */
@RunWith(Parameterized.class)
public class TestSearch {
    public static SearchPage searchPage;
    @BeforeClass
    public static void beforeAll() throws MalformedURLException {
        App.start();

    }

    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][] {
                { "alibaba", 100f },
                { "xiaomi", 8f },
                { "ningdeshidai", 70f }
        });
    }

    @Parameterized.Parameter(0)
    public String stock;

    @Parameterized.Parameter(1)
    public Float price;

    @Before
    public void before(){
        searchPage=App.toSearchPage();
    }
    @Test
    public void search(){
        assertThat(searchPage.search(stock).getCurrentPrice(), greaterThanOrEqualTo(price));
    }
    @After
    public void after(){
        searchPage.cancel();
    }
}
