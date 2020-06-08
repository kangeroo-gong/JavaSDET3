package test_app.wework.testcase;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import test_app.wework.page.MainPage;

public class BaseTest {
    static MainPage mainPage;
    @BeforeAll
    static void beforeAll(){
        mainPage = new MainPage();

    }
    @AfterAll
    static void afterAll() {
        mainPage.quit();
    }
}
