package pages.interActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import javax.swing.*;

public class DroppablePage extends BasePage {
    public DroppablePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id="draggable")
    WebElement dragMe;
    @FindBy(id="droppable")
    WebElement dropHere;
    public DroppablePage actionDragMe() {
        Actions actions=new Actions(driver);
        pause(2000);
        actions.dragAndDrop(dragMe,dropHere).build().perform();

         String text = dropHere.getText();
        if(text.equals("Dropped!")){
            System.out.println("Pass");
        }
        return this;
    }

    public DroppablePage dragAndDropBy(int x, int y) {
        Actions actions= new Actions(driver);
        int xOffset1 = dragMe.getLocation().getX();
         int yOffset1 = dragMe.getLocation().getY();


        int xOffset = dropHere.getLocation().getX();
         int yOffset = dropHere.getLocation().getY();

        xOffset=(xOffset-xOffset)+x;
        yOffset=(yOffset-yOffset)+y;
        pause(1000);
        actions.dragAndDropBy(dragMe,xOffset,yOffset).perform();
        String text = dropHere.getText();
        if(text.equals("Dropped!")){
            System.out.println("Pass");
        } else {
            System.out.println("err");
        }
        return this;
    }
}
