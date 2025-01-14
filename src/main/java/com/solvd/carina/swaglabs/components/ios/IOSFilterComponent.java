package com.solvd.carina.swaglabs.components.ios;

import com.solvd.carina.swaglabs.components.common.FilterComponentBase;
import com.solvd.carina.swaglabs.enums.SortType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

public class IOSFilterComponent extends FilterComponentBase implements IMobileUtils {

    @ExtendedFindBy(accessibilityId = "%s")
    private ExtendedWebElement sortItemsBy;

    public IOSFilterComponent(WebDriver driver) {
        super(driver);
    }

    @Override
    public void sortBy(SortType type) {
        sortItemsBy.format(type.getValue()).click();
    }

}
