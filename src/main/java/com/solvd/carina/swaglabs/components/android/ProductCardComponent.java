package com.solvd.carina.swaglabs.components.android;

import com.solvd.carina.swaglabs.components.common.ProductCardComponentBase;
import com.solvd.carina.swaglabs.pages.android.ProductDetailsPage;
import com.solvd.carina.swaglabs.pages.common.ProductDetailsPageBase;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductCardComponent extends ProductCardComponentBase implements IMobileUtils {

    @FindBy(xpath = "//android.widget.TextView[@content-desc='test-Item title']")
    private ExtendedWebElement name;

    @FindBy(xpath = "//android.widget.TextView[@content-desc='test-Price']")
    private ExtendedWebElement price;

    @FindBy(xpath = "//android.widget.TextView[@text=\"ADD TO CART\"]")
    private ExtendedWebElement addToCartBtn;

    @FindBy(xpath = "//android.widget.TextView[@text=\"REMOVE\"]")
    private ExtendedWebElement removeFromCartBtn;

    public ProductCardComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public ProductDetailsPageBase clickOnOpenDetails() {
        swipe(name);
        tap(name);
        return new ProductDetailsPage(driver);
    }

    @Override
    public boolean isRemoveFromCartBtnPresent() {
        waitUntil(ExpectedConditions.visibilityOf(removeFromCartBtn.getElement()), R.CONFIG.getInt("explicit_timeout"));
        return removeFromCartBtn.isElementPresent();
    }

    @Override
    public void clickOnAddToCartBtn() {
        swipe(addToCartBtn);
        tap(addToCartBtn);
    }

    @Override
    public String getProductPrice() {
        swipe(price);
        return price.getText();
    }

    @Override
    public String getProductName() {
        return name.getText();
    }

    @Override
    public Double getPriceWithoutDollarSymbol() {
        String substring = getProductPrice().substring(1);
        return Double.parseDouble(substring);
    }

}
