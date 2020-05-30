package test_web.wework.page;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;

public class ContactPage extends BasePage {
    By addMember=By.linkText("添加成员");
    By username=By.name("username");
    By delete=By.linkText("删除");
    By name=By.name("name");
    By submit=By.xpath("//a[@d_ck='submit']");

    public ContactPage(RemoteWebDriver driver) {
        super(driver);
    }

    public ContactPage addMember(String username, String acctid, String mobile) {
        while(driver.findElements(this.username).size()==0){
            click(addMember);
        }

        sendKeys(this.username, username);
        sendKeys(By.name("acctid"), acctid);
        sendKeys(By.name("mobile"), mobile);
        click(By.cssSelector(".js_btn_save"));
        return this;
    }

    public ContactPage search(String keyword){
        sendKeys(By.id("memberSearchInput"), keyword);
        return this;
    }

    public String getUserName(){
        return driver.findElement(By.cssSelector(".member_display_cover_detail_name")).getText();
    }

    public ContactPage delete(){
        click(delete);
        click(By.linkText("确认"));
        click(By.id("clearMemberSearchInput"));
        return this;
    }

    public ContactPage importFromFile(URL path){
        //todo:
        System.out.println(path.getPath());

        String path_utf="";
        try {
            path_utf=URLDecoder.decode(path.getFile(), "UTF-8");
            System.out.println(path_utf);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        click(By.cssSelector(".ww_operationBar:nth-child(1) .ww_btn_PartDropdown_left"));
        click(By.linkText("文件导入"));
        upload(By.name("file"), path_utf);
        click(By.linkText("导入"));
        click(By.linkText("完成"));

        return this;
    }

    public ContactPage addParty(String partyName){
        click(By.className("member_colLeft_top_addBtn"));
        click(By.className("js_create_party"));
        sendKeys(name,partyName);
        click(By.className("js_parent_party_name"));
        //点击第一个部门
        click(By.xpath("//*[@class='js_parent_party_name']/parent::a/following-sibling::div/child::div/ul/li"));

        click(submit);
        return this;
    }

    public ContactPage delParty(){
        click(By.xpath("//*[@class='jstree-anchor jstree-clicked']/child::span"));
        click(By.xpath("/html/body/ul/li/a[@rel='3']"));
        click(submit);
        return this;
    }

    public ContactPage addTag(String tagName){
        click(By.xpath("//a[contains(@href,'tag')]"));
        sleep(1000);
        click(By.className("member_colLeft_top_addBtn"));
        sendKeys(name,tagName);

        click(submit);
        return this;
    }

    public ContactPage delTag(){

        click(By.xpath("//*[@class='member_tag_list_item  member_tag_list_item_Active ']/child::a"));
        click(By.xpath("//*[@on-click='removeTag']"));
        click(By.linkText("确定"));
        return this;
    }
    public ContactPage sleep(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }
}
