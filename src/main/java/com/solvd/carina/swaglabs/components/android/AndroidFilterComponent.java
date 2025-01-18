package com.solvd.carina.swaglabs.components.android;

import com.solvd.carina.swaglabs.components.common.FilterComponentBase;
import com.solvd.carina.swaglabs.enums.SortType;
import com.zebrunner.carina.utils.android.IAndroidUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AndroidFilterComponent extends FilterComponentBase implements IAndroidUtils {

    @FindBy(xpath = "//android.widget.ScrollView[@content-desc='Selector container']//android.view.ViewGroup//android.widget.TextView[contains(@text, '%s')]")
    private ExtendedWebElement sortItemsBy;

    public AndroidFilterComponent(WebDriver driver) {
        super(driver);
    }

    @Override
    public void sortBy(SortType type) {
        sortItemsBy.format(type.getValue()).click();
    }

}
