package test_app.wework.page;

import org.openqa.selenium.By;

public class MainPage extends BasePage{
    public MainPage() {
        super("com.tencent.wework", ".launch.LaunchSplashActivity");
    }

    public SchedulePage toSchedule(){
        click("日程");
        return new SchedulePage(driver);
    }

    public TodoPage toTodoPage(){
        click("待办");
        return new TodoPage(driver);
    }

    public WorkplacePage toWorkplacePage(){
        click("工作台");
        return new WorkplacePage(driver);
    }
}