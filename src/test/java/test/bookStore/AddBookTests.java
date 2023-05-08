package test.bookStore;

import data.UserData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
import pages.SidePanel;
import pages.bookStore.BookStorePage;
import pages.bookStore.LoginPage;
import pages.bookStore.ProfilePage;
import test.TestBase;

public class AddBookTests extends TestBase {
    @BeforeMethod
    public void precondititon(){
        new HomePage(driver).getBookStoreApplication();

        new SidePanel(driver).selectLogin();
        new LoginPage(driver).login(UserData.USER_NAME, UserData.USER_PASSWORD).assertAccount(UserData.USER_NAME);
    }

    @Test
    public void addBookPositiveTest(){

        new BookStorePage(driver).typeInSearchField("Git")
                .assertNameOfBook("Git")
                .addBookToCollection();
        new SidePanel(driver).selectProfile();
        new ProfilePage(driver).assertBook("Git");
    }
    @AfterMethod(enabled = false)
    public void removeBookFromProfile() {
        new SidePanel(driver)
                .selectProfile()
                .assertBook("Git")
                .deleteBook();
    }

}
