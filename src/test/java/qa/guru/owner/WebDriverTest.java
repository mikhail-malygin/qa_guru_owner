package qa.guru.owner;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import qa.guru.owner.config.WebDriverProvider;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WebDriverTest {

    private WebDriver driver;

    @BeforeEach
    public void startDriver(){
        driver = new WebDriverProvider().get();
    }

    @Test
    public void testGitHub(){
        String title = driver.getTitle();

        assertEquals("GitHub: Where the world builds software · GitHub", title );
    }

    @AfterEach
    public void stopDriver(){
        driver.quit();
    }
}
