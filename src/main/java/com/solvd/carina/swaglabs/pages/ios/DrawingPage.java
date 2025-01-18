package com.solvd.carina.swaglabs.pages.ios;

import com.solvd.carina.swaglabs.pages.common.DrawingPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.ios.IOSUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
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
        Point position = screen.getLocation();
        Dimension size = screen.getSize();

        int startX = position.x + size.width / 4;
        int startY = position.y + size.height / 6;
        int endX = startX + size.width / 2;
        int endY = startY - size.height / 10;

        swipe(startX, startY, endX, startY, 1000);
        swipe(endX, startY, endX, endY, 1000);
        swipe(endX, endY, startX, endY, 1000);
        swipe(startX, endY, startX, startY, 1000);
        int midY = (startY + endY) / 2;
        swipe(startX, midY, endX, midY, 1000);
    }

    @Override
    public void clickOnCleanBtn() {
        cleanBtn.click();
    }

}
