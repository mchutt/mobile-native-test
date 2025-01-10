package com.solvd.carina.swaglabs.pages.common;

import com.solvd.carina.swaglabs.components.common.ProductCardComponentBase;
import com.solvd.carina.swaglabs.components.common.SortModalBase;
import com.solvd.carina.swaglabs.components.common.Header;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

import java.util.List;

public abstract class ProductsPageBase extends AbstractPage implements IMobileUtils {

    @ExtendedFindBy(accessibilityId = "test-Modal Selector Button")
    protected ExtendedWebElement selectorButton;

    public ProductsPageBase(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(selectorButton);
    }

    public abstract SortModalBase openSortModal();

    public abstract boolean isProductListSortedByPriceLowToHigh();

    public abstract boolean isProductListSortedByPriceHighToLow();

    public abstract boolean isProductListSortedByNameAToZ();

    public abstract boolean isProductListSortedByNameZToA();

    public abstract Header getHeader();

    public abstract ProductCardComponentBase getARandomProduct();

    public abstract List<? extends ProductCardComponentBase> getProducts();
}
