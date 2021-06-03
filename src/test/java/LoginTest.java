import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static io.github.bonigarcia.wdm.DriverManagerType.CHROME;
import static org.junit.jupiter.api.Assertions.assertEquals;

// Goal is to mention everything that is wrong with below tests (which are many)
// and to then move towards a more production grade way of writing tests.
class LoginTest {
    @ParameterizedTest
    @CsvSource({"standard_user,secret_sauce"
            , "problem_user,secret_sauce"
    })
    void assertThatAValidUserCanLogIn(String userName, String password) {
        WebDriverManager.getInstance(CHROME).setup();
        WebDriver driver = new ChromeDriver();

        String AppURL = "https://www.saucedemo.com/";
        driver.get(AppURL);

        WebElement username = driver.findElement(By.id("user-name"));
        username.sendKeys(userName);
        WebElement pwd = driver.findElement(By.id("password"));
        pwd.sendKeys(password);
        WebElement submitButton = driver.findElement(By.id("login-button"));
        submitButton.click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement titleElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class = 'title']")));
        assertEquals(titleElement.getAttribute(("innerHTML")), "Products");

        driver.quit();
    }

    @Test
    void assertThatALockedOutUserCanNotLogIn() {
        WebDriverManager.getInstance(CHROME).setup();
        WebDriver driver = new ChromeDriver();

        String AppURL = "https://www.saucedemo.com/";
        driver.get(AppURL);

        WebElement username = driver.findElement(By.id("user-name"));
        username.sendKeys("locked_out_user");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");
        WebElement submitButton = driver.findElement(By.id("login-button"));
        submitButton.click();

        WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement error = driver.findElement(By.xpath("//h3[@data-test='error']"));
        System.out.println(error.getText());

        Boolean titleElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[@data-test='error']"))).isDisplayed();
        assertEquals(titleElement, true);

        driver.quit();
    }

    @Test
    void assertThatAPerformanceIssueUserCanLogInButAfterSomeDelays() {
        WebDriverManager.getInstance(CHROME).setup();
        WebDriver driver = new ChromeDriver();

        String AppURL = "https://www.saucedemo.com/";
        driver.get(AppURL);

        WebElement username = driver.findElement(By.id("user-name"));
        username.sendKeys("performance_glitch_user");
        WebElement pwd = driver.findElement(By.id("password"));
        pwd.sendKeys("secret_sauce");
        WebElement submitButton = driver.findElement(By.id("login-button"));
        submitButton.click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement titleElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class = 'title']")));
        assertEquals(titleElement.getAttribute(("innerHTML")), "Products");

        driver.quit();
    }

}
