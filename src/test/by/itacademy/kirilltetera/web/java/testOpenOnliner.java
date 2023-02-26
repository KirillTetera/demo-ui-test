package by.itacademy.kirilltetera.web.java;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class testOpenOnliner {
    @Test
    public void testOnlinerCopyright(){
        WebDriver driver = new ChromeDriver();
        driver.navigate().to(onlinerPage.url);
        WebElement copyright = driver.findElement
                (By.xpath(onlinerPage.copyright));
        Assert.assertEquals("© 2001—2023 Onlíner", copyright.getText());
        driver.quit();
    }
    @Test
    public void testOpenOnlinerLoginForm(){
        WebDriver driver = new ChromeDriver();
        driver.navigate().to(onlinerPage.url);
        WebElement buttonEntrance = driver.findElement
                (By.xpath(onlinerPage.buttonEntrance));
        buttonEntrance.click();
        WebElement textEntrance = driver.findElement
                (By.xpath(onlinerPage.textEntrance));
        Assert.assertEquals("Вход", textEntrance.getText());
        driver.quit();
    }
    @Test
    public void testOnlinerLoginFormWithEmptyCredentials(){
        WebDriver driver = new ChromeDriver();
        driver.navigate().to(onlinerPage.url);
        WebElement buttonEntrance = driver.findElement
                (By.xpath(onlinerPage.buttonEntrance));
        buttonEntrance.click();
        WebElement buttonEnter = driver.findElement
                (By.xpath(onlinerPage.buttonEnter));
        buttonEnter.click();
        WebElement warningMessageEmptyNickOrEmail = driver.findElement
                (By.xpath(onlinerPage.warningMessageEmptyNickOrEmail));
        Assert.assertEquals("Укажите ник или e-mail", warningMessageEmptyNickOrEmail.getText());
        WebElement warningMessageEmptyPassword = driver.findElement
                (By.xpath(onlinerPage.warningMessageEmptyPassword));
        Assert.assertEquals("Укажите пароль", warningMessageEmptyPassword.getText());
        driver.quit();
    }
}
