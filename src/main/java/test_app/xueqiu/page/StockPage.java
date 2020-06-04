package test_app.xueqiu.page;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class StockPage {
    private AndroidDriver driver;


    public StockPage(AndroidDriver driver) {
        this.driver=driver;
    }

    public boolean isEmpty(){
        try {
            driver.findElementById("com.xueqiu.android:id/fl_empty_container").isDisplayed();
        }
        catch (NoSuchElementException e){
            return false;
        }
        return true;
    }

    public StockPage delAllStock(){
        //进入管理自选股股
        driver.findElementById("com.xueqiu.android:id/edit_group").click();
        //点击全选
        driver.findElementById("com.xueqiu.android:id/check_all").click();
        //点击删除自选
        driver.findElementById("com.xueqiu.android:id/cancel_follow").click();
        //点击确定
        driver.findElementById("com.xueqiu.android:id/tv_right").click();
        //点击完成
        driver.findElementById("com.xueqiu.android:id/action_close").click();
        return this;
    }

    public StockPage addStock(String stockName){
        WebElement element= (WebElement) driver.findElementsById("com.xueqiu.android:id/action_search").get(0);
        element.click();
        SearchPage searchPage=new SearchPage(driver);
        searchPage.search(stockName).addFirstSearchResult();
        return this;
    }

    public String getFirstStockName(){
        //获取自选股列表第一条股票名字
        List elements=driver.findElementsById("com.xueqiu.android:id/portfolio_stockName");
        WebElement element=(WebElement) elements.get(0);
        return element.getText();
    }

    public void quit(){
        driver.quit();
    }
}
