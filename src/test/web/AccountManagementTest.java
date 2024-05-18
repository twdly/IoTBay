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
//        Clean up test data before each test
        userDao.deleteUser("test@gmail.com");
        userDao.deleteUser("update@gmail.com");
        userDao.deleteUser("deleted");
    }

    //    Helper method to create a new account for testing
    public void createAccount() {
        driver.findElement(By.linkText("Register")).click();
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

//        Update account details
        driver.findElement(By.name("firstname")).clear();
        driver.findElement(By.name("firstname")).sendKeys("updated");
        driver.findElement(By.name("lastname")).clear();
        driver.findElement(By.name("lastname")).sendKeys("updated");
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys("update@gmail.com");
        driver.findElement(By.name("phoneNumber")).clear();
        driver.findElement(By.name("phoneNumber")).sendKeys("9876543210");

        driver.findElement(By.xpath("//button[text()='Update details']")).click();

//        Verify that the account details were updated successfully
        User user = userDao.getUserByEmail("update@gmail.com");

        Assertions.assertEquals("updated", user.getUsername().split(" ")[0]);
        Assertions.assertEquals("updated", user.getUsername().split(" ")[1]);
        Assertions.assertEquals("update@gmail.com", user.getEmail());
        Assertions.assertEquals("9876543210", user.getPhoneNo());
    }

    @Test
    public void testUpdatePassword() {
        createAccount();

//        Change account password
        driver.findElement(By.name("password")).sendKeys("updatedPassword");
        driver.findElement(By.name("passwordCheck")).sendKeys("updatedPassword");

        driver.findElement(By.xpath("//button[text()='Change password']")).click();

//        Verify that the account can be accessed by the new password
        driver.findElement(By.linkText("Logout")).click();
        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.name("email")).sendKeys("test@gmail.com");
        driver.findElement(By.name("password")).sendKeys("updatedPassword");
        driver.findElement(By.xpath("//button[text()='Login']")).click();

        String message = driver.findElement(By.className("welcome")).getText();
        Assertions.assertTrue(message.contains("Welcome first second"));
        Assertions.assertTrue(message.contains("Your email is test@gmail.com"));
    }

    @Test
    public void testDeleteAccount() {
        createAccount();

//        Delete the account
        driver.findElement(By.xpath("//button[text()='Deactivate Account']")).click();
        driver.switchTo().alert().accept();
//        Wait for the account deletion has been completed
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(ExpectedConditions.urlToBe("http://localhost:8080/IoTBay_war_exploded/"));

//        Verify the account was deleted successfully
        Assertions.assertNull(userDao.getUserByEmail("test@gmail.com"));
    }

    @AfterEach
    public void after() {
//        Clean up test data after each test
        userDao.deleteUser("test@gmail.com");
        userDao.deleteUser("update@gmail.com");
        userDao.deleteUser("deleted");
    }

}
