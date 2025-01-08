package com.solvd.carina.swaglabs.components.common;

import com.solvd.carina.swaglabs.pages.common.LoginPageBase;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

public class MenuComponentBase extends AbstractUIObject implements ICustomTypePageFactory {

    @ExtendedFindBy(accessibilityId = "test-LOGOUT")
    private ExtendedWebElement logoutBtn;

    public MenuComponentBase(WebDriver driver) {
        super(driver);
    }

    public LoginPageBase clickOnLogoutBtn(){
        logoutBtn.click();
        return initPage(driver, LoginPageBase.class);
    }

}
