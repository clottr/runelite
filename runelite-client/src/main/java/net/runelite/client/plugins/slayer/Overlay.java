/*
 * Copyright (c) 2016-2017, Adam <Adam@sigterm.info>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.ui.overlay;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.Nullable;
import lombok.Getter;
import lombok.Setter;
import net.runelite.api.widgets.WidgetItem;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.ui.overlay.components.LayoutableRenderableEntity;

@Getter
@Setter
public abstract class Overlay implements LayoutableRenderableEntity
{
    @Nullable
    private final Plugin plugin;
    private Point preferredLocation;
    private Dimension preferredSize;
    private OverlayPosition preferredPosition;
    private Rectangle bounds = new Rectangle();
    private OverlayPosition position = OverlayPosition.TOP_LEFT;
    private OverlayPriority priority = OverlayPriority.NONE;
    private OverlayLayer layer = OverlayLayer.UNDER_WIDGETS;
    private final List<OverlayMenuEntry> menuEntries = new ArrayList<>();

    protected Overlay()
    {
        plugin = null;
    }

    protected Overlay(Plugin plugin)
    {
        this.plugin = plugin;
    }

    /**
     * Overlay name, used for saving the overlay, needs to be unique
     * @return overlay name
     */
    public String getName()
    {
        return this.getClass().getSimpleName();
    }

    protected abstract Collection<Object> getGhosts();

    @Override
    public Void render(Graphics2D graphics) {

        return null;
    }

    public abstract Void renderItemOverlay(Graphics2D graphics, int itemId, WidgetItem itemWidget);
}
