package net.runelite.client.plugins.SuwCerberus;

import jdk.nashorn.internal.objects.annotations.Getter;
import net.runelite.api.GameState;
import net.runelite.api.NPC;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayManager;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

@PluginDescriptor(
        name = "Suw Cerberus",
        description = "Helps you with cerberus",
        tags = {"bosses", "combat", "ghosts", "prayer", "pve", "overlay", "souls"}
)
@Singleton
public class SuwCerberusPlugin extends Plugin
{
    @Getter
    private final List <NPC> ghosts = new ArrayList <>();

    @Inject
    private OverlayManager overlayManager;

    @Inject
    private SuwCerberusOverlay overlay;

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

    @Subscribe
    public void onGameStateChanged(GameStateChanged event)
    {
        GameState gameState = event.getGameState();
        if (gameState == GameState.LOGIN_SCREEN || gameState == gameState.HOPPING || gameState == GameState.CONNECTION_LOST)
        {
            ghosts.clear();
        }
    }

}



