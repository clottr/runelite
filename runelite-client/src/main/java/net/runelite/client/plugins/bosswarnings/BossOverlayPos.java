package net.runelite.client.plugins.bosswarnings;

import com.google.inject.Injector;
import net.runelite.api.widgets.WidgetItem;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;

import java.awt.*;

public interface BossOverlayPos {
    Injector getInjector();

    void setPosition(OverlayPosition position);

    void setPriority(OverlayPriority priority);

    Void renderItemOverlay(Graphics2D graphics,int itemId,WidgetItem itemWidget);
}
