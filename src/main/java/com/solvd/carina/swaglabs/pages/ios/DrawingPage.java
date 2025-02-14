package com.solvd.carina.swaglabs.pages.ios;

import com.solvd.carina.swaglabs.pages.common.DrawingPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.ios.IOSUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = DrawingPageBase.class)
public class DrawingPage extends DrawingPageBase implements IOSUtils {


    @ExtendedFindBy(accessibilityId = "Signature Pad demo")
    private ExtendedWebElement screen;

    @ExtendedFindBy(accessibilityId = "test-CLEAR")
    private ExtendedWebElement cleanBtn;

    @ExtendedFindBy(image = "images/text.png")
    private ExtendedWebElement title;

    public DrawingPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(title);
    }

    @Override
    public void drawShape() {
        drawShape(screen);
    }

    @Override
    public void clickOnCleanBtn() {
        cleanBtn.click();
    }

}
