package my.otus.jta;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;


public class AppTest 
{
    private static final Logger logger = LogManager.getLogger(AppTest.class);

    private static String OTUS_URL = "https://otus.ru/";

    private WebDriver driver;

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setupTest() {
        driver = new ChromeDriver();
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void openOtusSiteAndCheckTitle()
    {
        logger.info("Start openOtusSiteAndCheckTitle test");
        logger.info("Get otus site: {}", OTUS_URL);
        driver.get(OTUS_URL);
        logger.info("Getting otus title...");
        String title = driver.getTitle();
        logger.info("OTUS Title: {}", title);
        logger.info("Check otus title...");
        assertEquals("Онлайн‑курсы для профессионалов, дистанционное обучение современным профессиям", title);
        logger.info("OTUS title is checked");
        logger.info("End openOtusSiteAndCheckTitle test");
    }
}
