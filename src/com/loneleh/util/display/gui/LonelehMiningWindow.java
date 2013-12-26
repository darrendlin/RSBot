package com.loneleh.util.display.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.AbstractButton;
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

import com.loneleh.game.mining.MineType;
import com.loneleh.game.mining.MineralType;
import com.loneleh.game.mining.RockType;
import com.loneleh.scripts.LonelehMining;
import com.loneleh.util.factories.MineTypeFactory;

/**
 * LonelehMiningWindow.java
 * 
 * @author Loneleh
 */
@SuppressWarnings("serial")
public class LonelehMiningWindow extends JFrame
{
	private final LonelehMining lm;
	private JPanel objectivePanel;
	private JLabel lblMiningObjective;
	private JPanel objectivePanelInner;
	private JRadioButton rdbtnExperience;
	private JRadioButton rdbtnProfit;
	private JPanel locationPanel;
	private JLabel lblMiningLocation;
	private JPanel localtionPanelInner;
	private JComboBox<String> comboBoxMines;
	private JScrollPane priorityScrollPane;
	private JList<String> priorityList;
	private JScrollPane oresScrollPane;
	private ListenableOresPanel oresPanel;
	private JButton btnStart;
	private JLabel lblLastUpdated;
	private JLabel lblAuthor;
	private ButtonGroup group;

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
	@SuppressWarnings("deprecation")
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
		
		objectivePanel = new JPanel();
		objectivePanel.setBounds(72, 9, 275, 45);
		objectivePanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		getContentPane().add(objectivePanel);
		
		lblMiningObjective = new JLabel("Mining Objective:");
		objectivePanel.add(lblMiningObjective);
		
		objectivePanelInner = new JPanel();
		objectivePanel.add(objectivePanelInner);
		
		rdbtnExperience = new JRadioButton("Experience");
		rdbtnExperience.setSelected(true);
		objectivePanelInner.add(rdbtnExperience);
		rdbtnExperience.setToolTipText("Power mining");
		
		rdbtnProfit = new JRadioButton("Profit");
		objectivePanelInner.add(rdbtnProfit);
		rdbtnProfit.setToolTipText("Banking");
		
		group = new ButtonGroup();
		group.add(rdbtnExperience);
		group.add(rdbtnProfit);
		objectivePanel.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{lblMiningObjective, objectivePanelInner, rdbtnExperience, rdbtnProfit}));
		
		locationPanel = new JPanel();
		locationPanel.setBounds(72, 63, 275, 45);
		locationPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		getContentPane().add(locationPanel);
		
		lblMiningLocation = new JLabel("Mining Location:");
		locationPanel.add(lblMiningLocation);
		
		localtionPanelInner = new JPanel();
		locationPanel.add(localtionPanelInner);
		
		comboBoxMines = new JComboBox<String>();
		comboBoxMines.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MineType m = MineTypeFactory.getMine(comboBoxMines.getSelectedItem().toString());
				
				for (Component c : oresPanel.getComponents()) {
					boolean contains = false;
					for (RockType t : m.getRocks()) {
						if (((AbstractButton)c).getText().equalsIgnoreCase(t.getMineral().getName())) {
							contains = true;
						}
					}
					c.setEnabled(contains);
				}
			}
		});
		localtionPanelInner.add(comboBoxMines);
		Vector<String> comboBoxItems = new Vector<String>();
		for (MineType m : MineType.values())
			if (m.isVisible())
				if (m.isMember())
					comboBoxItems.add(m.getName() + " (m)");
				else
					comboBoxItems.add(m.getName());
		comboBoxMines.setModel(new DefaultComboBoxModel<String>(comboBoxItems));
		
		priorityScrollPane = new JScrollPane();
		priorityScrollPane.setBounds(233, 117, 170, 177);
		getContentPane().add(priorityScrollPane);
		
		priorityList = new JList<String>();
		priorityScrollPane.setViewportView(priorityList);
		priorityList.setModel(new DefaultListModel<String>());
		priorityList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		oresPanel = new ListenableOresPanel(priorityList);
		
		for (MineralType t : MineralType.values())
			if (!t.isGem())
				oresPanel.add(new JCheckBox(t.getName()));
		
		oresScrollPane = new JScrollPane();
		oresScrollPane.setBounds(13, 117, 210, 176);
		oresScrollPane.setViewportBorder(new LineBorder(new Color(0, 0, 0)));
		getContentPane().add(oresScrollPane);
		oresScrollPane.setViewportView(oresPanel);
		oresPanel.setLayout(new GridLayout(0, 2, 0, 0));
		
		btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				lm.log.info("Loading settings...");
				//TODO start code
			}
		});
		btnStart.setToolTipText("Start to begin mining.");
		btnStart.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnStart.setBounds(165, 303, 89, 35);
		getContentPane().add(btnStart);
		
		lblLastUpdated = new JLabel("December 25, 2013");
		lblLastUpdated.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLastUpdated.setBounds(254, 337, 162, 14);
		getContentPane().add(lblLastUpdated);
		
		lblAuthor = new JLabel("Loneleh");
		lblAuthor.setBounds(3, 337, 162, 14);
		getContentPane().add(lblAuthor);
	}
}
