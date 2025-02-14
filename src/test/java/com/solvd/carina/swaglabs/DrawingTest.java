package com.solvd.carina.swaglabs;

import com.solvd.carina.swaglabs.pages.common.DrawingPageBase;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.R;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.solvd.carina.swaglabs.utils.ImageValidationHelper.compareCurrentViewAgainstBaselineImage;

public class DrawingTest extends SwagLabsAbstractTest {

    public static final String IOS_BASELINE_PNG = "images/ios-baseline.png";
    public static final String ANDROID_BASELINE_PNG = "images/android-baseline.png";
    public static final String PLATFORM = R.CONFIG.get("capabilities.platformName");

    @Test
    @MethodOwner(owner = "mchutt")
    public void verifyDrawingFeatureTest() {
        DrawingPageBase drawingPage = login().getHeader().openMenu().clickOnDrawingBtn();
        if ("ios".equalsIgnoreCase(PLATFORM)) {
            verifyDrawingFeature(drawingPage, IOS_BASELINE_PNG);
        } else {
            verifyDrawingFeature(drawingPage, ANDROID_BASELINE_PNG);
        }
    }

    private void verifyDrawingFeature(DrawingPageBase drawingPage, String baseline) {
        Assert.assertTrue(drawingPage.isPageOpened(), "Drawing page is not opened!");
        Assert.assertFalse(compareCurrentViewAgainstBaselineImage(getDriver(), baseline), "The drawn shape shouldn't be present!");
        drawingPage.drawShape();
        Assert.assertTrue(compareCurrentViewAgainstBaselineImage(getDriver(), baseline), "The drawn shape is not present! Minimum similarity not met!");
        drawingPage.clickOnCleanBtn();
        Assert.assertFalse(compareCurrentViewAgainstBaselineImage(getDriver(), baseline), "The drawn shape shouldn't be present!");
    }

}
