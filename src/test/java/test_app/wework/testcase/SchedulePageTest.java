package test_app.wework.testcase;

import org.junit.jupiter.api.*;
import test_app.wework.page.SchedulePage;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SchedulePageTest extends BaseTest{

    private SchedulePage schedulePage;

    @BeforeEach
    void setUp() {
        schedulePage=mainPage.toSchedule();
    }

    @AfterEach
    void tearDown(){
        schedulePage.androidBack();
    }

    @Test
    @Order(1)
    void addSchedule() {
        assertTrue(schedulePage.addSchedule("上班打卡", null).getSchedule(null).contains("上班打卡"));
    }

    @Test
    @Order(2)
    void getSchedule() {
        assert(schedulePage.getSchedule(null).size()==1);
    }

    @Test
    @Order(3)
    void delSchedule(){
        assert(schedulePage.delSchedule().getSchedule(null).size()==0);
    }
}