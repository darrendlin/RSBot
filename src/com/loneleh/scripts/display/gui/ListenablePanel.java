package com.loneleh.scripts.display.gui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ListenablePanel extends JPanel
{
	private final JList<String> priorityList;
	public ListenablePanel(final JList<String> l)
	{
		this.priorityList = l;
	}

	@Override
	public Component add(final Component b)
	{
		((JCheckBox)b).addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)
			{
				// add or remove from priority list
				AbstractButton button = (AbstractButton)b;
				DefaultListModel lm = (DefaultListModel)priorityList.getModel();
				if (button.isSelected()) lm.addElement(button.getText());
				else lm.removeElement(button.getText());
				priorityList.setModel(lm);
			}});
		return super.add(b);
	}
}
