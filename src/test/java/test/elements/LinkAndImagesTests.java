package test.elements;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SidePanel;
import pages.elements.BrokenLinksImages;
import pages.elements.LinksPage;
import test.TestBase;

public class LinkAndImagesTests extends TestBase {

    @BeforeMethod
    public void precondition(){
        new HomePage(driver).getElements();
    }
    @Test
    public void getLinksTest(){
        new SidePanel(driver).selectLinks();
        new LinksPage(driver).checkAllUrl();
    }
    @Test
    public void checkBrokenLinksTest(){
        new SidePanel(driver).selectBrokenLinks();
        new BrokenLinksImages(driver).checkBrokenLinks();
    }
    @Test
    public void checkBrokenImgTest(){
        new SidePanel(driver).selectBrokenLinks();
        new BrokenLinksImages(driver).checkBrokenImg();
    }
}
