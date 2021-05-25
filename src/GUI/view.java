package GUI;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.dao;
import model.model; 

public class view extends JFrame implements ActionListener {
	
	Font font = new Font("Chiller", Font.BOLD, 100);
	
	JButton home = new JButton("Home");
	
	public view() {
		viewFrame();
	}
	
	private void viewFrame() {
		setTitle("BobaCool");
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setResizable(false);

		viewTitle();
		initTable();
		initButton();

		setVisible(true);
	}

	private void viewTitle() {
		JLabel title = new JLabel("View Menu");
		title.setHorizontalAlignment(JLabel.CENTER);
		title.setFont(font);
		add(title);
	}

	private void initTable() {
		dao data = new dao();
		Vector<String> columns = new Vector<>();

		columns.add("ID");
		columns.add("Nama");
		columns.add("Harga");
		columns.add("Stok");

		DefaultTableModel model= new DefaultTableModel(data.getData(), columns) {
			
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		JTable table1 = new JTable(model);
		table1.isCellEditable(0, 0);
		JScrollPane scroll = new JScrollPane(table1);
		add(scroll);
	}

	private void initButton() {
		JPanel button = new JPanel();
		button.setLayout(new GridLayout(1, 1));
		button.add(home);
		add(button);
		
		home.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(home)) {
			new home();
			setVisible(false);
		}
		
	}

}
