package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.bookStore.BookStorePage;

public class HomePage extends BasePage {


    public HomePage(WebDriver driver) {
        super(driver);

    }

    @FindBy(xpath = "//h5[.='Book Store Application']")
    WebElement bookStoreApp;

    public BookStorePage getBookStoreApplication() {
        clickWithJSExecutor(bookStoreApp, 0, 600);
        return new BookStorePage(driver);
    }

    @FindBy(xpath = "//h5[.='Alerts, Frame & Windows']")
    WebElement alertFrameWindows;

    public SidePanel getAlertFrameWindows() {
        clickWithJSExecutor(alertFrameWindows, 0, 400);


        return new SidePanel(driver);
    }
    @FindBy(xpath = "//h5[.='Widgets']")
    WebElement widgets;
    public SidePanel getWidgets() {
        clickWithJSExecutor(widgets,0,400);
        return new SidePanel(driver);
    }
    @FindBy(xpath = "//h5[.='Interactions']")
    WebElement interactions;
    public SidePanel getInteractions() {
        clickWithJSExecutor(interactions,0,400);
        return new SidePanel(driver);
    }
    @FindBy(xpath = "//h5[.='Elements']")
    WebElement elements;
    public SidePanel getElements() {
        clickWithJSExecutor(elements, 0, 400);
        return new SidePanel(driver);
    }
}
