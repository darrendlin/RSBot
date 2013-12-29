package com.loneleh.util.display.gui;

import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.AbstractButton;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ListenableOresPanel extends JPanel
{
	private final JList<String> priorityList;
	public ListenableOresPanel(final JList<String> l)
	{
		this.priorityList = l;
	}

	@Override
	public Component add(final Component b)
	{
		final AbstractButton button = (AbstractButton)b;
		button.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// add or remove from priority list
				DefaultListModel<String> lm = (DefaultListModel<String>)priorityList.getModel();
				if (e.getStateChange() == ItemEvent.SELECTED) {
					lm.addElement(button.getText());
				} else if (e.getStateChange() == ItemEvent.DESELECTED) {
					lm.removeElement(button.getText());
				}
				priorityList.setModel(lm);
			}});
		button.setEnabled(false);
		return super.add(b);
	}

}
