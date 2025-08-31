package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage {

    private By searchInput = By.xpath("//input[@placeholder='Search city']");
    private By searchButton = By.xpath("//button[contains(text(),'Search')]");
    private By dropDownOption = By.xpath("//ul[@class='search-dropdown-menu']/li[1]");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void searchCity(String cityName){
        type(searchInput, cityName);
        click(searchButton);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement option = wait.until(
                ExpectedConditions.elementToBeClickable(dropDownOption)
        );
        option.click();
    }

}
