package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForElement {

    public static void waitToBeClickable(WebDriver driver, By selector, int waitInterval) {
        new WebDriverWait(driver, waitInterval).until(ExpectedConditions.elementToBeClickable(selector));
    }

    public static void waitForElementPresence(WebDriver driver, By selector, int waitInterval) {
        new WebDriverWait(driver, waitInterval).until(ExpectedConditions.visibilityOfElementLocated(selector));
    }
    public static void waitForElementLocated(WebDriver driver, String selector, int waitInterval, String parameter) {
        new WebDriverWait(driver, waitInterval).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(String.format(selector, parameter)))));
    }
}

