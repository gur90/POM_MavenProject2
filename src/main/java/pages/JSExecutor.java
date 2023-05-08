package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class JSExecutor extends BasePage {
    JavascriptExecutor js;
    public JSExecutor(WebDriver driver) {
        super(driver);
        js = (JavascriptExecutor) driver;
    }

    public JSExecutor enterDataWithJS(String user, String email) {
        if(user!=null && email!=null){
            js.executeScript("document.getElementById('userName').value='" + user + "';");
            js.executeScript("document.getElementById('userName').style.border='4px solid red';");
            js.executeScript("document.getElementById('userEmail').value='" + email + "';");
        }
        return this;
    }

    public JSExecutor clickOnSubmitWithJS() {
        js.executeScript("document.querySelector('#submit').style.backgroundColor='red';");
        js.executeScript("document.getElementById('submit').click();");
        return this;
    }

    public JSExecutor checkInnerTextWithJS() {
        final String innerText = js.executeScript("return document.documentElement.innerText;").toString();
        System.out.println(innerText);
        return this;
    }

    public JSExecutor refreshWithJs() {
        js.executeScript("history.go(0);");


        return this;
    }

    public JSExecutor checkURLWithJS() {
        final String url = js.executeScript("return document.URL;").toString();
        System.out.println("URL of this page = "+ url);
        return this;
    }

    public JSExecutor checkTitleOfPageWithJS() {
        final String pageTitle = js.executeScript("return document.title;").toString();
        System.out.println(pageTitle);
        return this;
    }
}
