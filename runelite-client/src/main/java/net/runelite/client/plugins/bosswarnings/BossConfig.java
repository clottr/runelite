package net.runelite.client.plugins.bosswarnings;


import com.google.inject.Inject;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("boss")
public interface BossConfig extends Config
{
    @ConfigItem(
            keyName = "ON?", name = "All alerts on", description = "Alerts you of all bosses")
    default boolean myCheckbox()
    {
        return true;
    }

}
