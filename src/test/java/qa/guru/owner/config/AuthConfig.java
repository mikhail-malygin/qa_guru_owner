package qa.guru.owner.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "file:/tmp/secret.properties",
        "classpath:auth.properties"
})
public interface AuthConfig extends Config {

    @Key("username_auth")
    String username();

    @Key("password_auth")
    String password();
}
