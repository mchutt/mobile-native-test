package com.solvd.carina.swaglabs;

import com.solvd.carina.swaglabs.enums.SortType;
import com.solvd.carina.swaglabs.pages.common.ProductListPageBase;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.webdriver.Screenshot;
import com.zebrunner.carina.webdriver.ScreenshotType;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SortTest extends SwagLabsAbstractTest {

    @DataProvider(name = "sortTypes")
    public Object[][] sortTypes() {
        return new Object[][]{
                new Object[]{SortType.PRICE_LOW_TO_HIGH},
                new Object[]{SortType.PRICE_HIGH_TO_LOW},
                new Object[]{SortType.NAME_A_TO_Z},
                new Object[]{SortType.NAME_Z_TO_A}
        };
    }

    @Test(dataProvider = "sortTypes")
    @MethodOwner(owner = "mchutt")
    public void verifySortingProductsBy(SortType sortType) {
        ProductListPageBase productListPage = login();
        Assert.assertTrue(productListPage.isPageOpened(), "Products page is not opened!");
        verifySorting(productListPage, sortType);
    }

    private void verifySorting(ProductListPageBase productListPage, SortType sortType) {
        productListPage.openFilterComponent().sortBy(sortType);
        Screenshot.capture(getDriver(), ScreenshotType.EXPLICIT_FULL_SIZE, "after sorting by " + sortType.getValue());
        Assert.assertTrue(productListPage.isProductListSortedBy(sortType),
                "Product list is not sorted by " + sortType.getValue());
    }
}
