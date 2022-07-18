package qa.guru.owner;

import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;
import qa.guru.owner.config.MobileConfig;

import static org.assertj.core.api.Assertions.assertThat;

public class MobileTest {

    @Test
    public void mobileTests() {
        MobileConfig config = ConfigFactory.create(MobileConfig.class, System.getProperties());

        assertThat(config.getDeviceName()).isEqualTo("redmi10 Note Max");
        assertThat(config.getPlatformName()).isEqualTo("android");
        assertThat(config.getPlatformVersion()).isEqualTo("15");
    }

    @Test
    public void mobileTestsWithOverride() {
        System.setProperty("platform.version", "16");

        MobileConfig config = ConfigFactory.create(MobileConfig.class, System.getProperties());

        assertThat(config.getPlatformVersion()).isEqualTo("16");
    }

    @Test
    public void mobileTestsWithAndroid() {
        System.setProperty("device", "redmi10");

        MobileConfig config = ConfigFactory.create(MobileConfig.class, System.getProperties());

        assertThat(config.getPlatformVersion()).isEqualTo("16");
    }

    @Test
    public void mobileTestsWithIphone() {
        System.setProperty("device", "iphone-15");

        MobileConfig config = ConfigFactory.create(MobileConfig.class, System.getProperties());

        assertThat(config.getPlatformVersion()).isEqualTo("16");
    }
}
