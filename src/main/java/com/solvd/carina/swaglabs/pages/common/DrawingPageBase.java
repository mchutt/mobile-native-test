package com.solvd.carina.swaglabs.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class DrawingPageBase extends AbstractPage {

    public DrawingPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void drawShape();
}
