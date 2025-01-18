package com.solvd.carina.swaglabs.components.ios;

import com.solvd.carina.swaglabs.components.common.CartItemBase;
import com.zebrunner.carina.utils.ios.IOSUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public class CartItem extends CartItemBase implements IOSUtils {
    @ExtendedFindBy(accessibilityId = "test-Amount")
    private ExtendedWebElement amount;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther/XCUIElementTypeOther[`name == 'test-Description'`]/XCUIElementTypeStaticText[1]")
    private ExtendedWebElement name;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther/XCUIElementTypeOther[`name == 'test-Description'`]/XCUIElementTypeStaticText[2]")
    private ExtendedWebElement description;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == 'test-Price'`]/XCUIElementTypeStaticText[1]")
    private ExtendedWebElement price;

    @ExtendedFindBy(accessibilityId = "test-REMOVE")
    private ExtendedWebElement removeBtn;

    public CartItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public Integer getAmount() {
        return Integer.valueOf(amount.getText());
    }

    @Override
    public String getName() {
        return name.getText();
    }

    @Override
    public String getDescription() {
        return description.getText();
    }

    @Override
    public String getPrice() {
        return price.getText();
    }

    @Override
    public void clickOnRemoveBtn() {
        swipe(removeBtn);
        tap(removeBtn);
    }

}
