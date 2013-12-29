/**
 * 
 */
package com.loneleh.util.display.gui;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.loneleh.script.LonelehMining;
import com.loneleh.script.framework.LonelehContext;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

/**
 * LonelehMiningStatsWindow.java
 * 
 * @author Loneleh
 */
@SuppressWarnings("serial")
public class LonelehMiningStatsWindow extends JFrame
{
	private final LonelehMining lm;
	@SuppressWarnings("unused")
	private final LonelehContext ctx;
	
	private JPanel	contentPane;
	private JTable tableTotal;
	private JTable tableDetailed;
	private JLabel lblRuntime;
	private JLabel lblStatus;


	/**
	 * Create the frame.
	 */
	public LonelehMiningStatsWindow(final LonelehMining lm, final LonelehContext ctx) {
		setResizable(false);
		
		this.lm = lm;
		this.ctx = ctx;
		
		initialize();
	}
	
	@SuppressWarnings("deprecation")
	private void initialize() {
		setBounds(100, 100, 450, 355);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		setTitle(lm.getName() + " - v" + lm.getVersion() + " - Stats Window");
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
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRuntimeText = new JLabel("Runtime:");
		lblRuntimeText.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblRuntimeText.setBounds(39, 25, 80, 25);
		contentPane.add(lblRuntimeText);
		
		lblRuntime = new JLabel("00:00:00");
		lblRuntime.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblRuntime.setBounds(130, 25, 292, 25);
		contentPane.add(lblRuntime);
		
		JLabel lblStatusText = new JLabel("Status:");
		lblStatusText.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblStatusText.setBounds(39, 75, 80, 25);
		contentPane.add(lblStatusText);
		
		lblStatus = new JLabel("Waiting for script to begin...");
		lblStatus.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblStatus.setBounds(100, 75, 322, 25);
		contentPane.add(lblStatus);
		
		JScrollPane scrollPane1 = new JScrollPane();
		scrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane1.setBounds(22, 125, 400, 43);
		contentPane.add(scrollPane1);
		
		tableTotal = new JTable();
		tableTotal.setFillsViewportHeight(true);
		scrollPane1.setViewportView(tableTotal);
		tableTotal.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"Count", "Profit", "Experience"
			}
		) {
			Class<?>[] columnTypes = new Class[] {
				Integer.class, Integer.class, Double.class
			};
			public Class<?> getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableTotal.getColumnModel().getColumn(0).setResizable(false);
		tableTotal.getColumnModel().getColumn(0).setPreferredWidth(133);
		tableTotal.getColumnModel().getColumn(0).setMaxWidth(133);
		tableTotal.getColumnModel().getColumn(1).setResizable(false);
		tableTotal.getColumnModel().getColumn(1).setPreferredWidth(133);
		tableTotal.getColumnModel().getColumn(1).setMaxWidth(133);
		tableTotal.getColumnModel().getColumn(2).setResizable(false);
		tableTotal.getColumnModel().getColumn(2).setPreferredWidth(133);
		tableTotal.getColumnModel().getColumn(2).setMaxWidth(133);
		tableTotal.setShowGrid(false);
		tableTotal.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableTotal.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane2.setBounds(22, 193, 400, 108);
		contentPane.add(scrollPane2);
		
		tableDetailed = new JTable();
		tableDetailed.setFillsViewportHeight(true);
		scrollPane2.setViewportView(tableDetailed);
		tableDetailed.setModel(new DefaultTableModel(
			new Object[][] { },
			new String[] {
				"Ore/Gem", "Count", "Profit", "Experience"
			}
		) {
			Class<?>[] columnTypes = new Class[] {
				String.class, Integer.class, Integer.class, Double.class
			};
			public Class<?> getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tableDetailed.getColumnModel().getColumn(0).setResizable(false);
		tableDetailed.getColumnModel().getColumn(0).setPreferredWidth(100);
		tableDetailed.getColumnModel().getColumn(0).setMaxWidth(100);
		tableDetailed.getColumnModel().getColumn(1).setResizable(false);
		tableDetailed.getColumnModel().getColumn(1).setPreferredWidth(100);
		tableDetailed.getColumnModel().getColumn(1).setMaxWidth(100);
		tableDetailed.getColumnModel().getColumn(2).setResizable(false);
		tableDetailed.getColumnModel().getColumn(2).setPreferredWidth(100);
		tableDetailed.getColumnModel().getColumn(2).setMaxWidth(100);
		tableDetailed.getColumnModel().getColumn(3).setResizable(false);
		tableDetailed.getColumnModel().getColumn(3).setPreferredWidth(100);
		tableDetailed.getColumnModel().getColumn(3).setMaxWidth(100);
		tableDetailed.setShowGrid(false);
		tableDetailed.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableDetailed.getTableHeader().setReorderingAllowed(false);
	}
	
	public void setStatus(String status) {
		lblStatus.setText(status);
	}
	
	public void setRuntime(String runtime) {
		lblRuntime.setText(runtime);
	}
}
