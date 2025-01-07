package com.solvd.carina.swaglabs.pages.ios;

import com.solvd.carina.swaglabs.components.ios.Header;
import com.solvd.carina.swaglabs.components.ios.ProductCardComponent;
import com.solvd.carina.swaglabs.pages.common.ProductsPageBase;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = ProductsPageBase.class)
public class ProductsPage extends ProductsPageBase {

    @FindBy(xpath = "//XCUIElementTypeOther[@name='headerContainer']/..")
    private Header header;

    @ExtendedFindBy(iosPredicate = "name == 'test-Item'")
    private List<ProductCardComponent> productList;


    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public Header getHeader() {
        return header;
    }

    @Override
    public boolean isProductListSortedByPriceLowToHigh(){
        List<Double> originalProductPriceList = productList.stream().map(ProductCardComponent::getPriceWithoutDollarSymbol).collect(Collectors.toList());

        return Objects.equals(
                originalProductPriceList,
                originalProductPriceList.stream().sorted().collect(Collectors.toList()));
    }

    @Override
    public boolean isProductListSortedByPriceHighToLow() {
        List<Double> originalProductPriceList = productList.stream().map(ProductCardComponent::getPriceWithoutDollarSymbol).collect(Collectors.toList());

        return Objects.equals(
                originalProductPriceList,
                originalProductPriceList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()));
    }

    @Override
    public boolean isProductListSortedByNameAToZ() {
        List<String> originalProductNameList = productList.stream().map(ProductCardComponent::getProductName).collect(Collectors.toList());

        return Objects.equals(originalProductNameList,
                originalProductNameList.stream().sorted().collect(Collectors.toList()));
    }

    @Override
    public boolean isProductListSortedByNameZToA() {
        List<String> originalProductNameList = productList.stream().map(ProductCardComponent::getProductName).collect(Collectors.toList());

        return Objects.equals(originalProductNameList,
                originalProductNameList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()));
    }

    @Override
    public ProductCardComponent getARandomProduct(){
        int rNumber = new Random().nextInt(productList.size());
        return productList.get(rNumber);
    }

    @Override
    public List<ProductCardComponent> getProducts() {
        return productList;
    }

    @Override
    public boolean isPageOpened() {
        return waitUntil(d -> !productList.isEmpty(), R.CONFIG.getInt("explicit_timeout"));
    }
}
