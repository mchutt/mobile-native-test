package com.solvd.carina.swaglabs.pages.android;

import com.solvd.carina.swaglabs.components.ios.Header;
import com.solvd.carina.swaglabs.components.ios.ProductCardComponent;
import com.solvd.carina.swaglabs.pages.common.ProductsPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.apache.commons.lang3.NotImplementedException;
import org.openqa.selenium.WebDriver;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProductsPageBase.class)
public class ProductsPage extends ProductsPageBase {
    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isProductListSortedByPriceLowToHigh() {
        throw new NotImplementedException("");
    }

    @Override
    public boolean isProductListSortedByPriceHighToLow() {
        throw new NotImplementedException("");
    }

    @Override
    public boolean isProductListSortedByNameAToZ() {
        throw new NotImplementedException("");
    }

    @Override
    public boolean isProductListSortedByNameZToA() {
        throw new NotImplementedException("");
    }

    @Override
    public Header getHeader() {
        return null;
    }


    @Override
    public ProductCardComponent getARandomProduct() {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public List<ProductCardComponent> getProducts() {
        throw new NotImplementedException("");
    }
}
