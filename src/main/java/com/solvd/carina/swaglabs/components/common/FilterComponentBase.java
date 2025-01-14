package com.solvd.carina.swaglabs.components.common;

import com.solvd.carina.swaglabs.enums.SortType;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.WebDriver;

public abstract class FilterComponentBase extends AbstractUIObject {
    public FilterComponentBase(WebDriver driver) {
        super(driver);
    }

    public abstract void sortBy(SortType type);
}
