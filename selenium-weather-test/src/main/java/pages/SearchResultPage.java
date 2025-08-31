package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchResultPage extends BasePage {

    private By cityName = By.xpath("//div[contains(@class,'current-container')]//h2");
    private By currentTime = By.xpath("//div[contains(@class,'current-container')]//span[contains(@class,'orange-text')]");
    private By temperature = By.xpath("//div[contains(@class,'current-temp')]//span[contains(@class,'heading')]");


    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public String getCityName() {
        WebElement res = wait.until(
                ExpectedConditions.visibilityOfElementLocated(cityName)
        );
        return res.getText();
    }

    public String getCurrentTime(){
        return find(currentTime).getText();
    }

    public String getTemperature(){
        return find(temperature).getText();
    }

    public boolean verifyCity(String expectedCity) {
        // Wait until the city header contains the expected city to avoid timing issues
        boolean matched = wait.until(ExpectedConditions.textToBePresentInElementLocated(cityName, expectedCity));
        String actualCity = getCityName();
        System.out.println("DEBUG - actual city name: " + actualCity);
        System.out.println("DEBUG - expected city: " + expectedCity);
        return matched;
    }


    public boolean verifyCurrentTime(){
        String pageTime = getCurrentTime().trim().toLowerCase();
        ZonedDateTime nowLA = ZonedDateTime.now(ZoneId.of("America/Los_Angeles"));
        String expected = nowLA.format(DateTimeFormatter.ofPattern("MMM dd, hh:mma")).toLowerCase();

        System.out.println("DEBUG - actual page time: " + pageTime);
        System.out.println("DEBUG - expected time: " + expected);

        return pageTime.equals(expected);
    }

    public boolean verifyTemperature() {
        String temp = getTemperature();
        Pattern pattern = Pattern.compile("-?\\d+");
        Matcher matcher = pattern.matcher(temp);

        System.out.println("DEBUG - actual temperature text: " + temp);
        System.out.println("DEBUG - expected pattern: -?\\d+ (must contain a number)");

        return matcher.find();
    }

}
