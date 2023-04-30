package test.bookStore;

import data.UserData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
import pages.SidePanel;
import pages.bookStore.BookStorePage;
import pages.bookStore.LoginPage;
import test.TestBase;

public class AddBookTests extends TestBase {
    @BeforeMethod
    public void precondititon(){
        new HomePage(driver).getBookStoreApplication();

        new SidePanel(driver).selectLogin();
    }
    @Test
    public void loginPositiveTest(){
        new LoginPage(driver).login(UserData.USER_NAME, UserData.USER_PASSWORD).assertAccount(UserData.USER_NAME);
    }

    @Test
    public void searchBookPositiveTest(){
        new BookStorePage(driver).typeInSearchField("Speaking java")
                .assertNameOfBook("Speaking java");
    }



}
