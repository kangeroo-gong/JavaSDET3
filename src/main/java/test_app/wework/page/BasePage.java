package test_app.wework.page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BasePage {
    private final int timeOutInSecondsDefault = 60;
    //    AndroidDriver<MobileElement> driver;
    AppiumDriver<MobileElement> driver;
    //    IOSDriver
    WebDriverWait wait;
    String packageName;
    String activityName;
    final By add =By.id("gym");

    public BasePage(String packageName, String activityName) {
        this.packageName = packageName;
        this.activityName = activityName;
        startApp(this.packageName, this.activityName);

    }

    public BasePage(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, timeOutInSecondsDefault);
    }

    public void startApp(String packageName, String activityName){
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "android");
        desiredCapabilities.setCapability("deviceName", "hogwarts");
        desiredCapabilities.setCapability("appPackage", packageName);
        desiredCapabilities.setCapability("appActivity", activityName);
        desiredCapabilities.setCapability("noReset", "true");
        desiredCapabilities.setCapability("udid", "");
        desiredCapabilities.setCapability("dontStopAppOnReset", "true");
        desiredCapabilities.setCapability("skipLogcatCapture", "true");
        desiredCapabilities.setCapability("chromedriverExecutableDir","E:\\tools\\chromedriver.exe");
        URL remoteUrl = null;
        try {
            remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
            System.exit(1);
        }

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        //todo: 等待优化
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, timeOutInSecondsDefault);
    }


    public void quit() {
        driver.quit();
    }


    public By byText(String text){
        return By.xpath("//*[contains(@text,'"+text+"')]");
    }
    public MobileElement find(By by) {
        return driver.findElement(by);
    }

    public MobileElement find(String text) {
        return driver.findElement(byText(text));
    }

    public void click(By by) {
        //todo: 异常处理
        wait.until(ExpectedConditions.visibilityOfElementLocated(by)).click();
    }

    public void click(String text) {
        //todo: 异常处理
        find(text).click();
    }


    public void sendKeys(By by, String content) {
        driver.findElement(by).sendKeys(content);
    }

    public int getWidth(double multiple){
        return (int) (driver.manage().window().getSize().width*multiple);
    }

    public int getHeight(double multiple){
        return (int) (driver.manage().window().getSize().height*multiple);
    }

    //todo:
    public void waitElement() {

    }

    public BasePage androidBack(){
        ((AndroidDriver<MobileElement>)driver).pressKey(new KeyEvent().withKey(AndroidKey.BACK));
        return this;
    }
    public void swipeDown()
    {
        TouchAction touchAction=new TouchAction(driver);
        touchAction.press(PointOption.point(getWidth(0.5),getHeight(0.8))).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(getWidth(0.5),getHeight(0.2))).release().perform();
    }

    public void swipeUp(){
        TouchAction touchAction=new TouchAction(driver);
        touchAction.press(PointOption.point(getWidth(0.5),getHeight(0.2))).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(getWidth(0.5),getHeight(0.8))).release().perform();
    }
}