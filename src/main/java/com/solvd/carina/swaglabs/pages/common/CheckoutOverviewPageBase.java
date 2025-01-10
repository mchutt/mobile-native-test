package com.solvd.carina.swaglabs.pages.common;

import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

public abstract class CheckoutOverviewPageBase extends AbstractPage implements IMobileUtils {

    @ExtendedFindBy(accessibilityId = "CANCEL")
    private ExtendedWebElement cancelBtn;

    @ExtendedFindBy(accessibilityId = "FINISH")
    private ExtendedWebElement finishBtn;

    public CheckoutOverviewPageBase(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
    }

    public CheckoutCompletePageBase clickOnFinishBtn() {
        swipe(finishBtn);
        tap(finishBtn);
        return initPage(driver, CheckoutCompletePageBase.class);
    }

    public ProductsPageBase clickOnCancelBtn() {
        swipe(cancelBtn);
        tap(cancelBtn);
        return initPage(driver, ProductsPageBase.class);
    }
}
