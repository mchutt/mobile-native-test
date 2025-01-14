package com.solvd.carina.swaglabs.pages.ios;

import com.solvd.carina.swaglabs.components.common.ProductCardComponentBase;
import com.solvd.carina.swaglabs.components.common.FilterComponentBase;
import com.solvd.carina.swaglabs.components.common.HeaderComponentBase;
import com.solvd.carina.swaglabs.components.ios.IOSHeader;
import com.solvd.carina.swaglabs.components.ios.ProductCardComponent;
import com.solvd.carina.swaglabs.components.ios.IOSFilterComponent;
import com.solvd.carina.swaglabs.utils.ISortingHelper;
import com.solvd.carina.swaglabs.enums.SortType;
import com.solvd.carina.swaglabs.pages.common.ProductListPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = ProductListPageBase.class)
public class ProductListPage extends ProductListPageBase implements ISortingHelper {

    @FindBy(xpath = "//XCUIElementTypeOther[@name='headerContainer']/..")
    private IOSHeader header;

    @ExtendedFindBy(iosPredicate = "name == 'test-Item'")
    private List<ProductCardComponent> productList;

    public ProductListPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public FilterComponentBase openFilterComponent() {
        tap(selectorButton);
        return new IOSFilterComponent(driver);
    }

    @Override
    public HeaderComponentBase getHeader() {
        return header;
    }

    @Override
    public boolean isProductListSortedBy(SortType type) {
        return isProductListSorted(productList, type);
    }

    @Override
    public ProductCardComponentBase getARandomProduct() {
        int rNumber = new Random().nextInt(productList.size());
        return productList.get(rNumber);
    }

    @Override
    public List<? extends ProductCardComponentBase> getProducts() {
        return productList;
    }
}
