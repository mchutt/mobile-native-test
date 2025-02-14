package com.solvd.carina.swaglabs.pages.common;

import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;

public abstract class DrawingPageBase extends AbstractPage implements IMobileUtils {

    public DrawingPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void drawShape();

    public abstract void clickOnCleanBtn();

    protected void drawShape(ExtendedWebElement screen) {
        Point position = screen.getLocation();
        Dimension size = screen.getSize();

        int startX = position.x + size.width / 4;
        int startY = position.y + size.height / 6;
        int endX = startX + size.width / 2;
        int endY = startY - size.height / 10;

        swipe(startX, startY, endX, startY, 1000);
        swipe(endX, startY, endX, endY, 1000);
        swipe(endX, endY, startX, endY, 1000);
        swipe(startX, endY, startX, startY, 1000);
        int midY = (startY + endY) / 2;
        swipe(startX, midY, endX, midY, 1000);
    }

}
