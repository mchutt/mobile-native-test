package com.solvd.carina.swaglabs.components.common;

import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class CartItemBase extends AbstractUIObject {

    public CartItemBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract Integer getAmount();

    public abstract String getName();

    public abstract String getDescription();

    public abstract String getPrice();

    public abstract void clickOnRemoveBtn();
}
