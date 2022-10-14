package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class BasePageObjectMethods {

    WebDriver driver;

    public BasePageObjectMethods(WebDriver driver){
        this.driver = driver;
    }

    public WebElement getElementSafely(By locator) {
        return driver.findElement(locator);
    }


}
