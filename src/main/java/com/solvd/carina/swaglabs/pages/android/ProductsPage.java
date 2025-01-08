package com.solvd.carina.swaglabs.pages.android;

import com.solvd.carina.swaglabs.components.android.ProductCardComponent;
import com.solvd.carina.swaglabs.components.android.SortModal;
import com.solvd.carina.swaglabs.components.common.ProductCardComponentBase;
import com.solvd.carina.swaglabs.components.common.SortModalBase;
import com.solvd.carina.swaglabs.components.common.Header;
import com.solvd.carina.swaglabs.components.utils.ISortingHelper;
import com.solvd.carina.swaglabs.pages.common.ProductsPageBase;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProductsPageBase.class)
public class ProductsPage extends ProductsPageBase implements ISortingHelper {

    @ExtendedFindBy(androidUIAutomator = "new UiSelector().className(\"android.view.ViewGroup\").instance(8)")
    private Header header;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Item']")
    private List<ProductCardComponent> productList;

    @FindBy(xpath = "//android.widget.TextView[@text='© 2025 Sauce Labs. All Rights Reserved.']")
    private ExtendedWebElement allRightsReservedMessage;

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public SortModalBase openSortModal() {
        tap(selectorButton);
        return new SortModal(driver);
    }

    @Override
    public boolean isProductListSortedByPriceLowToHigh() {
        List<Double> productPriceList = getProducts().stream()
                .map(ProductCardComponentBase::getPriceWithoutDollarSymbol)
                .collect(Collectors.toList());

        return isSortedInAscendingOrder(productPriceList);
    }

    @Override
    public boolean isProductListSortedByPriceHighToLow() {
        List<Double> productPriceList = getProducts().stream()
                .map(ProductCardComponentBase::getPriceWithoutDollarSymbol)
                .collect(Collectors.toList());

        return isSortedInDescendingOrder(productPriceList);
    }

    @Override
    public boolean isProductListSortedByNameAToZ() {
        List<String> productNameList = getProducts().stream()
                .map(ProductCardComponentBase::getProductName)
                .collect(Collectors.toList());

        return isSortedInAscendingOrder(productNameList);
    }

    @Override
    public boolean isProductListSortedByNameZToA() {
        List<String> productNameList = getProducts().stream()
                .map(ProductCardComponentBase::getProductName)
                .collect(Collectors.toList());

        return isSortedInDescendingOrder(productNameList);
    }

    @Override
    public Header getHeader() {
        return header;
    }

    @Override
    public ProductCardComponentBase getARandomProduct() {
        int rNumber = new Random().nextInt(productList.size());
        return productList.get(rNumber);
    }

    @Override
    public List<? extends ProductCardComponentBase> getProducts() {
        waitUntil(driver1 -> !productList.isEmpty(), R.CONFIG.getInt("explicit_timeout"));
        return productList;
    }
}
