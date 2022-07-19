package jetBrains.tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JetBrainsTests extends TestBase{

    private WebDriver driver;

    @Test
    @Tag("jetBrains")
    public void openJetBrainsMainPage() {
        String title = driver.getTitle();

        assertEquals("JetBrains: Essential tools for software developers and teams", title );
    }
}
