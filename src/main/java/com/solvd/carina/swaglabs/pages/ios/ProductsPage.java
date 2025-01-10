package com.solvd.carina.swaglabs.pages.ios;

import com.solvd.carina.swaglabs.components.common.ProductCardComponentBase;
import com.solvd.carina.swaglabs.components.common.SortModalBase;
import com.solvd.carina.swaglabs.components.common.Header;
import com.solvd.carina.swaglabs.components.ios.ProductCardComponent;
import com.solvd.carina.swaglabs.components.ios.SortModal;
import com.solvd.carina.swaglabs.utils.ISortingHelper;
import com.solvd.carina.swaglabs.pages.common.ProductsPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = ProductsPageBase.class)
public class ProductsPage extends ProductsPageBase implements ISortingHelper {

    @FindBy(xpath = "//XCUIElementTypeOther[@name='headerContainer']/..")
    private Header header;

    @ExtendedFindBy(iosPredicate = "name == 'test-Item'")
    private List<ProductCardComponent> productList;

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public SortModalBase openSortModal() {
        tap(selectorButton);
        return new SortModal(driver);
    }


    @Override
    public Header getHeader() {
        return header;
    }

    @Override
    public boolean isProductListSortedByPriceLowToHigh() {
        List<Double> originalProductPriceList = productList.stream().map(ProductCardComponent::getPriceWithoutDollarSymbol).collect(Collectors.toList());

        return isSortedInAscendingOrder(originalProductPriceList);
    }

    @Override
    public boolean isProductListSortedByPriceHighToLow() {
        List<Double> originalProductPriceList = productList.stream().map(ProductCardComponent::getPriceWithoutDollarSymbol).collect(Collectors.toList());

        return isSortedInDescendingOrder(originalProductPriceList);
    }

    @Override
    public boolean isProductListSortedByNameAToZ() {
        List<String> originalProductNameList = productList.stream().map(ProductCardComponent::getProductName).collect(Collectors.toList());

        return isSortedInAscendingOrder(originalProductNameList);
    }

    @Override
    public boolean isProductListSortedByNameZToA() {
        List<String> originalProductNameList = productList.stream().map(ProductCardComponent::getProductName).collect(Collectors.toList());

        return isSortedInDescendingOrder(originalProductNameList);
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
