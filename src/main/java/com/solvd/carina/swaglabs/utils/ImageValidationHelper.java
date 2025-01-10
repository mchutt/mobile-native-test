package com.solvd.carina.swaglabs.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.imagecomparison.SimilarityMatchingOptions;
import io.appium.java_client.imagecomparison.SimilarityMatchingResult;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.decorators.Decorated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.lang.invoke.MethodHandles;

public class ImageValidationHelper {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private static final double MINIMUM_SIMILARITY = 0.99;

    /**
     * Returns a pure driver without listeners
     */
    private static WebDriver getPureDriver(WebDriver driver) {
        if (driver instanceof Decorated<?>) {
            driver = (WebDriver) ((Decorated<?>) driver).getOriginal();
        }
        return driver;
    }

    public static boolean compareCurrentViewAgainstBaselineImage(WebDriver driver, String baselineImagePath) {
        driver = getPureDriver(driver);
        AppiumDriver appiumDriver = (AppiumDriver) driver;

        //baselineScreenshot screenshot
        File baselineScreenshot = new File(baselineImagePath);

        //current screenshot
        File currentScreenshot = appiumDriver.getScreenshotAs(OutputType.FILE);

        //get image similarity score
        double imagesSimilarityScore;
        try {
            SimilarityMatchingResult imagesSimilarity = appiumDriver.getImagesSimilarity(baselineScreenshot, currentScreenshot);
            imagesSimilarityScore = imagesSimilarity.getScore();
        } catch (IOException e) {
            LOGGER.error("Error accessing images: {}", e.getMessage());
            return false;
        } catch (Exception e) {
            LOGGER.error("Unexpected error during image comparison: {}", e.getMessage());
            return false;
        }

        LOGGER.debug("Minimum similarity score required: {}", MINIMUM_SIMILARITY);
        LOGGER.info("Similarity score: {}", imagesSimilarityScore);
        return imagesSimilarityScore > MINIMUM_SIMILARITY;
    }

}
