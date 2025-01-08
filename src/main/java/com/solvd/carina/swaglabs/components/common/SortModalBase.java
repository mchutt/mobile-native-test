package com.solvd.carina.swaglabs.components.common;

import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.WebDriver;

public abstract class SortModalBase extends AbstractUIObject {
    public SortModalBase(WebDriver driver) {
        super(driver);
    }

    public abstract void sortByNameAToZ();

    public abstract void sortByNameZToA();

    public abstract void sortByPriceLowToHigh();

    public abstract void sortByPriceHighToLow();
}
