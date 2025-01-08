package com.solvd.carina.swaglabs.pages.android;

import com.solvd.carina.swaglabs.pages.common.ProductDetailsPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProductDetailsPageBase.class)
public class ProductDetailsPage extends ProductDetailsPageBase {

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Description']//android.widget.TextView[1]")
    private ExtendedWebElement name;

    @FindBy(xpath = "//android.widget.TextView[@content-desc='test-Price']")
    private ExtendedWebElement price;

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getProductName() {
        return name.getText();
    }

    @Override
    public String getProductPrice() {
        return price.getText();
    }
}
