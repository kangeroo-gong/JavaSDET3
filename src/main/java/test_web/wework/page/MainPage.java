package test_web.wework.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class MainPage extends BasePage{

    public MainPage() {
        super();
//        System.setProperty("webdriver.gecko.driver", "/Users/seveniruby/ke/java_3/selenium/drivers/geckodriver");

        String url = "https://work.weixin.qq.com/wework_admin/frame";
//        FirefoxDriver driver=new FirefoxDriver();
        driver.get(url);
        driver.manage().deleteAllCookies();
        List<String> cookieList = null;
        //todo: 改成从文件读取
        try {
            cookieList=Files.readAllLines(Paths.get("src\\main\\resources\\cookie.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //todo: 使用自己的cookie，别使用老师的
        assert cookieList != null;
        String cookies=cookieList.get(0);
        String[] strings=cookies.split("; ");
        driver.get("https://work.weixin.qq.com/wework_admin/frame");
        for (String s:strings){
            String[] str=s.split("=");
            driver.manage().addCookie(new Cookie(str[0],str[1]));
        }
        System.out.println(driver.manage().getCookies());
        driver.get(url);

    }

    public ContactPage toContact() {
        //todo:
        click(By.cssSelector("#menu_contacts"));
//        driver.findElement(By.cssSelector("#menu_contacts")).click();
        return new ContactPage(driver);
    }

}
