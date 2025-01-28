package com.vorkathrunwarning;

import net.runelite.api.Client;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;

import javax.inject.Inject;
import java.awt.Graphics2D;
import java.awt.Dimension;
import java.awt.Rectangle;

public class VorkathRunWarningOverlay extends Overlay {

    private final VorkathRunWarningConfig config;
    private final  VorkathRunWarningPlugin plugin;
    private final Client client;

    @Inject
    private VorkathRunWarningOverlay(VorkathRunWarningPlugin plugin, VorkathRunWarningConfig config, Client client) {
        setPosition(OverlayPosition.DYNAMIC);
        setLayer(OverlayLayer.ABOVE_SCENE);
        this.plugin = plugin;
        this.config = config;
        this.client = client;
    }

    @Override
    public Dimension render(Graphics2D graphics) {
        if (!this.plugin.isShouldWarn()) {
            return null;
        }
        setPreferredSize(this.client.getCanvas().getSize());
        Rectangle screenRect = new Rectangle(0, 0, this.client.getCanvasWidth(), this.client.getCanvasHeight());
        graphics.setColor(this.config.warningColor());
        graphics.fill(screenRect);
        graphics.draw(screenRect);
        return screenRect.getSize();
    }
}
