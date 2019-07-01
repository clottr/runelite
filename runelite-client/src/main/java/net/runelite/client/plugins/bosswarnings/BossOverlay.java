package net.runelite.client.plugins.bosswarnings;

import net.runelite.client.game.SkillIconManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.ComponentOrientation;
import net.runelite.client.ui.overlay.components.PanelComponent;

import java.awt.*;

public class BossOverlay extends Overlay
{
    private final BossOverlay plugin;
    private final SkillIconManager iconManager;
    private final PanelComponent panelComponent = new PanelComponent();

    public BossOverlay(BossOverlay plugin, SkillIconManager iconManager) {
        this.plugin = plugin;
        this.iconManager = iconManager;
        setPosition(OverlayPosition.TOP_CENTER);
        panelComponent.setOrientation(ComponentOrientation.HORIZONTAL);
    }


    @Override
    public Dimension render(Graphics2D graphics) {
        if (!plugin.getGhosts().isEmpty()) {
            return;
        }
        return null;


    }