package com.solvd.carina.swaglabs;

import com.solvd.carina.swaglabs.enums.SortType;
import com.solvd.carina.swaglabs.pages.common.ProductListPageBase;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.webdriver.Screenshot;
import com.zebrunner.carina.webdriver.ScreenshotType;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SortTest extends SwagLabsAbstractTest {

    @Test
    @MethodOwner(owner = "mchutt")
    public void verifySortingProductsByPrice() {
        ProductListPageBase productListPage = login();
        Assert.assertTrue(productListPage.isPageOpened(), "Products page is not opened!");

        productListPage.openFilterComponent().sortBy(SortType.PRICE_LOW_TO_HIGH);
        Screenshot.capture(getDriver(), ScreenshotType.EXPLICIT_FULL_SIZE, "after sorting by price low to high");
        Assert.assertTrue(productListPage.isProductListSortedBy(SortType.PRICE_LOW_TO_HIGH), "Product list is not sorted by price in ascending order");

        productListPage.openFilterComponent().sortBy(SortType.PRICE_HIGH_TO_LOW);
        Screenshot.capture(getDriver(), ScreenshotType.EXPLICIT_FULL_SIZE, "after sorting by price high to low");
        Assert.assertTrue(productListPage.isProductListSortedBy(SortType.PRICE_HIGH_TO_LOW), "Product list is not sorted by price in descending order");
    }

    @Test
    @MethodOwner(owner = "mchutt")
    public void verifySortingProductsByName() {
        ProductListPageBase productListPage = login();
        Assert.assertTrue(productListPage.isPageOpened(), "Products page is not opened!");

        productListPage.openFilterComponent().sortBy(SortType.NAME_A_TO_Z);
        Screenshot.capture(getDriver(), ScreenshotType.EXPLICIT_FULL_SIZE, "after sorting by name from a to z");
        Assert.assertTrue(productListPage.isProductListSortedBy(SortType.NAME_A_TO_Z), "Product list is not sorted by name from a to z");

        productListPage.openFilterComponent().sortBy(SortType.NAME_Z_TO_A);
        Screenshot.capture(getDriver(), ScreenshotType.EXPLICIT_FULL_SIZE, "after sorting by name from z to a");
        Assert.assertTrue(productListPage.isProductListSortedBy(SortType.NAME_Z_TO_A), "Product list is not sorted by name from z to a");
    }
}
