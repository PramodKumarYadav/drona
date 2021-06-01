
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static io.github.bonigarcia.wdm.DriverManagerType.CHROME;
import static org.junit.jupiter.api.Assertions.assertEquals;


class LoginTest {

    @Test
    void test()  {
        WebDriverManager.getInstance(CHROME).setup();
        WebDriver driver = new ChromeDriver();
        String AppURL = "https://www.saucedemo.com/";
        driver.get(AppURL);
        WebElement username = driver.findElement(By.id("user-name"));
        username.sendKeys( "standard_user");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");
        WebElement submitButton = driver.findElement(By.id("login-button"));
        submitButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement titleElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class = 'title']")));
        assertEquals(titleElement.getAttribute(("innerHTML")),"Products");
        driver.quit();
    }
}
