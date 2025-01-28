package com.vorkathrunwarning;

import net.runelite.client.config.Alpha;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

import java.awt.Color;

@ConfigGroup("vorkathrunwarning")
public interface VorkathRunWarningConfig extends Config
{
	@Alpha
	@ConfigItem(
		keyName = "warningColor",
		name = "Warning Color",
		description = "Color used for the run warning overlay"
	)
	default Color warningColor()
	{
		return new Color(255, 127, 127, 50);
	}
}
