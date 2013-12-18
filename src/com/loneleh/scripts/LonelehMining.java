package com.loneleh.scripts;

import java.awt.Graphics;

import org.powerbot.event.MessageEvent;
import org.powerbot.event.MessageListener;
import org.powerbot.event.PaintListener;
import org.powerbot.script.Manifest;
import org.powerbot.script.PollingScript;


@Manifest(name = "LonelehMining", description = "Mines the stuff you want ;)", hidden = true)

public class LonelehMining extends PollingScript implements MessageListener, PaintListener
{
	
	@Override
	public int poll()
	{
		return 0;
	}

	@Override
	public void repaint(Graphics g)
	{
		
	}

	@Override
	public void messaged(MessageEvent e)
	{
		
	}
}
