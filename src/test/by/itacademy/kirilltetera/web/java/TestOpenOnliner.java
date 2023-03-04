package by.itacademy.kirilltetera.web.java;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestOpenOnliner {
    WebDriver driver;
    @Before
    public void preporation(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test
    public void testOnlinerCopyright(){
        driver.navigate().to(OnlinerPage.url);
        WebElement copyright = driver.findElement(By.xpath(OnlinerPage.copyright));
        Assert.assertEquals("© 2001—2023 Onlíner", copyright.getText());
    }
    @Test
    public void testOpenOnlinerLoginForm(){
        driver.navigate().to(OnlinerPage.url);
        WebElement buttonEntrance = driver.findElement(By.xpath(OnlinerPage.buttonEntrance));
        buttonEntrance.click();
        WebElement textEntrance = driver.findElement(By.xpath(OnlinerPage.textEntrance));
        Assert.assertEquals("Вход", textEntrance.getText());
    }
    @Test
    public void testOnlinerLoginFormWithEmptyCredentials(){
        driver.navigate().to(OnlinerPage.url);
        WebElement buttonEntrance = driver.findElement(By.xpath(OnlinerPage.buttonEntrance));
        buttonEntrance.click();
        WebElement buttonEnter = driver.findElement(By.xpath(OnlinerPage.buttonEnter));
        buttonEnter.click();
        WebElement warningMessageEmptyNickOrEmail = driver.findElement
                (By.xpath(OnlinerPage.warningMessageEmptyNickOrEmail));
        Assert.assertEquals("Укажите ник или e-mail", warningMessageEmptyNickOrEmail.getText());
        WebElement warningMessageEmptyPassword = driver.findElement
                (By.xpath(OnlinerPage.warningMessageEmptyPassword));
        Assert.assertEquals("Укажите пароль", warningMessageEmptyPassword.getText());
    }
    @Test
    public void testOnlinerLoginFormWithEmptyPassword() {
        driver.navigate().to(OnlinerPage.url);
        WebElement buttonEntrance = driver.findElement
                (By.xpath(OnlinerPage.buttonEntrance));
        buttonEntrance.click();
        WebElement inputNickOrEmail = driver.findElement
                (By.xpath(OnlinerPage.inputNickOrEmail));
        inputNickOrEmail.sendKeys("test@gmail.com");
        WebElement buttonEnter = driver.findElement
                (By.xpath(OnlinerPage.buttonEnter));
        buttonEnter.click();
        WebElement warningMessageEmptyPassword = new WebDriverWait(driver, Duration.ofSeconds(1))
                .until(ExpectedConditions
                        .visibilityOfElementLocated(By.xpath(OnlinerPage.warningMessageEmptyPassword)));
        Assert.assertEquals("Укажите пароль", warningMessageEmptyPassword.getText());
    }
    @After
    public void tearDown() {
        driver.quit();
    }
}
