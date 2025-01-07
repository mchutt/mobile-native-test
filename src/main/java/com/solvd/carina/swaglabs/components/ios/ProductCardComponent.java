package com.solvd.carina.swaglabs.components.ios;

import com.solvd.carina.swaglabs.pages.common.ProductDetailsPageBase;
import com.solvd.carina.swaglabs.pages.ios.ProductDetailsPage;
import com.zebrunner.carina.utils.ios.IOSUtils;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public class ProductCardComponent extends AbstractUIObject implements IOSUtils, IMobileUtils {

    @ExtendedFindBy(iosPredicate = "name == 'test-Item title'")
    private ExtendedWebElement name;

    @ExtendedFindBy(iosPredicate = "name == 'test-Price'")
    private ExtendedWebElement price;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == 'ADD TO CART'`]")
    private ExtendedWebElement addToCartBtn;

    @ExtendedFindBy(iosPredicate = "name == 'test-REMOVE'")
    private ExtendedWebElement removeFromCartBtn;

    public ProductCardComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ProductDetailsPageBase clickOnOpenDetails() {
        swipe(name);
        tap(name);
        return new ProductDetailsPage(driver);
    }

    public boolean isRemoveFromCartBtnPresent() {
        return removeFromCartBtn.isElementPresent();
    }

    public void clickOnAddToCartBtn() {
        swipe(addToCartBtn);
        tap(addToCartBtn);
    }

    public String getProductPrice() {
        return price.getText();
    }

    public String getProductName() {
        return name.getText();
    }

    public Double getPriceWithoutDollarSymbol() {
        String substring = getProductPrice().substring(1);
        return Double.parseDouble(substring);
    }

}
