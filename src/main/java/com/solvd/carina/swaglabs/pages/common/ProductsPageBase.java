package com.solvd.carina.swaglabs.pages.common;

import com.solvd.carina.swaglabs.components.ios.Header;
import com.solvd.carina.swaglabs.components.ios.ProductCardComponent;
import com.solvd.carina.swaglabs.components.ios.SortModal;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

import java.util.List;

public abstract class ProductsPageBase extends AbstractPage implements IMobileUtils {

    @ExtendedFindBy(accessibilityId = "test-Modal Selector Button")
    private ExtendedWebElement selectorButton;

    public ProductsPageBase(WebDriver driver) {
        super(driver);
    }

    public SortModal openSortModal() {
        tap(selectorButton);
        return new SortModal(driver);
    }

    public abstract boolean isProductListSortedByPriceLowToHigh();

    public abstract boolean isProductListSortedByPriceHighToLow();

    public abstract boolean isProductListSortedByNameAToZ();

    public abstract boolean isProductListSortedByNameZToA();

    public abstract Header getHeader();

    public abstract ProductCardComponent getARandomProduct();

    public abstract List<ProductCardComponent> getProducts();
}
