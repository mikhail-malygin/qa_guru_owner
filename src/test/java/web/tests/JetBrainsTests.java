package web.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import web.tests.config.WebDriverProvider;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JetBrainsTests {

    private WebDriver driver;

    @BeforeEach
    public void startDriver(){
        driver = new WebDriverProvider().get();
    }

    @Test
    public void openJetBrainsMainPage() {
        String title = driver.getTitle();

        assertEquals("JetBrains: Essential tools for software developers and teams", title );
    }

    @AfterEach
    public void stopDriver(){
        driver.quit();
    }
}
