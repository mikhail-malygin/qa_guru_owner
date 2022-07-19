package web.tests.config;

import org.aeonbits.owner.Config;
import qa.guru.owner.config.Browser;

import java.net.URL;

@Config.Sources({
        "classpath:${host}.properties"
})
public interface WebDriverConfig extends Config {

    @Key("baseUrl")
    @DefaultValue("https://www.jetbrains.com/")
    String getBaseUrl();

    @Key("browser")
    @DefaultValue("CHROME")
    Browser getBrowser();

    @Key("remoteUrl")
    URL getRemoteURL();

    @Key("browserVersion")
    @DefaultValue("100")
    String getBrowserVersion();

    @Key("browserResolution")
    @DefaultValue("1920x1080")
    String getBrowserResolution();
}
