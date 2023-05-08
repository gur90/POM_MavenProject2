package pages.elements;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class BrokenLinksImages extends BasePage {
    public BrokenLinksImages(WebDriver driver) {
        super(driver);
    }
@FindBy(tagName = "a")
List<WebElement> allLinks;
    public BrokenLinksImages checkBrokenLinks() {

        for (int i = 0; i < allLinks.size(); i++) {
            final WebElement element = allLinks.get(i);
            String url = element.getAttribute("href");
            verifyLinks(url);
        }
        return this;
    }

    public void verifyLinks(String linksUrl) {
        try {


        URL url = new URL(linksUrl);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(5000);
        httpURLConnection.connect();

        if (httpURLConnection.getResponseCode() >= 400) {
            System.out.println(linksUrl + "-" + httpURLConnection.getResponseMessage() + " is a broken link");
        } else {
            System.out.println(linksUrl + "-" + httpURLConnection.getResponseMessage());
        }
    }catch (Exception e){
            System.out.println(linksUrl+"-"+ e.getMessage()+"is broken link");
        }

    }
@FindBy(tagName = "img")
List<WebElement>images;
    public BrokenLinksImages checkBrokenImg() {
        System.out.println("We have "+ images.size()+"  images");
        for (int i = 0; i < images.size(); i++) {
            final WebElement element = images.get(i);
            String image = element.getAttribute("src");
            System.out.println("URL og image " + (i + 1) + " is " + image);
            verifyLinks(image);

            try {
                boolean imageDisplayed = (boolean) ((JavascriptExecutor) driver).executeScript("return (typeof arguments [0].naturalWidth!= undefined && arguments[0].naturalWidth>0);", image);
                if (imageDisplayed) {
                    System.out.println("DISPLAY-OK");
                } else {
                    System.out.println("DISPLAY-BROKEN");
                }
            } catch (Exception e) {
                System.out.println("Error");
            }
        }
        return this;
    }
}
