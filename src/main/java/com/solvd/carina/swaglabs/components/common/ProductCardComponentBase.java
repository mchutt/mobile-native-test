package com.solvd.carina.swaglabs.components.common;

import com.solvd.carina.swaglabs.pages.common.ProductDetailsPageBase;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class ProductCardComponentBase extends AbstractUIObject {

    public ProductCardComponentBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract ProductDetailsPageBase clickOnOpenDetails();

    public abstract boolean isRemoveFromCartBtnPresent();

    public abstract void clickOnAddToCartBtn();

    public abstract String getProductPrice();

    public abstract String getProductName();

    /**
     * Parses and retrieves the product price as a double, removing any currency symbols.
     * @return Double - The product price as a numeric value.
     */
    public abstract Double getPriceWithoutDollarSymbol();
}

