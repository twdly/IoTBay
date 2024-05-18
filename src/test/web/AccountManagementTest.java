package web;

import isdwrk04.group5.iotbay.dao.UserDao;
import isdwrk04.group5.iotbay.model.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountManagementTest extends BaseWebTest{

    UserDao userDao;

    @BeforeEach
    public void before() {
        userDao = new UserDao();
        userDao.deleteUser("test@gmail.com");
        userDao.deleteUser("update@gmail.com");
        userDao.deleteUser("deleted");
    }

    public void createAccount() {
        driver.findElements(By.className("register-or-login")).get(0).click();
        driver.findElement(By.name("email")).sendKeys("test@gmail.com");
        driver.findElement(By.name("firstname")).sendKeys("first");
        driver.findElement(By.name("lastname")).sendKeys("second");
        driver.findElement(By.name("phoneNumber")).sendKeys("1234567890");
        driver.findElement(By.name("password")).sendKeys("password");
        driver.findElement(By.name("passwordCheck")).sendKeys("password");
        driver.findElement(By.id("register")).click();
        driver.findElement(By.cssSelector("a[href*='/account']")).click();
        driver.findElement(By.linkText("Update Account Details")).click();
    }

    @Test
    public void testUpdateDetails() {
        createAccount();

        driver.findElement(By.name("firstname")).clear();
        driver.findElement(By.name("firstname")).sendKeys("updated");
        driver.findElement(By.name("lastname")).clear();
        driver.findElement(By.name("lastname")).sendKeys("updated");
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys("update@gmail.com");
        driver.findElement(By.name("phoneNumber")).clear();
        driver.findElement(By.name("phoneNumber")).sendKeys("9876543210");

        driver.findElement(By.xpath("//button[text()='Update details']")).click();

        User user = userDao.getUserByEmail("update@gmail.com");

        Assertions.assertEquals("updated", user.getUsername().split(" ")[0]);
        Assertions.assertEquals("updated", user.getUsername().split(" ")[1]);
        Assertions.assertEquals("update@gmail.com", user.getEmail());
        Assertions.assertEquals("9876543210", user.getPhoneNo());
    }

    @Test
    public void testUpdatePassword() {
        createAccount();

        User userBeforeUpdate = userDao.getUserByEmail("test@gmail.com");

        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("updated");
        driver.findElement(By.name("passwordCheck")).clear();
        driver.findElement(By.name("passwordCheck")).sendKeys("updated");

        driver.findElement(By.xpath("//button[text()='Change password']")).click();

        User userAfterUpdate = userDao.getUserByEmail("test@gmail.com");

        Assertions.assertNotEquals(userBeforeUpdate.getHashedPassword(), userAfterUpdate.getHashedPassword());
    }

    @Test
    public void testDeleteAccount() {
        createAccount();

        driver.findElement(By.xpath("//button[text()='Deactivate Account']")).click();
        driver.switchTo().alert().accept();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(ExpectedConditions.urlToBe("http://localhost:8080/IoTBay_war_exploded/"));
        Assertions.assertNull(userDao.getUserByEmail("test@gmail.com"));
    }

    @AfterEach
    public void after() {
        userDao.deleteUser("test@gmail.com");
        userDao.deleteUser("update@gmail.com");
        userDao.deleteUser("deleted");
    }

}
