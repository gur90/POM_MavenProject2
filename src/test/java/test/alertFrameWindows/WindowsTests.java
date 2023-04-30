package test.alertFrameWindows;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SidePanel;
import pages.alertFrameWindows.WindowsPage;
import test.TestBase;

public class WindowsTests extends TestBase {

    @BeforeMethod
    public void precondition(){
        new HomePage(driver).getAlertFrameWindows();
        new SidePanel(driver).selectBrowserWindows();
    }


    @Test
    public void newTabTest(){
        new WindowsPage(driver).switchToNewTab(1).assertNewTabByMessage("This is a sample page");
    }
    @Test
    public void newWindowsTest(){
        new WindowsPage(driver).switchToWindowsTab().assertNewWindowsByMessage("This is a sample page");
    }
}
