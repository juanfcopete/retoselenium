package org.accenture.reto.vivaair.interactions;

import net.thucydides.core.webdriver.SerenityWebdriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class JavaScriptClick {

    public static void jsOnClick(WebElement webElement)
    {
        JavascriptExecutor executor = (JavascriptExecutor) SerenityWebdriverManager.inThisTestThread().getCurrentDriver();
        executor.executeScript("arguments[0].click();", webElement);
    }
}
