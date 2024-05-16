package web;

import isdwrk04.group5.iotbay.dao.UserDao;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class RegisterWebTest extends BaseWebTest {

    UserDao userDao;

    @BeforeEach
    public void before() {
        userDao = new UserDao();
        userDao.deleteUser("test@gmail.com");
    }

    @Test
    public void testRegister() {
        driver.findElements(By.className("register-or-login")).get(0).click();
        driver.findElement(By.name("email")).sendKeys("test@gmail.com");
        driver.findElement(By.name("firstname")).sendKeys("first");
        driver.findElement(By.name("lastname")).sendKeys("second");
        driver.findElement(By.name("phoneNumber")).sendKeys("1234567890");
        driver.findElement(By.name("password")).sendKeys("password");
        driver.findElement(By.name("passwordCheck")).sendKeys("password");
        driver.findElement(By.id("register")).click();
        String message = driver.findElement(By.className("welcome")).getText();
        Assertions.assertTrue(message.contains("Welcome first second"));
        Assertions.assertTrue(message.contains("Your email is test@gmail.com"));
    }

    // This test assumes that you have populated your database with the sample data
    @Test
    public void testLogin() {
        WebElement accountDiv = driver.findElement(By.className("register-or-login"));
        accountDiv.findElements(By.xpath(".//*")).get(1).click();
        driver.findElement(By.name("email")).sendKeys("johnshep@email.com");
        WebElement passwordBox = driver.findElement(By.name("password"));
        passwordBox.sendKeys("password");
        passwordBox.sendKeys(Keys.TAB);
        passwordBox.sendKeys(Keys.ENTER);
        String message = driver.findElement(By.className("welcome")).getText();
        Assertions.assertTrue(message.contains("Welcome John Sheppard"));
        Assertions.assertTrue(message.contains("Your email is johnshep@email.com"));
    }

    @AfterEach
    public void after() {
        driver.findElement(By.className("btn-outline-light")).click();
        userDao.deleteUser("test@gmail.com");
    }
}
