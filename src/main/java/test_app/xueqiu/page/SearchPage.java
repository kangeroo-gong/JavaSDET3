package test_app.xueqiu.page;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchPage {
    private AndroidDriver driver;
    private By nameLocator=By.id("name");

    public SearchPage() {
    }

    public SearchPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public SearchPage search(String keyword){
        MobileElement el5 = (MobileElement) driver.findElementById("com.xueqiu.android:id/search_input_text");
        el5.sendKeys(keyword);
        return this;

    }

    public List<String> getSearchList(){
        List<String> nameList=new ArrayList<>();
//        for(Object element: driver.findElements(nameLocator)){
//            nameList.add(((WebElement)element).getText());
//        }
        driver.findElements(nameLocator).forEach(name->nameList.add(((WebElement)name).getText()));
        return nameList;
    }

    public double getPrice(){
        driver.findElement(nameLocator).click();
        return Double.parseDouble(driver.findElement(By.id("current_price")).getText());
    }

    public void addFirstSearchResult(){
        //点击第一条搜索结果
        WebElement element= (WebElement) driver.findElements(nameLocator).get(0);
        element.click();
        //点击第一条的加入自选
        driver.findElementById("com.xueqiu.android:id/follow_btn").click();
        //点击取消
        driver.findElementById("com.xueqiu.android:id/action_close").click();
    }
}
