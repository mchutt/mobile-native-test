package com.solvd.carina.swaglabs.pages.android;

import com.solvd.carina.swaglabs.components.android.AndroidHeader;
import com.solvd.carina.swaglabs.components.android.ProductCardComponent;
import com.solvd.carina.swaglabs.components.android.AndroidFilterComponent;
import com.solvd.carina.swaglabs.components.common.ProductCardComponentBase;
import com.solvd.carina.swaglabs.components.common.FilterComponentBase;
import com.solvd.carina.swaglabs.components.common.HeaderComponentBase;
import com.solvd.carina.swaglabs.utils.ISortingHelper;
import com.solvd.carina.swaglabs.enums.SortType;
import com.solvd.carina.swaglabs.pages.common.ProductListPageBase;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProductListPageBase.class)
public class ProductListPage extends ProductListPageBase implements ISortingHelper {

    @ExtendedFindBy(androidUIAutomator = "new UiSelector().className(\"android.view.ViewGroup\").instance(8)")
    private AndroidHeader header;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Item']")
    private List<ProductCardComponent> productList;

    @FindBy(xpath = "//android.widget.TextView[@text='© 2025 Sauce Labs. All Rights Reserved.']")
    private ExtendedWebElement allRightsReservedMessage;

    public ProductListPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public FilterComponentBase openFilterComponent() {
        tap(selectorButton);
        return new AndroidFilterComponent(driver);
    }

    @Override
    public boolean isProductListSortedBy(SortType type) {
        return isProductListSorted(productList, type);
    }

    @Override
    public HeaderComponentBase getHeader() {
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
