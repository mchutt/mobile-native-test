package com.solvd.carina.swaglabs;

import com.solvd.carina.swaglabs.pages.common.DrawingPageBase;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.solvd.carina.swaglabs.utils.ImageValidationHelper.compareCurrentViewAgainstBaselineImage;

public class DrawingTest extends SwagLabsAbstractTest {

    public static final String BASELINE_PNG = "images/baseline.png";

    @Test(description = "This test only runs on ios platform yet")
    @MethodOwner(owner = "mchutt")
    public void verifyDrawingFeature() {
        DrawingPageBase drawingPage = login().getHeader().openMenu().clickOnDrawingBtn();
        Assert.assertTrue(drawingPage.isPageOpened(), "Drawing page is not opened!");
        Assert.assertFalse(compareCurrentViewAgainstBaselineImage(getDriver(), BASELINE_PNG),
                "The drawn shape shouldn't be present!");
        drawingPage.drawShape();
        Assert.assertTrue(compareCurrentViewAgainstBaselineImage(getDriver(), BASELINE_PNG),
                "The drawn shape is not present! Minimum similarity not met!");
        drawingPage.clickOnCleanBtn();
        Assert.assertFalse(compareCurrentViewAgainstBaselineImage(getDriver(), BASELINE_PNG),
                "The drawn shape shouldn't be present!");
    }

}
