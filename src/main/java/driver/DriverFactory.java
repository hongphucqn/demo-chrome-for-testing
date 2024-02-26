package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {
    //Option 1: Manually download Chrome and ChromeDriver (same version)
    public static WebDriver getChromeDriver311(){
        String pathProject = System.getProperty("user.dir");
        String pathChrome = pathProject+"\\src\\test\\resources\\chrome-win64\\chrome.exe";
        String pathChromeDriver = pathProject+"\\src\\test\\resources\\drivers\\chromedriver.exe";

        System.setProperty("webdriver.chrome.driver",pathChromeDriver);

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.setBinary(pathChrome);
        return new ChromeDriver(options); //Can run on Selenium version < 4.11.0
    }

    //Option 2: Manually download ChromeDriver (Run on default Chrome version on device)
    public static WebDriver getChromeDriver312(){
        String pathProject = System.getProperty("user.dir");
//        String pathChrome = pathProject+"\\src\\test\\resources\\chrome-win64\\chrome.exe";
        String pathChromeDriver = pathProject+"\\src\\test\\resources\\drivers\\chromedriver.exe";

        System.setProperty("webdriver.chrome.driver",pathChromeDriver);

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
//        options.setBinary(pathChrome); --> Không cần set chính xác version Chrome, sẽ chạy trên version hiện tại của máy
        return new ChromeDriver(options); //Can run on Selenium version < 4.11.0
    }

    //Option 3: Auto-downloads by WebDriverManage version >= 5.4.0
    public static WebDriver getChromeDriver321(){
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        return new ChromeDriver(options); //Need WebDriverManage ver >= 5.4.0
    }

    //Option 4: Auto-downloads by Selenium Java version >= 4.11.0
    public static WebDriver getChromeDriver322(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        return new ChromeDriver(options); //Need Selenium Java ver >= 4.11.0
    }
}