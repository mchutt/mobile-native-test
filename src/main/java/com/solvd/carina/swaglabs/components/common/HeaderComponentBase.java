package com.solvd.carina.swaglabs.components.common;

import com.solvd.carina.swaglabs.pages.common.CartPageBase;
import com.solvd.carina.swaglabs.pages.common.SideNavMenuBasePage;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class HeaderComponentBase extends AbstractUIObject implements IMobileUtils, ICustomTypePageFactory {

    public HeaderComponentBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract SideNavMenuBasePage openMenu();
    public abstract CartPageBase openCart();
}
