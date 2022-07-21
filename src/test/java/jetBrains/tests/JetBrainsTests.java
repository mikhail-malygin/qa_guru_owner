package jetBrains.tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JetBrainsTests extends TestBase{

    @Test
    @Tag("jetBrains")
    public void openJetBrainsMainPage() {
        String title = driver.getTitle();

        assertEquals("JetBrains: ssential tools for software developers and teams", title );
    }
}
