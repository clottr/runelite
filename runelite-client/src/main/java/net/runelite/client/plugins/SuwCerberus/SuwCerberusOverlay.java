package net.runelite.client.plugins.SuwCerberus;

import com.google.inject.Inject;
import net.runelite.client.game.SkillIconManager;
import net.runelite.client.plugins.cerberus.CerberusPlugin;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.ComponentOrientation;
import net.runelite.client.ui.overlay.components.PanelComponent;

import java.awt.*;

public class SuwCerberusOverlay extends Overlay
{
    private final SuwCerberusPlugin plugin;
    private final SkillIconManager iconManager;
    private final PanelComponent panelComponent = new PanelComponent();

    @Inject
    SuwCerberusOverlay(final SuwCerberusPlugin plugin, final SkillIconManager iconManager)
    {
        this.plugin = plugin;
        this.iconManager = iconManager;
        setPosition(OverlayPosition.TOP_CENTER);
        panelComponent.setOrientation(ComponentOrientation.HORIZONTAL);
    }








    @Override public Dimension render(Graphics2D graphics)
    {
        return null;
    }
}
