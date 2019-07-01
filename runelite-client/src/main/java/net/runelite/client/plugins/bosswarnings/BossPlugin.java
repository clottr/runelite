package net.runelite.client.plugins.bosswarnings;

import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.cerberus.CerberusOverlay;
import net.runelite.client.ui.overlay.OverlayManager;

import javax.inject.Inject;
@PluginDescriptor(
        name = "Boss warnings",
        description = "Alerts you from fatal attacks by bosses",
        tags = {"bosses", "combat", "pve", "overlay"}
)
public class BossPlugin extends Plugin {

    @Inject
    private BossOverlay overlay;

    @Inject
    BossConfig config;

    @Inject
    private OverlayManager overlayManager;

    public BossPlugin() {
    }

    @Override
    protected void startUp() throws Exception
    {
        overlayManager.add(overlay);
    }

    @Override
    protected void shutDown() throws Exception
    {
        overlayManager.remove(overlay);
        ghosts.clear();
    }
}


