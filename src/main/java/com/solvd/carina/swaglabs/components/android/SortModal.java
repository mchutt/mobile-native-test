package com.solvd.carina.swaglabs.components.android;

import com.solvd.carina.swaglabs.components.common.SortModalBase;
import com.zebrunner.carina.utils.android.IAndroidUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SortModal extends SortModalBase implements IAndroidUtils {

    @FindBy(xpath = "//android.widget.TextView[@text='Name (A to Z)']")
    private ExtendedWebElement nameAToZ;

    @FindBy(xpath = "//android.widget.TextView[@text='Name (Z to A)']")
    private ExtendedWebElement nameZToA;

    @FindBy(xpath = "//android.widget.TextView[@text='Price (low to high)']")
    private ExtendedWebElement priceLowToHigh;

    @FindBy(xpath = "//android.widget.TextView[@text='Price (high to low)']")
    private ExtendedWebElement priceHighToLow;

    public SortModal(WebDriver driver) {
        super(driver);
    }

    @Override
    public void sortByNameAToZ() {
        tap(nameAToZ);
    }

    @Override
    public void sortByNameZToA() {
        tap(nameZToA);
    }

    @Override
    public void sortByPriceLowToHigh() {
        tap(priceLowToHigh);
    }

    @Override
    public void sortByPriceHighToLow() {
        tap(priceHighToLow);
    }

}
