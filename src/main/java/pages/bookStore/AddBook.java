package pages.bookStore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class AddBook extends BasePage {
    public AddBook(WebDriver driver) {
        super(driver);
    }
    @FindBy(id="see-book-Speaking JavaScript")
    WebElement book;



}
