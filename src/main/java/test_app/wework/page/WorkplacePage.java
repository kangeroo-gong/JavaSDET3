package test_app.wework.page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class WorkplacePage extends BasePage{
    public WorkplacePage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public ReportPage toReportPage(){
        swipeDown();
        click("日报");
        return new ReportPage(driver);
    }
}
