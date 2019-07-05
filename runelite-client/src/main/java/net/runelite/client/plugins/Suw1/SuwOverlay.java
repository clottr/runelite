package net.runelite.client.plugins.Suw1;

import com.google.inject.Inject;
import net.runelite.api.Client;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;

import java.awt.*;

public class SuwOverlay extends Overlay {

    @Inject
    SuwPlugin plugin;

    private final Client client;

    @Inject SuwOverlay(Client client,SuwPlugin plugin) {

        setPriority(OverlayPriority.HIGH);
        setPosition(OverlayPosition.DYNAMIC);
        this.client = client;
        this.plugin = plugin;
    }

    @Override
    public Dimension render(Graphics2D graphics) {
        if (plugin.hpislow) {
            graphics.setColor(Color.red);
            String type = "EAT UP";
            graphics.drawString(type, 250, 250);
        }
        return null;
    }
}
