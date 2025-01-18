package com.solvd.carina.swaglabs.components.android;

import com.solvd.carina.swaglabs.components.common.CartItemBase;
import com.zebrunner.carina.utils.android.IAndroidUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CartItem extends CartItemBase implements IAndroidUtils {

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Amount\"]/android.widget.TextView")
    private ExtendedWebElement amount;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Description']/android.widget.TextView[1]")
    private ExtendedWebElement name;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Description']/android.widget.TextView[2]")
    private ExtendedWebElement description;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Price\"]/android.widget.TextView[1]")
    private ExtendedWebElement price;

    @FindBy(xpath = "//android.widget.TextView[@text=\"REMOVE\"]")
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
        tap(removeBtn);
    }

}
