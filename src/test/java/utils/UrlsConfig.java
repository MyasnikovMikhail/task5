package utils;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "system:env",
        "file:src/test/resources/urlsConfig.properties"
})
public interface UrlsConfig extends Config {
    @Key("BASE_URL")
    String baseUrl();

}
