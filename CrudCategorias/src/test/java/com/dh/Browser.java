package com.dh;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.AssertEquals.assertEquals;


//https://chromedriver.chromium.org/getting-started
public class Browser {

    private  WebDriver driver;
    private Assert assertEquals;

    @Before
    public void setUp() throws InterruptedException {
        // Optional. If not specified, WebDriver searches the PATH for chromedriver.

        System.setProperty("webdriver.chrome.driver", "/Users/gaghy/Documents/GitHub/grupo-06/CrudCategorias/src/test/resources/drivers/chromedriver");

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("http://www.google.com.ar/");

        //Thread.sleep(5000);  // Let the user actually see something!

        //WebElement searchBox = driver.findElement(By.name("q"));

        //searchBox.sendKeys("ChromeDriver");

        //searchBox.submit();

        //Thread.sleep(5000);  // Let the user actually see something!
    }

    @Test
    public void testDigitalBooking() {
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.clear();
        searchBox.sendKeys("Digital Booking");
        searchBox.submit();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        assertEquals.equals("Digital Booking - Buscar con Google");
    }

    @After
    public void tearDown() {
        driver.quit();
    }


}
