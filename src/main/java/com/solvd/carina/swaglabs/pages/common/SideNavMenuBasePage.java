package com.solvd.carina.swaglabs.pages.common;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

public class SideNavMenuBasePage extends AbstractPage {

    @ExtendedFindBy(accessibilityId = "test-LOGOUT")
    private ExtendedWebElement logoutBtn;

    public SideNavMenuBasePage(WebDriver driver) {
        super(driver);
    }

    public LoginPageBase clickOnLogoutBtn(){
        logoutBtn.click();
        return initPage(driver, LoginPageBase.class);
    }

}
