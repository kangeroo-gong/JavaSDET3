package test_app.wework.testcase;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import test_app.wework.page.ReportPage;

import static org.junit.jupiter.api.Assertions.*;


class ReportPageTest extends BaseTest {
    private ReportPage reportPage;

    @BeforeEach
    void setUp() {
        reportPage=mainPage.toWorkplacePage().toReportPage();
    }

    @AfterEach
    void tearDown(){
        reportPage.androidBack().androidBack();
    }

    @Test
    void addReport(){
        assertEquals(reportPage.addReport("new test").getReport(),"new test");
    }

}