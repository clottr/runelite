package net.runelite.client.plugins.bosswarnings;


import com.google.inject.Inject;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("boss")
public interface BossConfig extends Config

{
    @ConfigItem(
            keyName = "uniqueKey", name = "Display text", description = "Hover text")
    default boolean myCheckbox()
    {
        return true;
    }

}
