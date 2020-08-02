package test.automation.twitter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class LoginHelper {
    WebDriver driver;

    public LoginHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void navigate_to_twitter_page() {
        this.driver.get("https://twitter.com/twitter");
        this.driver.manage().window().maximize();
    }

    public void navigate_to_login_page() {
        this.driver.findElement(By.xpath("//a[@data-testid=\"login\"]")).click();
    }

    public void enter_user_name_as(String userid) {
        WebDriverWait wait = new WebDriverWait(this.driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name=\"session[username_or_email]\"]")));

        this.driver.findElement(By.xpath("//input[@name=\"session[username_or_email]\"]")).sendKeys(userid);
    }

    public void enter_password_as(String password) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name=\"session[password]\"]")));

        this.driver.findElement(By.xpath("//input[@name=\"session[password]\"]")).sendKeys(password);
    }

    public void click_login_botton() {
        this.driver.findElement(By.xpath("//div[@data-testid=\"LoginForm_Login_Button\"]")).click();
    }

    public void login_should_be_successful() {
        String url = this.driver.getCurrentUrl();
        assertEquals("Login Success", url, "https://twitter.com/twitter");
        assertEquals("Success", url);
    }
}