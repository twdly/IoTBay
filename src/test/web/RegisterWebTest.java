package web;

import isdwrk04.group5.iotbay.dao.UserDao;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

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
        driver.findElement(By.name("password")).sendKeys("password");
        driver.findElement(By.name("passwordCheck")).sendKeys("password");
        driver.findElement(By.id("register")).click();
        String message = driver.findElement(By.className("welcome")).getText();
        Assertions.assertTrue(message.contains("Welcome first second"));
        Assertions.assertTrue(message.contains("Your email is test@gmail.com"));
    }

    @AfterEach
    public void after() {
        driver.findElement(By.className("logout-link")).click();
        userDao.deleteUser("test@gmail.com");
    }
}
