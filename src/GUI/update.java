package GUI;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.dao;
import model.model;

public class update extends JFrame implements ActionListener, MouseListener{
	
	Font font = new Font("Chiller", Font.BOLD, 100);
	
	JButton home = new JButton("Home");
	JButton update = new JButton("update");
	
	JTable table;
	String code ="";
	String menu ="";
	String harga ="";
	String stok ="";
	
	public update() {
		updateFrame();
	}

	private void updateFrame() {
		setTitle("BobaCool");
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setResizable(false);
		
		updateTitle();
		initTable();
		updateComponent();
	
		setVisible(true);
	}
	
	
	private void updateTitle() {
		JLabel title = new JLabel("Update Data");
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
	
	private void updateComponent() {
		JPanel deleteBtn = new JPanel();
		deleteBtn.setLayout(new GridLayout(1,2));
		
		deleteBtn.add(home);
		deleteBtn.add(update);
		
		home.addActionListener(this);
		update.addActionListener(this);
		
		add(deleteBtn);
	}

	private model getData() {
		int r = table.getSelectedRow();
		
		String code = table.getValueAt(r, 0).toString();
		String nama = table.getValueAt(r, 1).toString();
		String harga = table.getValueAt(r, 2).toString();
		String stock = table.getValueAt(r, 3).toString();
	
		return new model (nama, code, harga , stock); 
	}

	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		System.out.println("mouse click");
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(update)) {
			if(code.equals("")) {
				JOptionPane.showMessageDialog(null, "choose menu ");
			}
			else {
				updatesubmit submit = new updatesubmit();
				submit.initForm(code, menu, harga, stok);
				submit.setVisible(true);
			}
		}
		
		else if(e.getSource().equals(home)){
			new home();
			setVisible(false);
		}
		
	}

}
