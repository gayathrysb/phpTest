package TestNG;

import org.openqa.selenium.By;
import org.testng.annotations.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;
import org.testng.Assert;
import org.openqa.selenium.chrome.ChromeOptions;

public class phptest1  {
    ChromeDriver driver;

    @BeforeMethod
    public void launch() {
        System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver");


        ChromeOptions options = new ChromeOptions();

        options.addArguments("--headless");
        options.addArguments("--disable-extensions"); // disabling extensions
        options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
        options.addArguments("--no-sandbox");

        driver = new ChromeDriver(options);



        //driver.manage().window().maximize();
        driver.get("http://35.244.19.79:32768/");
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

    }


    @Test
    public void verify() throws Exception {
        Thread.sleep(1000);
        driver.findElement(By.id("About Us")).click();

        String actualString = driver.findElement(By.xpath("//p[1]")).getText();
        System.out.println(actualString);
        Assert.assertTrue(actualString.contains("This is about page"));

    }


    @AfterMethod
    public void close() {
        driver.close();
    }

}
