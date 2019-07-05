package net.runelite.client.plugins.Suw;

import com.google.inject.Inject;
import net.runelite.api.*;
import net.runelite.api.events.GameTick;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.api.widgets.WidgetItem;
import net.runelite.client.Notifier;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;


import javax.annotation.Nullable;

@PluginDescriptor(name = "Suw", description = "SuwOverlay", tags = {"stake", "pvp", "OP"}, enabledByDefault = false)
public class TestPlugin extends Plugin {

    public boolean hpislow;

    @Inject
    Client client;

    @Inject
    TestOverlay Overlay;

    @Inject
    private OverlayManager overlayManager;

    @Inject
    private Notifier notifier;


    @Override
    protected void startUp() throws Exception {
        overlayManager.add(Overlay);
    }
    @Subscribe
    public void onGameTick(GameTick event) {
        Actor myplayer = client.getLocalPlayer();
        int myhp = myplayer.getHealth();
        if (myhp > 8) {
            hpislow = true;
        }
    }

        @Nullable
        private WidgetItem getItem(int id) {
            if (client.getGameState() != GameState.LOGGED_IN) {
                return null;
            }
            Widget inventory = client.getWidget(WidgetInfo.INVENTORY);
            if (inventory == null) {
                return null;
            }
            for (WidgetItem currentItem : inventory.getWidgetItems()) {
                if (currentItem == null) {
                    continue;
                }
                if (currentItem.getId() == id) {
                    return currentItem;
                }
            }
            return null;
        }

    }


