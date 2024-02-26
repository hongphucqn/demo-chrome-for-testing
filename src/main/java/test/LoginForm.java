package test;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginForm {
    public static void main(String[] args) {
        //1. Init WebDriver session
        WebDriver driver = DriverFactory.getChromeDriver322(); //Select once on 4 ways to initial WebDriver

        //2. Open target page
        driver.get("https://the-internet.herokuapp.com/login");

        //3. Find elements
        WebElement ipEmail = driver.findElement(By.id("username"));
        WebElement ipPassword = driver.findElement(By.id("password"));
        WebElement btnLogin = driver.findElement(By.xpath("//button[@type='submit']"));

        //4. Action elements
        ipEmail.sendKeys("hongphuc");
        ipPassword.sendKeys("Aa@123456");
        btnLogin.click();

        //5. Quit browser session
        try{
            Thread.sleep(1500);
        } catch (Exception ignored){}
        driver.close();
        driver.quit();
        System.out.println("End.");
    }
}