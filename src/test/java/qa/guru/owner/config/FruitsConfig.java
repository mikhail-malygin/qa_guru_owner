package qa.guru.owner.config;

import org.aeonbits.owner.Config;

import java.util.List;

public interface FruitsConfig extends Config {

    @Key("Array")
    String[] getFruitsArray();

    @Key("Array-with-default-values")
    @DefaultValue("orange, apple")
    String[] getFruitsArrayWithDefaultValues();

    @Key("list")
    List<String> getFruitsList();

    @Key("list-with-separator")
    @Separator(";")
    @DefaultValue("orange, banana")
    List<String> getFruitsListWithSeparator();

}
