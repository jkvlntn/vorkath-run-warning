package com.vorkathrunwarning;

import net.runelite.api.Client;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;

import javax.inject.Inject;
import java.awt.Graphics2D;
import java.awt.Dimension;
import java.awt.Rectangle;

public class VorkathRunWarningTintOverlay extends Overlay {

    private final VorkathRunWarningConfig config;
    private final  VorkathRunWarningPlugin plugin;
    private final Client client;

    @Inject
    private VorkathRunWarningTintOverlay(VorkathRunWarningPlugin plugin, VorkathRunWarningConfig config, Client client) {
        this.plugin = plugin;
        this.config = config;
        this.client = client;
        setPosition(OverlayPosition.DYNAMIC);
    }

    @Override
    public Dimension render(Graphics2D graphics) {
        if (!this.plugin.isShouldWarn() || !this.config.displayTintWarning()) {
            return null;
        }
        Rectangle screenRect = new Rectangle(0, 0, this.client.getCanvasWidth(), this.client.getCanvasHeight());
        graphics.setColor(this.config.tintColor());
        graphics.fill(screenRect);
        graphics.draw(screenRect);
        return null;
    }
}
