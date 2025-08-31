package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.SearchResultPage;

import static org.junit.jupiter.api.Assertions.*;

public class WeatherTest {
    private WebDriver driver;
    private HomePage homePage;
    private SearchResultPage resultPage;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        resultPage = new SearchResultPage(driver);
    }

    @Test
    public void testWeatherCitySearch() {
        homePage.open("https://openweathermap.org/");
        homePage.searchCity("Los Angeles, US");

        assertTrue(resultPage.verifyCity("Los Angeles"), "City name not correct!");
        assertTrue(resultPage.verifyCurrentTime(), "Date not correct!");
        assertTrue(resultPage.verifyTemperature(), "Temperature not numeric!");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
