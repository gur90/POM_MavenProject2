package pages.alertFrameWindows;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class WindowsPage extends BasePage {
    public WindowsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "tabButton")
    WebElement tabButton;

    public WindowsPage switchToNewTab(int index) {
        click(tabButton);
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(index));
        return this;
    }

    @FindBy(id = "sampleHeading")
    WebElement sampleHeading;

    public WindowsPage assertNewTabByMessage(String text) {
        Assert.assertTrue(shouldHave(sampleHeading, text, 15));

        return this;
    }

    @FindBy(id = "windowButton")
    WebElement windowButton;

    public WindowsPage switchToWindowsTab() {
        click(windowButton);
        driver.get("https://demoqa.com/sample");
        return this;
    }

    @FindBy(id = "sampleHeading")
    WebElement sampleHeading2;

    public WindowsPage assertNewWindowsByMessage(String text) {
        Assert.assertTrue(shouldHave(sampleHeading2, text, 15));
        return this;
    }
}
