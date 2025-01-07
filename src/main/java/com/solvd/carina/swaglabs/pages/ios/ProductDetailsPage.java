package com.solvd.carina.swaglabs.pages.ios;

import com.solvd.carina.swaglabs.pages.common.ProductDetailsPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = ProductDetailsPageBase.class)
public class ProductDetailsPage extends ProductDetailsPageBase {

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == 'test-Description'`]/**/XCUIElementTypeStaticText[1]")
    private ExtendedWebElement name;

    @ExtendedFindBy(accessibilityId = "test-Price")
    private ExtendedWebElement price;

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getProductName(){
        return name.getText();
    }

    @Override
    public String getProductPrice() {
        return price.getText();
    }

}
