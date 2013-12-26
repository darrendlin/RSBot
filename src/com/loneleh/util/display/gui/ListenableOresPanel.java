package com.loneleh.util.display.gui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)
			{
				// add or remove from priority list
				DefaultListModel<String> lm = (DefaultListModel<String>)priorityList.getModel();
				if (button.isSelected()) lm.addElement(button.getText());
				else lm.removeElement(button.getText());
				priorityList.setModel(lm);
			}});
		return super.add(b);
	}
}
