package GUI;

import java.awt.FlowLayout;
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

import db.connectDatabase;
import dao.dao; 
import model.model;

public class delete extends JFrame implements ActionListener, MouseListener{

	private JButton home = new JButton("Home");
	private JButton delete = new JButton("Delete");

	public delete() {
		deleteFrame();
	}
	
	private void deleteFrame() {
		setTitle("BobaCool");
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		setResizable(false);
		
		initDelete();
		initTable();
		deleteComponent();
		
		setVisible(true);
	}
	
	private void initDelete() {
		JLabel deleteTitle = new JLabel("Delete Menu");
		deleteTitle.setHorizontalAlignment(JLabel.CENTER);
		Font font = new Font("Chiller", Font.BOLD, 30);
		deleteTitle.setFont(font);
		add(deleteTitle);
	}
	
	private void initTable() {
		connectDatabase data = new connectDatabase();
		Vector<String> columns = new Vector<>();
		
		columns.add("ID ");
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
		table1.addMouseListener(this);
		JScrollPane scroll = new JScrollPane(table1);
		add(scroll);
	}

	
	private void deleteComponent() {
		
		JPanel deleteBtn = new JPanel();
		deleteBtn.setLayout(new GridLayout(1,2));
		
		deleteBtn.add(home);
		deleteBtn.add(delete);
		
		home.addActionListener(this);
		delete.addActionListener(this);
		
		add(deleteBtn);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		int r = table.getSelectedRow();
		System.out.println("Selected " + r);
		code = table.getValueAt(r, 0).toString();
		home = table.getValueAt(r, 1).toString();
		JOptionPane.showMessageDialog(null, "Success to delete "+id );
		model.setDataVector(dao.getData(), table);
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
		if(e.getSource() == home) {
			new home(); 
			this.dispose(); 
		}else if (e.getSource() == delete) {
			if(code.equals("")) {
				JOptionPane.showMessageDialog(null, "choose menu ");
			}
		}else {
			connectDatabase controller = new connectDatabase();
			controller.delete(code);
		}
	}
		
}

