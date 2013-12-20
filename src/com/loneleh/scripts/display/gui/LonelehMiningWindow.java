package com.loneleh.scripts.display.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.LineBorder;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import com.loneleh.scripts.LonelehMining;
import com.loneleh.scripts.framework.enums.Mine;
import com.loneleh.scripts.framework.enums.Ore;

public class LonelehMiningWindow extends JFrame
{
	private final LonelehMining lm;

	/**
	 * Create the application.
	 */
	public LonelehMiningWindow(final LonelehMining lm)
	{
		setResizable(false);
		this.lm = lm;
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		setBounds(100, 100, 425, 380);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		setTitle(lm.getName() + " - v" + lm.getVersion());
		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (InstantiationException e)
		{
			e.printStackTrace();
		}
		catch (IllegalAccessException e)
		{
			e.printStackTrace();
		}
		catch (UnsupportedLookAndFeelException e)
		{
			e.printStackTrace();
		}
		getContentPane().setLayout(null);
		
		JPanel objectivePanel = new JPanel();
		objectivePanel.setBounds(72, 5, 275, 45);
		objectivePanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		getContentPane().add(objectivePanel);
		
		JLabel lblMiningObjective = new JLabel("Mining Objective:");
		objectivePanel.add(lblMiningObjective);
		
		JPanel objectivePanelInner = new JPanel();
		objectivePanel.add(objectivePanelInner);
		
		JRadioButton rdbtnExperience = new JRadioButton("Experience");
		objectivePanelInner.add(rdbtnExperience);
		rdbtnExperience.setToolTipText("Power mining");
		
		JRadioButton rdbtnProfit = new JRadioButton("Profit");
		objectivePanelInner.add(rdbtnProfit);
		rdbtnProfit.setToolTipText("Banking");
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnExperience);
		group.add(rdbtnProfit);
		objectivePanel.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{lblMiningObjective, objectivePanelInner, rdbtnExperience, rdbtnProfit}));
		
		JPanel locationPanel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) locationPanel.getLayout();
		locationPanel.setBounds(72, 61, 275, 45);
		locationPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		getContentPane().add(locationPanel);
		
		JLabel lblMiningLocation = new JLabel("Mining Location:");
		locationPanel.add(lblMiningLocation);
		
		JPanel localtionPanelInner = new JPanel();
		locationPanel.add(localtionPanelInner);
		
		JComboBox<String> comboBoxMines = new JComboBox<String>();
		localtionPanelInner.add(comboBoxMines);
		Vector<String> comboBoxItems = new Vector<String>();
		for (Mine m : Mine.values())
			if (m.isVisibleOnGUI())
				if (m.isMember())
					comboBoxItems.add(m.getName() + " (m)");
				else
					comboBoxItems.add(m.getName());
		comboBoxMines.setModel(new DefaultComboBoxModel<String>(comboBoxItems));
		
		JScrollPane priorityScrollPane = new JScrollPane();
		priorityScrollPane.setBounds(233, 117, 170, 177);
		getContentPane().add(priorityScrollPane);
		
		JList priorityList = new JList();
		priorityScrollPane.setViewportView(priorityList);
		priorityList.setModel(new DefaultListModel());
		priorityList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		ListenablePanel oresPanel = new ListenablePanel(priorityList);
		
		for (Ore o : Ore.values())
			if (o.isAvailable())
				oresPanel.add(new JCheckBox(o.getName()));
		
		JScrollPane oresScrollPane = new JScrollPane();
		oresScrollPane.setBounds(13, 118, 210, 176);
		oresScrollPane.setViewportBorder(new LineBorder(new Color(0, 0, 0)));
		getContentPane().add(oresScrollPane);
		oresScrollPane.setViewportView(oresPanel);
		oresPanel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				
			}
		});
		btnStart.setToolTipText("Start to begin mining.");
		btnStart.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnStart.setBounds(165, 305, 89, 35);
		getContentPane().add(btnStart);
		
		JLabel lblLastUpdated = new JLabel("December 19, 2013");
		lblLastUpdated.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLastUpdated.setBounds(254, 337, 162, 14);
		getContentPane().add(lblLastUpdated);
		
		JLabel lblAuthor = new JLabel("Loneleh");
		lblAuthor.setBounds(3, 337, 155, 14);
		getContentPane().add(lblAuthor);
		
		
		
		
	}
}
