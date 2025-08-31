package pages;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void open(String url){
        driver.get(url);
    }
    
    public WebElement find(By locator){
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void click(By locator){
        find(locator).click();
    }

    public void type(By locator, String text){
        WebElement el = find(locator);
        el.clear();
        el.sendKeys(text);
    }
}
