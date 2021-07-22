package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForElement {

    public static WebElement waitToBeClickable(WebDriver driver, By selector, int waitInterval) {
        WebElement element = (new WebDriverWait(driver, waitInterval)).until(ExpectedConditions.elementToBeClickable(selector));
        return element;
    }

    public static WebElement waitForElementPresence(WebDriver driver, By selector, int waitInterval) {
        WebElement element = (new WebDriverWait(driver, waitInterval)).until(ExpectedConditions.visibilityOfElementLocated(selector));
        return element;
    }
    public static WebElement waitForElementLocated(WebDriver driver, String selector, int waitInterval, String parameter) {
        WebElement element = (new WebDriverWait(driver, waitInterval)).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(String.format(selector, parameter)))));
        return element;
    }
}

