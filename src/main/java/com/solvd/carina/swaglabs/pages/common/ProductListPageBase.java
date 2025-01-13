package com.solvd.carina.swaglabs.pages.common;

import com.solvd.carina.swaglabs.components.common.ProductCardComponentBase;
import com.solvd.carina.swaglabs.components.common.FilterComponentBase;
import com.solvd.carina.swaglabs.components.common.HeaderComponentBase;
import com.solvd.carina.swaglabs.enums.SortType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

import java.util.List;

public abstract class ProductListPageBase extends AbstractPage implements IMobileUtils {

    @ExtendedFindBy(accessibilityId = "test-Modal Selector Button")
    protected ExtendedWebElement selectorButton;

    public ProductListPageBase(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(selectorButton);
    }

    public abstract FilterComponentBase openFilterComponent();

    public abstract boolean isProductListSortedBy(SortType type);

    public abstract HeaderComponentBase getHeader();

    public abstract ProductCardComponentBase getARandomProduct();

    public abstract List<? extends ProductCardComponentBase> getProducts();
}
