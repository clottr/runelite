package net.runelite.client.plugins.Suw;

import com.google.inject.Inject;
import net.runelite.api.Client;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;

import java.awt.*;

public class TestOverlay extends Overlay {

    @Inject
    TestPlugin plugin;

    private final Client client;

    @Inject TestOverlay(Client client,TestPlugin plugin) {

        setPriority(OverlayPriority.HIGH);
        setPosition(OverlayPosition.DYNAMIC);
        this.client = client;
        this.plugin = plugin;

    }

    @Override
    public Dimension render(Graphics2D graphics) {
      if(plugin.hpislow){
          graphics.setColor(Color.RED);
          String type = "Hp is low";
          graphics.drawString(type, 100, 100);

      }

        return null;
    }
}
