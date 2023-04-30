package test.interActions;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SidePanel;
import pages.interActions.DroppablePage;
import test.TestBase;

public class DragDropTests extends TestBase {
    @BeforeMethod
    public void preconditions(){
        new HomePage(driver).getInteractions();
        new SidePanel(driver).selectDroppable();
    }

    @Test
    public void actionDragMeTest(){
        new DroppablePage(driver).actionDragMe();
    }
    @Test
    public void dragAndDropByTest(){
        new DroppablePage(driver).dragAndDropBy(20,35);

    }
}
