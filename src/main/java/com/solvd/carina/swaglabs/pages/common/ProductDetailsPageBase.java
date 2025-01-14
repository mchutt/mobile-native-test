package com.solvd.carina.swaglabs.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ProductDetailsPageBase extends AbstractPage {

    public ProductDetailsPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract String getProductName();
    public abstract String getProductPrice();

}
