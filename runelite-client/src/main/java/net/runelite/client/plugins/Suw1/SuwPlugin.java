package net.runelite.client.plugins.Suw1;

import com.google.inject.Inject;
import net.runelite.api.Actor;
import net.runelite.api.Client;
import net.runelite.api.events.GameTick;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayManager;

@PluginDescriptor(name = "Suw", description = "SuwPlugin", tags = {"stake", "pvp", "OP"}, enabledByDefault = false)
public class SuwPlugin extends Plugin {

    public boolean hpislow;

    @Inject
    Client client;

    @Inject
    SuwOverlay Overlay;

    @Inject
    private OverlayManager overlayManager;

    @Override
    protected void startUp() throws Exception {
        overlayManager.add(Overlay);
    }
    @Subscribe
    public void onGameTick(GameTick event) {
        Actor myPlayer = client.getLocalPlayer();
        int myHp = myPlayer.getHealth();
        if (myHp > 15) {
            hpislow = true;
        }
    }

}
