package com.solvd.carina.swaglabs.pages.common;

import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

public abstract class LoginPageBase extends AbstractPage implements IMobileUtils {

    @ExtendedFindBy(accessibilityId = "test-Username")
    private ExtendedWebElement usernameInput;

    @ExtendedFindBy(accessibilityId = "test-Password")
    private ExtendedWebElement passwordInput;

    @ExtendedFindBy(accessibilityId = "test-Error message")
    private ExtendedWebElement errorMessage;

    @ExtendedFindBy(accessibilityId = "test-LOGIN")
    private ExtendedWebElement loginButton;

    public LoginPageBase(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(usernameInput);
    }

    public ProductsPageBase login(String username, String pass) {
        usernameInput.type(username);
        passwordInput.type(pass);
        tap(loginButton);
        return initPage(driver, ProductsPageBase.class);
    }

    public boolean isErrorMessagePresent() {
        return errorMessage.isElementPresent();
    }

}
