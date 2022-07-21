package jetBrains.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.Objects;
import java.util.function.Supplier;

import static java.lang.String.format;

public class WebDriverProvider implements Supplier<WebDriver> {

    private final WebDriverConfig config;
    static CredentialsConfig credentialsConfig  = ConfigFactory.create(CredentialsConfig.class);

    public WebDriverProvider() {
        this.config = ConfigFactory.create(WebDriverConfig.class, System.getProperties());
    }

    @Override
    public WebDriver get() {
        WebDriver driver = createDriver();
        driver.get(config.getBaseUrl());

        return driver;
    }

    public WebDriver createDriver() {
        String login = credentialsConfig.login();
        String password = credentialsConfig.password();

        if (Objects.isNull(format("https://%s:%s@%s", login, password, config.getRemoteURL()))) {
            switch (config.getBrowser()) {
                case CHROME: {
                    WebDriverManager.chromedriver().setup();
                    return new ChromeDriver();
                }
                case FIREFOX: {
                    WebDriverManager.firefoxdriver().setup();
                    return new FirefoxDriver();
                }
                default: {
                    throw new RuntimeException("No such driver");
                }
            }
        }
        else {
            switch (config.getBrowser()) {
                case CHROME: {
                    RemoteWebDriver remoteChromeWebDriver = new RemoteWebDriver(config.getRemoteURL(), new ChromeOptions());
                    return remoteChromeWebDriver;
                }
                case FIREFOX: {
                    RemoteWebDriver remoteFirefoxWebDriver = new RemoteWebDriver(config.getRemoteURL(), new FirefoxOptions());
                    return remoteFirefoxWebDriver;
                }
                default: {
                    throw new RuntimeException("No such driver");
                }
            }
        }
    }
}